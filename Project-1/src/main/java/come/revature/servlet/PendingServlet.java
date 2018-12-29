package come.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.ErsReimbursement;
import com.revature.service.UserService;
@WebServlet("/pending")
public class PendingServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(PendingServlet.class);
	static UserService uService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ErsReimbursement> e = uService.getPending(3);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(e);
		logger.trace("FINDING:" + json);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursement e = mapper.readValue(req.getInputStream(), ErsReimbursement.class);
		uService.updateReimbursement(e);
	}
	
}
