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
import com.revature.pojos.ErsReimbursement;
import com.revature.pojos.ErsUsers;
import com.revature.service.UserService;
@WebServlet("/submitted")
public class LoadReimbursementsServlets extends HttpServlet {
	private static Logger logger = Logger.getLogger(LoadReimbursementsServlets.class);
	static UserService uService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		int i = (int) session.getAttribute("userId");
		logger.trace(session);
		List<ErsReimbursement> e = uService.getSubmitted(i);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(e);
		logger.trace("FINDING:" + json);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	
}
