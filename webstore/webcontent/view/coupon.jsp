<%@ page language="java" import="java.util.*,il.ac.hit.Coupon" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
 <!-- meta charset="utf-8"  -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/webstore/jahnoon.css" />
  <link rel="stylesheet" href="/webstore/jquery.mobile.icons.min.css" />
  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" /> 
  <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script> 
  <script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	Coupon coup = (Coupon) request.getAttribute("coupon");
	out.print(coup.toString());
	int couponID = coup.getCouponID();
	String name = coup.getCouponName();
	String category = coup.getCouponCategory();
	Date ExpersionDate = coup.getCouponExpersionDate();
	double price = coup.getCouponPrice();
%>

<div data-role="page" data-control-title="Home" id="page1">
    <div data-theme="a" data-role="header" data-position="fixed">
        <h3>
            Coupons Details
        </h3>
    </div>
    <div data-role="content">
        <div data-role="fieldcontain" data-controltype="textarea">
            <label for="textarea1">
                Name
            </label>
            <textarea name="" id="textarea1" placeholder="" data-mini="true"><%=name%></textarea>
        </div>
        <div data-role="fieldcontain" data-controltype="textarea">
            <label for="textarea2">
                Category
            </label>
            <textarea name="" id="textarea2" placeholder="" data-mini="true"><%=category %></textarea>
        </div>
        <div data-role="fieldcontain" data-controltype="textarea">
            <label for="textarea3">
                Expersion Date
            </label>
            <textarea name="" id="textarea3" placeholder="" data-mini="true"><%=ExpersionDate %></textarea>
        </div>
        <div data-role="fieldcontain" data-controltype="textarea">
            <label for="textarea5">
                Price
            </label>
            <textarea name="" id="textarea5" placeholder="" data-mini="true"><%=price%></textarea>
        </div>
    </div>

    <a data-role="button" href=couponsCart?couponID=<%=String.valueOf(couponID)%> data-ajax="false">
            Select
   	</a>
   	
	<a href=coupons>back</a> 
   	</div>


   	
   	
   	
   	
    <div data-role="tabbar" data-iconpos="top" data-theme="a">
        <ul>
            <li>
                <a href="#page1" data-transition="fade" data-theme="" data-icon="home">
                    Home
                </a>
            </li>
            <li>
                <a href="#page2" data-transition="fade" data-theme="" data-icon="star">
                    Components
                </a>
            </li>
            <li>
                <a href="#page3" data-transition="fade" data-theme="" data-icon="info">
                    ertteee
                </a>
            </li>
        </ul>
    </div>
</div>

</body>
</html>