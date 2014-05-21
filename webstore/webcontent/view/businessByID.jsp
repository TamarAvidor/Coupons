<%@ page import ="il.ac.hit.Business, java.util.List, java.util.Iterator" import ="il.ac.hit.Coupon" %>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
		<h1>businessByID</h1>
		<%
			Business business = (Business) request.getAttribute("businessByID");
			out.print(business.printBusinessFields());
			List <Coupon> businessCoupons = (List <Coupon>) request.getAttribute("BusinessCouponsSet");
		 	//Coupon[] businessCouponsArray = (Coupon[]) businessCoupons.toArray();
			/*Iterator <Coupon> CouponsIterator = businessCouponsSet.iterator();
			while (CouponsIterator.hasNext())
			{
				CouponsIterator.next().toString();
			}		*/
		%>
</body>
</html>

