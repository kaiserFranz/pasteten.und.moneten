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
<title>pasteten.und.moneten</title>
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
    <div id="content"><!-- InstanceBeginEditable name="work" --><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="25"><h2>Home</h2></td>
        </tr>
        <tr>
          <td><p> Die Software soll dem Benutzer ermöglichen mit wenig Aufwand die Aktiven und    Passiven Bilanz-Daten einzugeben und daraus die Schlussbilanz zu generieren. Das gleiche gilt    für den Aufwand und Ertrag aus welchem die Erfolgsrechnung generiert wird.    Aus diesen Daten lassen sich beliebige Bilanzanalysen durchführen:   </p>
            <ul>
              <li>Intensität des Anlagevermögens </li>
              <li>Fremdfinanzierungsgrad </li>
              <li>Eigenfinanzierungsgrad</li>
              <li> Liquiditätsgrad 2</li>
              <li>Anlagedeckungsgrad 2 </li>
              <li>Rentabilität des Eigenkapitals </li>
              <li>Rentabilität des Gesamtkapitals </li>
              <li>Gewinnmarge </li>
              <li>Bruttogewinnmarge </li>
              <li>Cashflow </li>
          </ul></td>
        </tr>
      </table>
    <!-- InstanceEndEditable --></div>
  </div>
  <div id="bottom"></div>
</div>
</body>
<!-- InstanceEnd --></html>
