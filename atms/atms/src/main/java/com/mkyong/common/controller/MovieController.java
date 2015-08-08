package com.mkyong.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mkyong.comman.data.GetoutData;
import com.mkyong.ftp.command.CommandOutFolderZip;
import com.mkyong.json.parse.ParseJson;



/*
 * controller return coordinates  ATMS  client In JSON
 */

@Controller
@RequestMapping(produces = "application/json;charset=UTF-8")
public class MovieController {
	private static final Logger logger = Logger
			.getLogger(MovieController.class);
	private static final String COUNTRY_UA = "Ukrain";
	/**
	 * loader  zip folder 
	 * @see CommandOutFolderZip
	 */
	@Autowired
	@Qualifier("CommandOutFolderZip")
    CommandOutFolderZip commandOutFolderZip;
	/**
	 * parse date in json
	 */
	@Autowired
	@Qualifier("ParseJson")
	ParseJson parseJson;
	/**
	 * @see GetoutData
	 */
	@Autowired
	GetoutData getutData;

	// http://192.168.0.95:8080/atms/atm
	// http://127.0.0.1:8080/atms/atm
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getMovie(Locale local,ModelMap model) {
		ArrayList<String> country =  getutData.getCountry(local);
	    model.addAttribute("country", country);
		logger.info(local.getLanguage());
		return "index";
		}
	
	@RequestMapping(value = "/area/{country}",  method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getAllAreaCountry(Locale local,@PathVariable("country") String country) {
		String  area = null;
		if(country.equals(COUNTRY_UA)){
			area = parseJson.getAllListAreaInCountry(local);	
		}
		return area;
		}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/seti/{criteria}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getSetiByCriteria(Locale locale,
			@PathVariable("criteria") String value,
			@RequestParam(value = "field", required = false, defaultValue = "id") String field){
		    return parseJson.getSetiByCriteria(field, value,locale);
		}

	// http://127.0.0.1:8080/atms/allcoordinates
	/**
	 * 
	 * @return all  data  atm  and  description 
	 * about atm(seti,bank,info atm, coordinates) in format json 
	 *
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/allcoordinates", method = RequestMethod.GET)
	public @ResponseBody String getCoordinatALL()  {
		return  parseJson.getCoordinatesALL();
	}

	// http://192.168.0.95:8080/ubuntu/coordinates?x=49.134126000000002000&y=33.441833000000003000&r=1
	// http://127.0.0.1:8080/atms/coordinates?x=49.134126000000002000&y=33.441833000000003000&r=1
	/**
	 * method  return data atms by criteria coordinates (latitude, longitude, radius)
	 * @param x_latitude latitude
	 * @param y_longitude longitude
	 * @param radius all atms in radius
	 * @return string json
	 */
	@RequestMapping(value = "/coordinates", method = RequestMethod.GET)
	public @ResponseBody String getCoordinatesiByCriteria(
			@RequestParam(value = "x", required = false) String x_latitude,
			@RequestParam(value = "y", required = false) String y_longitude,
			@RequestParam(value = "r", required = false) String radius,Locale locale) {
		 return parseJson.getCoordinatesiByCriteria(x_latitude, y_longitude, radius,locale);
	}

	// http://127.0.0.1:8080/atms/image?type=folder&name=image2
	/**
	 * loader  zip folder 
	 * @param name name folder
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public @ResponseBody void getImage(@RequestParam(value = "name", required = false) String name,
			 HttpServletResponse response){
		    commandOutFolderZip.execute(name, response);
	      }

}