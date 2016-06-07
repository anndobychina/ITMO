package homework;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FormEx extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		String var1 = req.getParameter("var1");
		
		String var2 = req.getParameter("var2");
try{
	if(var1.length()<8||var2.length()<8){
		throw new LenEx();
	}
	if(var1.length()>16||var2.length()>16){
		throw new LongLenEx();
	}}
	catch(LenEx e){
		resp.getWriter().println("Длина пароля и логина должна быть не меньше 8");
	}
catch(LongLenEx e){
	resp.getWriter().println("Длина пароля и логина должна быть не больше 16");
}

		resp.getWriter().println();

	}
}
