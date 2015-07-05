package com.mkyong.command.outzipfile;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import ftp.connection.file.image.bank.FtpConnection;
/**
 * Command  downloads  zip one file
 * @author Sergey
 *
 */
public class CommandOutFileZip implements ICommandOUtZip {
	private static final Logger logger = Logger.getLogger(CommandOutFileZip.class);
	@Autowired
	@Qualifier("ftpConnection")
	FtpConnection ftpConnection ;
	
	@Override
	public void execute( String nameFolder, HttpServletResponse response) {
		       
				   try {
						ftpConnection.getFildZipImage(nameFolder, response);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						logger.error(e);
					}
			 
			   
		
	}

}
