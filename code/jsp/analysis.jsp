<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.SQLException" %> 
<% String connectionURL = "jdbc:mysql://localhost:3306/hszmdp"; 
java.sql.Connection connection = null; 
java.sql.Statement statement = null; 

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <div id="content"><!-- InstanceBeginEditable name="work" --><a href="balance.jsp?bilanzID=<%= request.getParameter("bilanzID") %>">Bilanz</a> | <a href="income.jsp?bilanzID=<%= request.getParameter("bilanzID") %>">Erfolgsrechnung</a> | <strong>Auswertungen</strong> <br />
        <table width="100%" border="0">
          <tr>
            <td><p> Intensität des Anlagevermögens</p>
            </td>
            <td>(Anlagevermögen * 100)/Gesamtvermögen</td>
          </tr>
          <tr>
            <td> Fremdfinanzierungsgrad<br /></td>
            <td>(Fremdkapital * 100)/Gesamtkapital</td>
          </tr>
          <tr>
            <td> Eigenfinanzierungsgrad<br /></td>
            <td>(Eigenkapital * 100)/Gesamtkapital</td>
          </tr>
          <tr>
            <td>Liquiditätsgrad 2<br /></td>
            <td>((Flüssige Mittel + Forderungen)*100)/Kurzfristiges Fremdkapital</td>
          </tr>
          <tr>
            <td> Anlagedeckungsgrad 2<br /></td>
            <td>((Eigenkapital + langfristiges Fremdkapital)*100)/Anlagevermögen</td>
          </tr>
          <tr>
            <td> Rentabilität des Eigenkapitals<br /></td>
            <td>(Gewinn*100)/Eigenkapital</td>
          </tr>
          <tr>
            <td>Rentabilität des Gesamtkapitals<br /></td>
            <td>((Gewinn + Zinsen)*100)/Gesamtkapital</td>
          </tr>
          <tr>
            <td> Gewinnmarge<br /></td>
            <td>(Gewinn*100)/Umsatz</td>
          </tr>
          <tr>
            <td> Bruttogewinnmarge<br /></td>
            <td>(Bruttogewinn*100)/Umsatz</td>
          </tr>
          <tr>
            <td><strong>Cashflow</strong><br />
Der Cashflow kann auf 2 weisen berechnet werden. Anhanden der zur Verfügung stehenden Daten soll die Software selbständig den Cashflow berechnen. Beide Wege sollten möglich sein.<br /></td>
            <td>Gewinn + Liquiditätsunwirksamer Aufwand(Abschreibungen) = Cashflow<br />
oder<br />
Liquiditätswirksamer Ertrag (Einnahmen)(Warenertrag) – Liquiditätswirksamer Aufwand(Ausgaben)(Warenaufwand, Personalaufwand, Zinsaufwand, Übriger Aufwand) = Cashflow</td>
          </tr>
        </table>
      <!-- InstanceEndEditable --></div>
  </div>
  <div id="bottom"></div>
</div>
</body>
<!-- InstanceEnd --></html>
