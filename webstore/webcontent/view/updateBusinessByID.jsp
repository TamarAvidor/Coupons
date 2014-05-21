<%@ page import ="il.ac.hit.Business" %>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/webstore/style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Update Business</title>

</head>
<body>
<%
Business business = (Business) request.getAttribute("businessByID");
String businessAddress = business.getBusinessAddress();
String businessCategory = business.getBusinessCatgory();
String businessName = business.getBusinessName();
String businessPhoneNumber = business.getBusinessPhoneNumber();
int businessID = business.getBusinessId();
%>
<h1>Update Business ID #<%=businessID%></h1>

<form action=updateBusinessInfoByUser method=post >
	<label>Name:</label>
	<br /><input type="text" name="Name" value="<%=businessName %>" />
	<br /><br />
	<label>Address:</label>
	<br /><input type="text" name="Address"  value="<%=businessAddress %>"/>
	<br /><br />
	<label>Phone Number:</label>
	<br /><input type="text" name="PhoneNumber" value="<%=businessPhoneNumber %>"/>
	<br /><br />
	<label>Category:</label>
	<br /><input type="text" name="Category" value="<%=businessCategory %>"/>
	<br /><br />
	<br />
	<br /><input type="hidden" name="BusinessID" value="<%=businessID %>"/>
	<input type="submit" value="Send"  name="Update" />

</form>
</body>
</html>