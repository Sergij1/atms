package com.mkyong.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.file.remote.session.Session;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.common.form.Coordinates_Ua;
import com.mkyong.common.form.Seti;
import com.mkyong.common.service.CoordinatesService;
import com.mkyong.common.service.SetiService;

import ftp.connection.file.image.bank.FtpConnection;


/*
 * controller return coordinates  ATMS  client In JSON
 */


@Controller
@RequestMapping(produces="application/json;charset=UTF-8")  

public class MovieController {
	private static final Logger logger = Logger.getLogger(MovieController.class);
	/**
	 * Injection SetiService object
	 * @see SetiService
	 */
	@Autowired
	SetiService setiService;
	/**
	 * Injection CoordinatesService object
	 * @see CoordinatesService
	 */
	@Autowired
	private CoordinatesService coordinate;
	@Autowired
	@Qualifier("ftpConnection")
	FtpConnection ftpConnection ;
	@Autowired
	@Qualifier("ftpClientFactory")
    private  DefaultFtpSessionFactory dfFtpSession;
	 /**
     * Size of a byte buffer to read/write file
     */
    private static final int BUFFER_SIZE = 4096;

	// http://192.168.0.95:8080/ubuntu/atms
	@RequestMapping(value="/{atms}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String atms, ModelMap model) {

		model.addAttribute("movie", atms);
		
		return "list";



	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/seti/{criteria}", method=RequestMethod.GET)
	public @ResponseBody String getSetiByCriteria(@PathVariable("criteria") String value, 
			@RequestParam(value="field", required=false, defaultValue="id") String field) throws IOException {
				
		List<Seti> seti = setiService.getSetiByCriteria(field, value, 0);
			
		JSONArray arr = new JSONArray();
		JSONObject res = new JSONObject();
		
		if (seti != null) {
			for (int i = 0; i < seti.size(); i++) {
				JSONObject obj = new JSONObject();
				
				obj.put("id", seti.get(i).getId());
				obj.put("seti",  seti.get(i).getName_seti_ru());
				obj.put("country",  seti.get(i).getCountry());
				
				arr.add(obj);				
			}
			
			res.put("size", seti.size());
		}			
		
		res.put("array", arr);
		res.put("field", field);
		res.put("value", value);		
		
		return res.toString();		
	}	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/coordinatesNull", method=RequestMethod.GET)
	public @ResponseBody String getCoordinatesiByNull()throws IOException {
		List<Coordinates_Ua> coordin = coordinate.geNullByCriteria();
			
		JSONArray arr = new JSONArray();
		JSONObject res = new JSONObject();
		
		if (coordin != null) {
			for (int i = 0; i < coordin.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("id", coordin.get(i).getId());
				obj.put("getX",  coordin.get(i).getX_latitude());
				obj.put("gety",  coordin.get(i).getY_longitude());
				arr.add(obj);				
			}
			
			res.put("size", coordin.size());
		}			
		res.put("array", arr);
		return res.toString();		
	}	
	//http://192.168.0.95:8080/ubuntu/coordinates?x=49.134126000000002000&y=33.441833000000003000&r=1
	//http://82.144.203.67:8080/ubuntu/coordinates?x=49.134126000000002000&y=33.441833000000003000&r=1
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/coordinates", method=RequestMethod.GET)
	public @ResponseBody String getCoordinatesiByCriteria(@RequestParam(value="x", required=false) String x_latitude, @RequestParam(value="y", required=false) String y_longitude, @RequestParam(value="r", required=false) String radius ) throws IOException {
			Double x = Double.parseDouble(x_latitude);
			Double y = Double.parseDouble(y_longitude);
			Double r = Double.parseDouble(radius);
		List<Coordinates_Ua> coordin = coordinate.getSetiByCriteria(x,y,r);
	  JSONArray arr = new JSONArray();
		JSONObject res = new JSONObject();
		
		if (coordin != null) {
			for (int i = 0; i < coordin.size(); i++) {
				JSONObject obj = new JSONObject();
				
				obj.put("id",coordin.get(i).getId());
				obj.put("getX",coordin.get(i).getX_latitude());
				obj.put("gety",coordin.get(i).getY_longitude());
				obj.put("sity",coordin.get(i).getAtms_info_ua().getCity());
				obj.put("street",coordin.get(i).getAtms_info_ua().getAddress());
				arr.add(obj);				
			}
			res.put("size", coordin.size());
		}			
		res.put("array", arr);
		res.put("main"," 4");	
		
		return res.toString();		
	}	
	
	
	
	
	}