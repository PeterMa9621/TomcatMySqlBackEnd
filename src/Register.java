import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
		String userName = req.getParameter("k1");
		String password = req.getParameter("k2");
		
		//username and password set in UserBeam
		
		UserBeam user = new UserBeam();
		user.setUserName(userName);
		user.setPassword(password);
		
		RegisterImp rimp = new RegisterImp();
		int i = rimp.registerUser(user);
		
		if(i>0) {
			System.out.println("Register successful");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("REGISTER", "SUCCESS");
			
			PrintWriter pw = resp.getWriter();
			pw.write(jsonObject.toString());
			pw.print(jsonObject.toString());
			
			System.out.println("REGISTER successful" + jsonObject.toString());
		}
	}
}
