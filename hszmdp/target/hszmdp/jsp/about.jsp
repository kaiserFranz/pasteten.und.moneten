<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.SQLException" %> 
<% String connectionURL = "jdbc:mysql://localhost:3306/hszmdp"; 
java.sql.Connection connection = null; 
java.sql.Statement statement = null; 
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/main.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>pasteten.und.moneten - About us</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="page">
  <div id="head">
    <div id="logo"><a href="home"><img src="images/logo.gif" width="200" height="72" border="0" /></a></div>
    <div id="contact">
      <table width="10%" border="0" align="right" cellpadding="0" cellspacing="0">
        <tr>
          <td nowrap="nowrap"><a href="#" style="color:#CCCCCC;">KONTAKT</a></td>
          <td nowrap="nowrap"><a href="#" style="color:#CCCCCC;">NEWSLETTER</a></td>
          <td nowrap="nowrap"><a href="#" style="color:#CCCCCC;">SUCHE</a></td>
          <td nowrap="nowrap"><% if (session.getAttribute("theID") != null) {%>&nbsp;<a href="logout">LOGOUT</a>&nbsp;
          <% }else{ %>&nbsp;<a href="login" >LOGIN</a>&nbsp;<% } %></td>
        </tr>
      </table>
    </div>
    <div id="register">
      <table width="10%" border="0" cellpadding="2" cellspacing="1">
        <tr>
          <td width="10%" nowrap="nowrap"><a href="home">HOME</a></td>
          <td width="10%" nowrap="nowrap"><a href="moneten">MONETEN</a></td>
          <td width="10%" nowrap="nowrap"><a href="about">&Uuml;BER UNS</a></td>
        </tr>
      </table>
    </div>
  </div>
  <div id="main">
    <div id="left">
      <div id="menu"><% if (session.getAttribute("theID") != null) { %><table width="100%" border="0">
        <tr>
          <td>Hallo <% out.println(session.getAttribute("theName")); %></td>
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
    <td><a href="balance?bilanzID=<%= rs_balance.getString("bilanzID") %> "><%= rs_balance.getString("bilanzJahr") %> bearbeiten</a></td>
  </tr>
<%}
			rs_balance.close(); 
}
%>
  <tr>
    <td><a href="ins_balance">Neue Bilanz erstellen</a></td>
  </tr>
  <tr>
    <td><a href="logout">Logout</a></td>
  </tr>
</table>
<% } %></div>
    </div>
    <div id="content"><!-- InstanceBeginEditable name="work" -->
      <h2>ABOUT US</h2>
      <div style="width:50%; float:right;">Studenten an der HSZ-T<br />
    Klasse I09b &amp;  I09c<br />
          <br />
        Dozenten: Seeliger, Eppler<br />
        Fach: Methoden der Programmierung<br />
        <br />
        Logged in: <% out.println(session.getAttribute("theID") + " / " + session.getAttribute("theName")); %><br />
      </div>
      <div style="width:50%; float:left;" >Jan Ivertowski<br />
        Manuel Stüssi<br />
        Marc Schmid<br />
        Milorad Milutinovic<br />
        Zeljko Jovanovic<br />
        Alexander Wildbolz<br />
        <br />
      Copyright &copy;</div>
      <p><br />
      </p>
      <p>&nbsp;</p>
    <!-- InstanceEndEditable --></div>
  </div>
  <div id="bottom"></div>
</div>
</body>
<!-- InstanceEnd --></html>
