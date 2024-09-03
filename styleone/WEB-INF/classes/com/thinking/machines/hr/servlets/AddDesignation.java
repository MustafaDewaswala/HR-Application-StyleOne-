package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class AddDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
String title="";
try
{
pw=response.getWriter();
title=request.getParameter("title");
DesignationDTO designation=new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.add(designation);
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here   -->");
pw.println("<div style='width:90hw;height:auto;border:2px solid black'>");
pw.println("<!-- header starts here   -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:8px;margin-bottom:12px;font-size:30pt'>Thinking Machines</div>");
pw.println("</div><!-- header ends here   -->");
pw.println("<!-- content-section starts here   -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:2px solid white'>");
pw.println("<!-- left panel starts here   -->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<a href='/styleone/designationsView'>Designations</a><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here   -->");
pw.println("<!-- right panel starts here   -->");
pw.println("<div style='height:65vh;padding:5px;margin-left:105px;margin-right:5px;margin:bottom:px;margin-top:5px;border:1px solid black'>");
pw.println("<h3>Notification</h3>");
pw.println("Designation added<br>Add More Designations??<br>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<form action='/styleone/AddDesignation.html'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("<td>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>No</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
pw.println("<!-- right panel ends here   -->");
pw.println("</div><!-- content-section ends here   -->");
pw.println("<!-- footer starts here   -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;font-size:20pt;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2023");
pw.println("</div>");
pw.println("<!-- footer ends here   -->");
pw.println("</div>");
pw.println("<!-- Main container ends here   -->");
pw.println("</body>");
pw.println("</html>");

}catch(DAOException daoException)
{

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var title=frm.title.value.trim();");
pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
pw.println("titleErrorSection.innerHTML='';");
pw.println("if(title.length==0)");
pw.println("{");
pw.println("titleErrorSection.innerHTML='required';");
pw.println("frm.title.focus();");
pw.println("return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("function cancelAddition()");
pw.println("{");
pw.println("document.getElementById('cancelAdditionForm').submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here   -->");
pw.println("<div style='width:90hw;height:auto;border:2px solid black'>");
pw.println("<!-- header starts here   -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:8px;margin-bottom:12px;font-size:30pt'>Thinking Machines</div>");
pw.println("</div><!-- header ends here   -->");
pw.println("<!-- content-section starts here   -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:2px solid white'>");
pw.println("<!-- left panel starts here   -->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<b>Designations</b><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a><br><br><br>");
pw.println("<a href='/styleone/index.html'>HOME</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here   -->");
pw.println("<!-- right panel starts here   -->");
pw.println("<div style='height:65vh;padding:5px;margin-left:105px;margin-right:5px;margin:bottom:px;margin-top:5px;border:1px solid black'>");
pw.println("<h2>Designations (Add Module)</h2>");
pw.println("<div style='color:red'>"+daoException.getMessage()+"</div>");
pw.println("<form action='/styleone/addDesignation' onsubmit='return validateForm(this)'>");
pw.println("Designation");
pw.println("<input type='text' id='title' name='title' maxlength='35' size='36' value='"+title+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit'>ADD</button>");
pw.println("<button type='Button' onclick='cancelAddition()'>CANCEL</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!-- right panel ends here   -->");
pw.println("</div><!-- content-section ends here   -->");
pw.println("<!-- footer starts here   -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;font-size:20pt;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2023");
pw.println("</div>");
pw.println("<!-- footer ends here   -->");
pw.println("</div>");
pw.println("<!-- Main container ends here   -->");
pw.println("<form id='cancelAdditionForm' action='/styleone/designationsView'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");

}
catch(Exception exception)
{
System.out.println(exception.getMessage()); // remove after testing and setup 500 (internal error page)
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}