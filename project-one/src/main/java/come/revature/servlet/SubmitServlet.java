package come.revature.servlet;



import java.io.IOException;

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

@WebServlet("/reim")
public class SubmitServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(SubmitServlet.class);
	static UserService uService = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int i = (int) session.getAttribute("userId");
		log.trace(session);
		ObjectMapper mapper = new ObjectMapper();
		
		ErsReimbursement e = mapper.readValue(req.getInputStream(), ErsReimbursement.class);
		e.setReimbAuthor(i);
		uService.submitReimbursement(e);
		
	}
}
