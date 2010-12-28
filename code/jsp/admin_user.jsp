<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.SQLException" %> 
<% String connectionURL = "jdbc:mysql://localhost:3306/hszmdp"; 
java.sql.Connection connection = null; 
java.sql.Statement statement = null; 

Class.forName("com.mysql.jdbc.Driver").newInstance(); 
connection = DriverManager.getConnection(connectionURL, "admin", "admin"); 
statement = connection.createStatement(); 

		 String message = "";
		 String command;
		 if(request.getParameter("status") != null){
				 command = "UPDATE USER SET STATUS = " + request.getParameter("status") + " WHERE userID = " + request.getParameter("userID");
           try {
		    statement.executeUpdate(command);
			} catch (Exception e) {
			message = "";
			}
			}      
			
ResultSet rsa = null; 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
connection = DriverManager.getConnection(connectionURL, "admin", "admin"); 
statement = connection.createStatement(); 
rsa = statement.executeQuery("SELECT * FROM user"); 

%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/main.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>pasteten.und.moneten</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="../css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="page">
  <div id="head">
    <div id="logo"><a href="index.jsp"><img src="../images/logo.gif" width="200" height="72" border="0" /></a></div>
    <div id="contact">
      <table width="10%" border="0" align="right" cellpadding="0" cellspacing="0">
        <tr>
          <td nowrap="nowrap"><a href="#" style="color:#CCCCCC;">KONTAKT</a></td>
          <td nowrap="nowrap"><a href="#" style="color:#CCCCCC;">NEWSLETTER</a></td>
          <td nowrap="nowrap"><a href="register.jsp">REGISTRIEREN</a></td>
          <td nowrap="nowrap"><% if (session.getAttribute("theID") != null) {%>&nbsp;<a href="logout.jsp">LOGOUT</a>&nbsp;
          <% }else{ %>&nbsp;<a href="login.jsp" >LOGIN</a>&nbsp;
          <% } %></td>
        </tr>
      </table>
    </div>
    <div id="register">
      <table width="10%" border="0" cellpadding="2" cellspacing="1">
        <tr>
          <td width="10%" nowrap="nowrap"><a href="index.jsp">HOME</a></td>
          <td width="10%" nowrap="nowrap"><a href="balance.jsp?bilanzID=1">MONETEN</a></td>
          <td width="10%" nowrap="nowrap"><a href="about.jsp">&Uuml;BER UNS</a></td>
        </tr>
      </table>
    </div>
  </div>
  <div id="main">
    <div id="left">
      <div id="menu"><% if (session.getAttribute("theID") != null) { %><table width="100%" border="0">
        <tr>
          <td>Hallo
            <% out.println(session.getAttribute("theName")); %></td>
        </tr>
        <tr>
          <td><strong>Bilanzen</strong> (<a href="ins_balance.jsp">neu</a>)</td>
        </tr>
<% try{
 int a=0;
 int b=10;
 int c=b/a;
}
catch(Exception e)
{
ResultSet rs_balance = null; 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
connection = DriverManager.getConnection(connectionURL, "admin", "admin"); 
statement = connection.createStatement(); 

rs_balance = statement.executeQuery("SELECT * FROM bilanz WHERE userID = " + session.getAttribute("theID")+" ORDER BY bilanzJahr desc"); 
            while (rs_balance.next()) { 
%>
  <tr>
    <td><% if(rs_balance.getString("bilanzID").equals(request.getParameter("bilanzID"))) { 
	out.println("<STRONG>" + rs_balance.getString("bilanzJahr") + "</STRONG>");
	 } else {%><a href="balance.jsp?bilanzID=<%= rs_balance.getString("bilanzID") %> "><%= rs_balance.getString("bilanzJahr") %> bearbeiten</a><% } %></td>
  </tr>
<%}
			rs_balance.close(); 
}
%>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td></td>
  </tr>
<% if(session.getAttribute("isAdmin").equals("true")) { %>
  <tr>
    <td><strong>Administration</strong></td>
  </tr>
  <tr>
    <td><a href="admin_index.jsp">Datenbank mutieren</a></td>
  </tr>
<% } %>
  <tr>
    <td><a href="logout.jsp">Logout</a></td>
  </tr>
</table>
<% } %></div>
    </div>
    <div id="content"><!-- InstanceBeginEditable name="work" --><a href="admin_index.jsp">Datenbank</a> | <strong>User verwalten</strong><br />
      <br />
      <font size="4"><strong>User verwalten<br />
    </strong></font>
        <table width="70%" border="0">
          <tr>
            <td width="15%" bgcolor="#333333"><strong><font color="#FFFFFF">UserID</font></strong></td>
            <td width="15%" bgcolor="#333333"><strong><font color="#FFFFFF">Name</font></strong></td>
            <td width="15%" bgcolor="#333333"><strong><font color="#FFFFFF">Profil</font></strong></td>
            <td width="10%" bgcolor="#333333"><strong><font color="#FFFFFF">Status</font></strong></td>
          </tr>
			<% while (rsa.next()) {  %>
          <tr>
            <td width="15%" class="TD_LINE"><a href="admin_mut_user.jsp?userID=<%= rsa.getString("userID") %>" class="PLUS">&nbsp;&#8226;&nbsp;</a>&nbsp;
              <% if(rsa.getString("STATUS").equals("1")) { %>
              <a href="admin_user.jsp?status=0&userID=<%= rsa.getString("userID") %>" class="MINUS">&#8211;</a>
              <% } else { %>
              <a href="admin_user.jsp?status=1&userID=<%= rsa.getString("userID") %>" class="PLUS">+</a>
              <%}%>
            <%= rsa.getString("userID") %></td>
            <td width="15%" class="TD_LINE"><%= rsa.getString("NAME") %>&nbsp;</td>
            <td width="15%" class="TD_LINE"><%= rsa.getString("PROFILE") %></td>
            <td width="10%" class="TD_LINE"><% if(rsa.getString("STATUS").equals("1")) { %>
              aktiv
            <% } else { %>
            inatkiv
            <%}%></td>
          </tr>
              <%}
			rsa.close(); %>
        </table>
    <font size="4"><strong>        </strong></font><!-- InstanceEndEditable --></div>
  </div>
  <div id="bottom"></div>
</div>
</body>
<!-- InstanceEnd --></html>
