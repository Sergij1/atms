package servletAll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.command.allenum.DownloadFileEnum;
import com.mkyong.command.outzipfile.CommandOutFileZip;
import com.mkyong.command.outzipfile.CommandOutFolderZip;
import com.mkyong.command.outzipfile.ICommandOUtZip;

import ftp.connection.file.image.bank.FtpConnection;

/**
 * Servlet implementation class FileLoad
 */
// http://192.168.0.95:8080/banksATM/FileLoad?type=folder&name=?????????
@WebServlet("/FileLoad")
public class FileLoad extends HttpServlet {
	private static final Logger logger = Logger
			.getLogger(CommandOutFileZip.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileLoad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ICommandOUtZip actionCommand = getActionCommand(request, response);
		String nameFolder = request.getParameter("name");
		actionCommand.execute(nameFolder, response);
	}

	/**
	 * method return current ICommandOUtZip
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @See ICommandOUtZip
	 */

	public ICommandOUtZip getActionCommand(HttpServletRequest request,
			HttpServletResponse response) {
		ICommandOUtZip actionCommand = new CommandOutFolderZip();
		// type or folder or file
		String action = request.getParameter("type");
		if (action == null || action.isEmpty()) {
			return actionCommand;
		}
		try {
			DownloadFileEnum command = DownloadFileEnum.valueOf(action
					.toUpperCase());
			actionCommand = command.getCommand();
		} catch (IllegalArgumentException e) {
			logger.info(e);

		}

		return actionCommand;
	}

}

