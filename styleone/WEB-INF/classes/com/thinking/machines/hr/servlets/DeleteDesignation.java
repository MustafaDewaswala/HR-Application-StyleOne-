package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
int code=0;
try
{
pw=response.getWriter();
try
{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException numberFormatException)
{
sendBackView(response);
return;
}
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.delete(code);
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
pw.println("Designation Deleted<br>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>Ok</button>");
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
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
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
pw.println("Unable to delete designation<br>");
pw.println("<b>"+daoException.getMessage()+"</b><br><br>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>Ok</button>");
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
pw.println("</body>");
pw.println("</html>");
return;
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
private void sendBackView(HttpServletResponse response)
{
try
{
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
List<DesignationDTO> designations;
designations=designationDAO.getAll();
PrintWriter pw=response.getWriter();
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
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png' style='float:left'></a><div style='margin-top:8px;margin-bottom:12px;font-size:30pt'>Thinking Machines</div>");
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
pw.println("<div style='height:65vh;padding:5px;margin-left:105px;margin-right:5px;margin:bottom:px;margin-top:5px;overflow:scroll;border:1px solid black'>");
pw.println("<h2>Designations</h2>");
pw.println("<table border='2'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right;padding:5px'><a href='/styleone/AddDesignation.html'>Add New Designation</a></th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.No.</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int x;
DesignationDTO designationDTO;
int code;
String title;
int sno=0;
for(x=0;x<designations.size();x++)
{
sno++;
designationDTO=designations.get(x);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:right'>"+sno+".</td>");
pw.println("<td>"+title+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editDesignation?code="+code+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteDesignation?code="+code+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
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
System.out.println(daoException.getMessage()); // remove after testing and setup 500 (internal error page)
}
catch(Exception exception)
{
System.out.println(exception.getMessage()); // remove after testing and setup 500 (internal error page)
}
}
}