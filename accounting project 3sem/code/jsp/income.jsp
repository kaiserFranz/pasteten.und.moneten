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
		 String command, varSel;
		 if(request.getParameter("strukID") != null){
			 if(request.getParameter("akt").equals("minus")){ //akt=minus
				 command = "INSERT INTO buchung (buchID, bilanzID, strukID, buchBetrag, buchDatum) VALUES (NULL, " + request.getParameter("bilanzID") + ", " + request.getParameter("strukID") + ", -1000, sysdate())";
				} else {
				 command = "INSERT INTO buchung (buchID, bilanzID, strukID, buchBetrag, buchDatum) VALUES (NULL, " + request.getParameter("bilanzID") + ", " + request.getParameter("strukID") + ", 1000, sysdate())";
			}
           try {
		    statement.executeUpdate(command);
			} catch (Exception e) {
			message = "";
			}
			}      

			
// WENN BILANZID = 1 DANN SOLL JEDER ZUGRIFF HABEN
if (request.getParameter("bilanzID").equals("1")){
	varSel = "";
} else {
	varSel = " AND USERID = " + session.getAttribute("theID");
}

ResultSet rsa = null; 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
connection = DriverManager.getConnection(connectionURL, "admin", "admin"); 
statement = connection.createStatement(); 
rsa = statement.executeQuery("SELECT * FROM view_aufwand WHERE bilanzID = " + request.getParameter("bilanzID") + varSel + " ORDER BY strukID "); 
//
ResultSet rsp = null; 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
connection = DriverManager.getConnection(connectionURL, "admin", "admin"); 
statement = connection.createStatement(); 
rsp = statement.executeQuery("SELECT * FROM view_ertrag WHERE bilanzID = " + request.getParameter("bilanzID") + varSel + " ORDER BY strukID "); 

%>
<%! int saldo = 0; %>
<%! String teil = ""; %>
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
    <div id="content"><!-- InstanceBeginEditable name="work" -->  <a href="balance.jsp?bilanzID=<%= request.getParameter("bilanzID") %>">Bilanz</a> | <strong>Erfolgsrechnung</strong> | <a href="analysis.jsp?bilanzID=<%= request.getParameter("bilanzID") %>">Auswertungen</a> <br />
    &nbsp;
      <table width="100%" border="0">
      <tr>
        <td width="49%"><strong><font size="4">Aufwand</font></strong></td>
          <td width="2%">&nbsp;</td>
            <td width="49%"><strong><font size="4">Ertrag</font></strong></td>
        </tr>
      <tr>
        <td valign="top"><table width="100%" cellpadding="0" cellspacing="0">
              <% int aktiv = 0;
			while (rsa.next()) { 
			if(!rsa.getString("strukTeil").equals(teil)) {%>
          <tr>
            <td height="30" colspan="5"><strong><font size="2"><%= rsa.getString("strukTeil") %>&nbsp;</font></strong></td>
              </tr>
          <% teil = rsa.getString("strukTeil");
		  } 
            %>
              <tr>
                <td width="1%" height="17" nowrap="nowrap" class="TD_LINE"><a href="income.jsp?bilanzID=<%= request.getParameter("bilanzID") %>&strukID=<%= rsa.getString("strukID") %>&akt=plus" class="PLUS">+</a>&nbsp;</td>
                <td width="1%" nowrap="nowrap" class="TD_LINE"><a href="income.jsp?bilanzID=<%= request.getParameter("bilanzID") %>&strukID=<%= rsa.getString("strukID") %>&akt=minus" class="MINUS">&#8211;</a>&nbsp;&nbsp;</td>
                <td class="TD_LINE"><%= rsa.getString("strukName") %></td>
                <td class="TD_LINE" align="right">&nbsp;&nbsp;&nbsp;
                <%  aktiv = aktiv + rsa.getInt("BETRAG");
				out.print(rsa.getInt("BETRAG")); %></td>
              </tr>
              <%}
			rsa.close(); %>
            </table></td>
            <td valign="top">&nbsp;</td>
            <td valign="top"><table width="100%" cellpadding="0" cellspacing="0">
              <% int passiv = 0;
			while (rsp.next()) { 
			if(!rsp.getString("strukTeil").equals(teil)) {%>
              <tr>
                <td height="30" colspan="5"><strong><font size="2"><%= rsp.getString("strukTeil") %>&nbsp;</font></strong></td>
              </tr>
              <% }
			  teil = rsp.getString("strukTeil"); %>
              <tr>
                <td width="1%" height="17" nowrap="nowrap" class="TD_LINE"><a href="income.jsp?bilanzID=<%= request.getParameter("bilanzID") %>&strukID=<%= rsp.getString("strukID") %>&akt=plus" class="PLUS">+</a>&nbsp;</td>
                <td width="1%" nowrap="nowrap" class="TD_LINE"><a href="income.jsp?bilanzID=<%= request.getParameter("bilanzID") %>&strukID=<%= rsp.getString("strukID") %>&akt=minus" class="MINUS">&#8211;</a>&nbsp;&nbsp;</td>
                <td class="TD_LINE"><%= rsp.getString("strukName") %></td>
                <td class="TD_LINE" align="right">&nbsp;&nbsp;&nbsp;
                  <%  passiv = passiv + rsp.getInt("BETRAG"); 
				  out.print(rsp.getInt("BETRAG")); %></td>
              </tr>
              <%}
			rsp.close(); %>
          <tr>
            <td height="17" colspan="4" nowrap="nowrap">&nbsp;</td>
            </tr>
          <tr>
            <td height="17" nowrap="nowrap" class="TD_LINE">&nbsp;</td>
            <td nowrap="nowrap" class="TD_LINE">&nbsp;</td>
            <td class="TD_LINE"><strong>
              <% saldo = aktiv-passiv;
			if(passiv <= aktiv) { 
			out.println("Gewinn");
			} else {
			out.println("Verlust");
			}%>
              &nbsp;</strong></td>
            <td class="TD_LINE" align="right"><% out.println(saldo); %></td>
          </tr>
          </table></td>
      </tr>
      <tr>
        <td align="right"><strong>TOTAL <% out.println(aktiv); %></strong></td>
            <td>&nbsp;</td>
            <td align="right"><strong>TOTAL 
              <% int total = passiv+saldo;
			  out.println(total); %>
              </strong></td>
        </tr>
      </table>
  <!-- InstanceEndEditable --></div>
  </div>
  <div id="bottom"></div>
</div>
</body>
<!-- InstanceEnd --></html>
