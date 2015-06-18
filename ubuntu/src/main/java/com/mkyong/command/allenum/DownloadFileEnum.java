package com.mkyong.command.allenum;

import com.mkyong.command.outzipfile.CommandOutFileZip;
import com.mkyong.command.outzipfile.CommandOutFolderZip;
import com.mkyong.command.outzipfile.ICommandOUtZip;

/**
 * enum command file or folder downloads when command folder download folder -
 * all zip files when command file downoload one zip file
 * 
 * @author Sergey
 *
 */
public enum DownloadFileEnum {
	FOLDER {
		{
			this.nActionC = new CommandOutFolderZip();
		}
	},
	FILE {
		{
			this.nActionC = new CommandOutFileZip();
		}

	};

	protected ICommandOUtZip nActionC;

	public ICommandOUtZip getCommand() {
		return nActionC;
	}

}
