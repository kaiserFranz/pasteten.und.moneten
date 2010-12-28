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
<SCRIPT language=javascript type=text/javascript>
function ErrorHandler () {
//
	var msg = '';
	var check = 0;
	/* CHECK USERFIELD */
	var USER = document.getElementById("User").value;
	var Set='abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_@';
	var Teststring = document.getElementById("User").value;
	var Laenge = Teststring.length;
	if (Laenge>0)
{

for (i=0;i<=Laenge;i++)
    {
     zeichen=Teststring.charAt(i);
     if (Set.indexOf(zeichen)==-1)
        {
         alert('Bitte nur Buchstaben eingeben');
         document.getElementById("User").focus();
         return false;
         i=Teststring.length;
        }
    }
}
	if (USER.length == 0 ) {
		msg = "Fehler, bitte Benutzernamen ergaenzen"
		document.getElementById("Error_User").innerHTML = '*';
		document.getElementById("ErrorMSG").innerHTML = msg;
//		document.getElementById("User").style.Color = "yellow";
		check = check+1;
	} else {
	if (USER.length < 4 || USER.length > 20) {
		msg = "Fehler, Benutzernamen sollte zwischen 4 und 20 Zeichen enhalten"
		document.getElementById("Error_User").innerHTML = '*';
		document.getElementById("ErrorMSG").innerHTML = msg;
		check = check+1;
	} else {
		document.getElementById("Error_User").innerHTML = '';
		document.getElementById("ErrorMSG").innerHTML = '';
		check = check+0;
	}
	}
	/* CHECK PASSWORDFIELD */
	var PASS = document.getElementById("Password").value;
	var Teststring = document.getElementById("Password").value;
	var Laenge = Teststring.length;
	if (Laenge>0)
{

for (i=0;i<=Laenge;i++)
    {
     zeichen=Teststring.charAt(i);
     if (Set.indexOf(zeichen)==-1)
        {
         alert('Bitte nur Buchstaben eingeben');
         document.getElementById("Password").focus();
         return false;
         i=Teststring.length;
        }
    }
}
	if (PASS.length == 0 ) {
		msg = "Fehler, bitte Passwort ergaenzen"
		document.getElementById("Error_Pass").innerHTML = '*';
		document.getElementById("ErrorMSG1").innerHTML = msg;
		check = check+1;
	} else {
	if (PASS.length < 4 || PASS.length > 20) {
		msg = "Fehler, Password sollte zwischen 4 und 20 Zeichen enhalten"
		document.getElementById("Error_Pass").innerHTML = '*';
		document.getElementById("ErrorMSG1").innerHTML = msg;
		check = check+1;
	} else {
		document.getElementById("Error_Pass").innerHTML = '';
		document.getElementById("ErrorMSG1").innerHTML = '';
		check = check+0;
	}
	}
	if (check > 0) {
		return false;
	} else {
		window.location.href = 'login';
	}
}
</SCRIPT>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
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
    <div id="content"><!-- InstanceBeginEditable name="work" -->
      Login
      <table width="25%" border="0" cellpadding="3" cellspacing="0" bgcolor="#333333">
        <form id="form1" name="form1" method="post" action="loggedin.jsp"  onsubmit="return ErrorHandler()">
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td nowrap="nowrap"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          </tr>
          <tr>
            <td width="1%"><font color="#FFFFFF">Benutzername:&nbsp;&nbsp;</font></td>
            <td width="1%"><input type="text" name="txtName" id="txtName" style="width:150px;" /></td>
            <td><div id="Error_User" style="color:#FFFFFF;font-weight:bold; white-space:nowrap;">&nbsp;</div></td>
          </tr>
          <tr>
            <td><font color="#FFFFFF">Passwort:</font></td>
            <td><input name="txtPass" type="password" id="txtPass" style="width:150px;"/></td>
            <td><div id="Error_Pass" style="color:#FFFFFF;font-weight:bold; white-space:nowrap;">&nbsp;</div></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td colspan="2"><input type="submit" name="button" id="button" value="Senden" />            </td>
          </tr>
          <tr>
            <td height="40" colspan="3"><div style="color:#FFFFFF; font-weight:bold;" id="ErrorMSG">&nbsp;</div>
                <div style="color:#FFFFFF; font-weight:bold;" id="ErrorMSG1">&nbsp;</div></td>
          </tr>
        </form>
      </table>
    Als Gast einloggen:<br />
    Benutzer:gast<br />
    Passwort: gast<!-- InstanceEndEditable --></div>
  </div>
  <div id="bottom"></div>
</div>
</body>
<!-- InstanceEnd --></html>
