
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="il.ac.hit.CouponsCart" %>
<%@ page import="il.ac.hit.Coupon" %>
<%@ page import="il.ac.hit.CouponsCartLine" %>
<%@ page import="java.util.Date, java.util.List" %>
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/webstore/jahnoon.css" />
  <link rel="stylesheet" href="/webstore/jquery.mobile.icons.min.css" />
  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" /> 
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
  <script src="http://ajax.googleapis.com/ajax/libs/jquerymobile/1.4.2/jquery.mobile.min.js"></script> 

</head>

<body>

<div data-role="page" data-control-title="Home" id="page1">
    <div data-theme="a" data-role="header" data-position="fixed">
        <h3>
            Coupons App
        </h3>
    </div>

<div data-role="content">
<%

	Coupon coup = (Coupon) request.getAttribute("coupon");
	if(session.getAttribute("cart") == null)
	{
		session.setAttribute("cart", new CouponsCart());
	}
	
	CouponsCart cart = (CouponsCart)(session.getAttribute("cart"));
	if (coup != null)
	{
		cart.addCoupon(coup);
	}
	
	out.println(cart.getXMLTable());

	%>
</div>
	<a href=coupons>back</a> 
</div>  
<br>




</body>
</html>