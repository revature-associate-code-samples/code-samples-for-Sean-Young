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
import com.revature.service.UserService;
@WebServlet("/resolved")
public class ResolvedServlet extends HttpServlet{
	private static Logger logger = Logger.getLogger(ResolvedServlet.class);
	static UserService uService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<ErsReimbursement> e = uService.getHandled();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(e);
		logger.trace("FINDING:" + json);
		
		List<ErsReimbursement> e1 = uService.getHandled2();
		e1.addAll(e);
		
		ObjectMapper mapper1 = new ObjectMapper();
		String json1 = mapper1.writeValueAsString(e1);
		PrintWriter writer = resp.getWriter();

		resp.setContentType("application/json");
		writer.write(json1);
		//writer.write(json1);
	}
}
