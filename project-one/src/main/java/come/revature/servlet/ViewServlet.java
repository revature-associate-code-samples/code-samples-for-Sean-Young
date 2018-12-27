package come.revature.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ViewServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(ViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resoursePath = "partials/" + process(req, resp) +".html";
		req.getRequestDispatcher(resoursePath).forward(req, resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/project-one/login.view":
			return "login";
		case "/project-one/home.view":
			return "home";
		case "/project-one/submitted.view":
			return "submitted";
		case "/project-one/reim.view":
			return "reim";
		case "/project-one/manager.view":
			return "manager";
		case "/project-one/pending.view":
			return "pending";
		case "/project-one/resolved.view":
			return "resolved";
		case "/project-one/result.view":
			return "result";
		}
		return null;
		
	}

}
