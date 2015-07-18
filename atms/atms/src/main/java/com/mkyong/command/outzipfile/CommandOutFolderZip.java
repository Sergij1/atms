package com.mkyong.command.outzipfile;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ftp.connection.file.image.bank.FtpConnection;
/**
 * 
 * @author Sergey
 * class unloads  zip folder   
 */
public class CommandOutFolderZip implements ICommandOUtZip {
	private static final Logger logger = Logger.getLogger(CommandOutFolderZip.class);
	@Autowired
	FtpConnection ftpConnection;

	public CommandOutFolderZip(){
		super();
	}
	public FtpConnection getFtpConnection() {
		return ftpConnection;
	}
	@Autowired
	public void setFtpConnection(FtpConnection ftpConnection) {
		this.ftpConnection = ftpConnection;
	}
	@Override
	public void execute( String nameFolder, HttpServletResponse response) {
     nameFolder +=".zip";
     
     if( ftpConnection == null){
    	 logger.warn("ftpConnection warn");
     }
     else{
    	 ftpConnection.outRequestFolder( nameFolder, response );
     }
			 
			   
		
	}

}