package com.mkyong.command.outzipfile;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ftp.connection.file.image.bank.FtpConnection;

public class CommandOutFolderZip implements ICommandOUtZip {
	private static final Logger logger = Logger.getLogger(CommandOutFileZip.class);
	@Autowired
	@Qualifier("ftpConnection")
	FtpConnection ftpConnection ;
	@Override
	public void execute( String nameFolder, HttpServletResponse response) {
     nameFolder +=".zip";
     ftpConnection.outRequestFolder( nameFolder, response );
			 
			   
		
	}

}
