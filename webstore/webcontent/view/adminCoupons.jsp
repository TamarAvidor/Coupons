<%@page import="il.ac.hit.HibernateDAO"%>
<%@ page import="java.util.List, java.util.Date, il.ac.hit.Coupon" language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="../bootstrap/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="../assets/ico/favicon.png">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Admin Interface</a>
          <div class="nav-collapse collapse">
          <p class="navbar-text pull-right">
         	 <% 
					Object adminName = session.getAttribute("connectedAdminName");
					if (adminName != null)
					{
		 	 %>
						Logged in as <%=adminName.toString()%>
		   	 <% 
					}
		 	 %>
             
          </p>
            <ul class="nav">
              <li class="active"><a href="businesses">Home</a></li>
              <li><a href="adminCoupons">Coupons</a></li>
              <li><a href="about">About</a></li>
              <li><a href="logout">Logout</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <h1>Coupons List</h1>
    </div> <!-- /container -->
    
     <div class="span12">
     <div class="hero-unit">
<table>
<tr><td>Coupon</td><td>ExpersionDate</td></tr>
<% 

	Object admin = session.getAttribute("connectedAdmin");
	if (admin == null)
	{
		out.print("<font color=red>You are not allowed to view this screen!</font>");
	}
	else
	{
		Object ob = request.getAttribute("coupons");
		@SuppressWarnings("unchecked")
		List<Coupon> listOfBusinesses = (List<Coupon>)ob;
		for (int i=0; i<listOfBusinesses.size(); i++ )
		{
			//out.println(listOfBusinesses.get(i).printCouponFields());
			Coupon currentCoupon = listOfBusinesses.get(i);
			int couponID = currentCoupon.getCouponID();
			String name = currentCoupon.getCouponName();
			Date ExpersionDate = currentCoupon.getCouponExpersionDate();
			
	%>
			<tr><td><%= name %></td><td><%= ExpersionDate %></td><td><a href=couponsCart?couponID=<%=String.valueOf(couponID)%>>select</a></td><td><a href=deleteCouponByID/<%=couponID%>>delete</a></td><td><a href=updateCouponByID/<%=couponID%>>update</a></td></tr>
	<%
		}
	}
	%>
	</table>
</div>		
</div>
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap-transition.js"></script>
    <script src="../assets/js/bootstrap-alert.js"></script>
    <script src="../assets/js/bootstrap-modal.js"></script>
    <script src="../assets/js/bootstrap-dropdown.js"></script>
    <script src="../assets/js/bootstrap-scrollspy.js"></script>
    <script src="../assets/js/bootstrap-tab.js"></script>
    <script src="../assets/js/bootstrap-tooltip.js"></script>
    <script src="../assets/js/bootstrap-popover.js"></script>
    <script src="../assets/js/bootstrap-button.js"></script>
    <script src="../assets/js/bootstrap-collapse.js"></script>
    <script src="../assets/js/bootstrap-carousel.js"></script>
    <script src="../assets/js/bootstrap-typeahead.js"></script>

  </body>
</html>
