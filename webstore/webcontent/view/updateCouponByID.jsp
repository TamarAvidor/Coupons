<%@ page import ="il.ac.hit.Coupon, java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" href="style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Update Business</title>

</head>
<body>
<%
Coupon coupon = (Coupon) request.getAttribute("couponByID");
String couponName = coupon.getCouponName();
String couponCategory = coupon.getCouponCategory();
Double couponPrice = coupon.getCouponPrice();
Date couponExpersionDate = coupon.getCouponExpersionDate();
int couponID = coupon.getCouponID();
%>
<h1>Update Coupon ID #<%=couponID%></h1>

<form action=updateCouponInfoByUser method=post >
	
	<label>Name:</label>
	<br /><input type="text" name="Name" value="<%=couponName %>" />
	<br /><br />
	<label>Price:</label>
	<br /><input type="text" name="Price"  value="<%=couponPrice %>"/>
	<br /><br />
	<label>Expersion Date:</label>
	<br /><input type="text" name="ExpersionDate" value="<%=couponExpersionDate %>"/>
	<br /><br />
	<label>Category:</label>
	<br /><input type="text" name="Category" value="<%=couponCategory %>"/>
	<br />
	<br /><input type="hidden" name="CouponID" value="<%=couponID %>"/>
	<input type="submit" value="Send"  name="Update" />

</form>
</body>
</html>