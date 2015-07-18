package com.mkyong.command.outzipfile;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
/**
 * downloads file  client
 * @author Sergey
 *
 */
@Service
public interface ICommandOUtZip {
	/**
	 *  download  zip file or folder  client
	 *
	 * @param namaFolder name  folder or file 
	 * @param responce
	 */
	
	public void execute( String namaFolder, HttpServletResponse response );

}
