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
		 if(request.getParameter("textTeil") != null){
				 command = "UPDATE STRUKTUR SET strukTeil = '" + request.getParameter("textTeil") + "', strukName = '" + request.getParameter("textName") + "', STATUS = " + request.getParameter("textSTATUS") + " WHERE strukID = " + request.getParameter("strukID");
           try {
		    statement.executeUpdate(command);
			} catch (Exception e) {
			message = command;
			}
			}      
			
ResultSet rsa = null; 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
connection = DriverManager.getConnection(connectionURL, "admin", "admin"); 
statement = connection.createStatement(); 
rsa = statement.executeQuery("SELECT * FROM struktur WHERE strukID = "  + request.getParameter("strukID")); 

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
    <div id="content"><!-- InstanceBeginEditable name="work" --><a href="admin_index.jsp">Datenbank</a> | <a href="admin_balance.jsp">Posten verwalten</a> &gt; <strong>Posten mutieren</strong><br />
      <br />
      <font size="4"><strong>Posten verwalten<br />
    </strong></font>
        <table width="50%" border="0">
          <tr>
            <td width="15%" bgcolor="#333333">&nbsp;</td>
            <td width="85%" bgcolor="#333333">&nbsp;</td>
          </tr>
			<% while (rsa.next()) {  %>
<form id="form1" name="form1" method="post" action="admin_mut_balance.jsp?strukID=<%= rsa.getString("strukID") %>">
          <tr>
            <td width="15%" align="right">ID: </td>
            <td width="85%"><%= rsa.getString("strukID") %></td>
          </tr>
          <tr>
            <td align="right">strukTeil : </td>
            <td><input name="textTeil" type="text" id="textTeil" value="<%= rsa.getString("strukTeil") %>" style="width:300px;" /></td>
          </tr>
          <tr>
            <td align="right">Passwort: </td>
            <td><input name="textName" type="text" id="textName" value="<%= rsa.getString("strukName") %>"  style="width:300px;" /></td>
          </tr>
          <tr>
            <td align="right">Status:&nbsp;</td>
            <td><label>
              <select name="textSTATUS" id="textSTATUS">
                <option value="1" <%=(("1".toString().equals(rsa.getString("STATUS")))?"selected=\"selected\"":"")%>>aktiv</option>
                <option value="0" <%=(("0".toString().equals(rsa.getString("STATUS")))?"selected=\"selected\"":"")%>>inaktiv</option>
              </select>
            </label></td>
          <tr>
            <td align="right">&nbsp;</td>
            <td><label>
              <input type="submit" name="button" id="button" value="Speichern" />
            </label></td>
          </form>
          </tr>
              <%}
			rsa.close(); %>
        </table>
      <p>&nbsp;</p>
        <p><% out.write(message); %><font size="4"><strong>        </strong></font></p>
    <!-- InstanceEndEditable --></div>
  </div>
  <div id="bottom"></div>
</div>
</body>
<!-- InstanceEnd --></html>
