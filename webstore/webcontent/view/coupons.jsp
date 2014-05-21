<%@ page import="java.util.List,java.util.Date, il.ac.hit.Coupon" language="java"  contentType="text/html; charset=windows-1255"
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

<script>
$(function() {
	$("#selectmenu1").change(function() {
		window.location.href = "coupons?category="+$(this).val();
	});
});
</script>
</head>
<body>
<%
String selectedCategory = "all";

if(request.getParameter("category") != null)
	selectedCategory = request.getParameter("category");


%>
<div data-role="page" data-control-title="Home" id="page1">
    <div data-theme="a" data-role="header" data-position="fixed">
        <h3>
            Coupons App
        </h3>
    </div>
    <div data-role="content">
    
 
        <div data-role="fieldcontain" data-controltype="selectmenu">
            <label for="selectmenu1">
                Category:
            </label>
            
            <select id="selectmenu1" name="">
                <option value="All" <%=(selectedCategory.equals("All") ? "selected=selected" : "")%>>
                    All
                </option>
                <option value="Food" <%=(selectedCategory.equals("Food") ? "selected=selected" : "")%>>
                    Food
                </option>
                <option value="Movies" <%=(selectedCategory.equals("Movies") ? "selected=selected" : "")%>>
                    Movies
                </option>
                <option value="Shows" <%=(selectedCategory.equals("Shows") ? "selected=selected" : "")%>>
                    Shows
                </option>
                <option value="Spa" <%=(selectedCategory.equals("Spa") ? "selected=selected" : "")%>>
                    Spa
                </option>
                <option value="Sports" <%=(selectedCategory.equals("Sports") ? "selected=selected" : "")%>>
                    Sports
                </option>
            </select>
        </div>
    
    
    
        <ul data-role="listview" data-divider-theme="b" data-inset="true">
  		            <li data-role="list-divider" role="heading">
                Coupons list
            </li>
  		<% 
	Object ob = request.getAttribute("coupons");
 	selectedCategory = request.getParameter("category");
	@SuppressWarnings("unchecked")
	List<Coupon> listOfCoupons = (List<Coupon>)ob;
	for (int i=0; i<listOfCoupons.size(); i++ )
	{
		//out.println(listOfBusinesses.get(i).printCouponFields());
		Coupon currentCoupon = listOfCoupons.get(i);
		int couponID = currentCoupon.getCouponID();
		String name = currentCoupon.getCouponName();
		Date ExpersionDate = currentCoupon.getCouponExpersionDate();
		
%>
	
	
		    <li data-theme="c">
                <a href=coupon?couponID=<%=String.valueOf(couponID)%> data-transition="slide">
                   <%= name %>
                </a>
            </li>
<%
	}
%>

        </ul>
    </div>
    <div data-role="tabbar" data-iconpos="top" data-theme="a">
        <ul>
            <li>
                <a href="couponsCart" data-transition="fade" data-theme="" data-icon="home">
                    Coupons Cart
                </a>
            </li>
            <li>
                <a href="#page2" data-transition="fade" data-theme="" data-icon="star">
                    Components
                </a>
            </li>
            <li>
                <a href="#page3" data-transition="fade" data-theme="" data-icon="info">
                    Platforms
                </a>
            </li>
        </ul>
    </div>
</div>


</body>
</html>