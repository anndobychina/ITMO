package homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class OpenData extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain;;charset=UTF-8");
//		ArrayList<ConcertOrganization> list=ExcelParse.Parse();
		ArrayList<String> tempListOfType=new ArrayList<String>();
		ArrayList<String> listOfType = new ArrayList<String>();  
//		for (ConcertOrganization organization: list)
//		{
//			tempListOfType.add(organization.getType());
//		 }
		for (String type: tempListOfType)
		{
		  if (!listOfType.contains(type)) 
		  {
		    listOfType.add(type);
		  }
		 }
		resp.getWriter().println("<select id=\"type\">");
		int i=0;
		for(i=0;i<listOfType.size();i++){
			String type=listOfType.get(i);
			resp.getWriter().println("<option value="+type+">"+type+"</option>");
		}
		resp.getWriter().println("<select id=\"operation\">");
		
	}
}
