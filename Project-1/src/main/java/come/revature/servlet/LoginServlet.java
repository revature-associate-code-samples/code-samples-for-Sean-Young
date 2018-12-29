package come.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.LoginDao;
import com.revature.dao.UserDao;
import com.revature.pojos.ErsUsers;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(LoginServlet.class); 
	static UserService uService = new UserService();
	static ErsUsers user1 = new ErsUsers();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String username = req.getParameter("username");
		//String password = req.getParameter("password");
		UserDao userDao = new UserDao();
		ObjectMapper mapper = new ObjectMapper();
		
		
		user1 = mapper.readValue(req.getReader(), ErsUsers.class);
		log.trace(user1);
		
		ErsUsers loggedIn = uService.validateUser(user1.getErsUserName(), user1.getErsPassword());
		log.trace(loggedIn);
		String json = mapper.writeValueAsString(user1);
		
		log.trace(user1);
		
		log.trace(json);
		
		
		
		log.trace("USER LOG IN " + user1);
		
		
		
			if(loggedIn == null) {
				//log.trace("USER LOG IN " + user);
				log.trace("not logged in" + user1);
				req.getRequestDispatcher("./error-login.html").forward(req, resp);
				log.trace("test 2");
			}
		
		else if(loggedIn.getUserRoleId() == 1){
			log.trace("Logging in" + loggedIn);
			HttpSession session = req.getSession();
			
			session.setAttribute("userId", loggedIn.getErsUserId());
			session.setAttribute("userRole", loggedIn.getUserRoleId());
			resp.sendRedirect("partials/home.html");
		}
		else if(loggedIn.getUserRoleId() == 2) {
			log.trace("Logging in" + loggedIn);
			HttpSession session = req.getSession();
			session.setAttribute("user", loggedIn);
			resp.sendRedirect("partials/manager.html");
		}
		}
	
	}
	

