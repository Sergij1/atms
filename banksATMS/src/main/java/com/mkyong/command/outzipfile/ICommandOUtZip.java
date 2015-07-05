package com.mkyong.command.outzipfile;

import javax.servlet.http.HttpServletResponse;
/**
 * downloads file  client
 * @author Sergey
 *
 */
public interface ICommandOUtZip {
	/**
	 *  download  zip file or folder  client
	 *
	 * @param namaFolder name  folder or file 
	 * @param responce
	 */
	
	public void execute( String namaFolder, HttpServletResponse response );

}
