<%@page import="il.ac.hit.HibernateDAO"%>
<%@ page import="java.util.List, il.ac.hit.Business" language="java" contentType="text/html; charset=windows-1255"
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
              <li class="active"><a href="#">Home</a></li>
              <li><a href="adminCoupons">Coupons</a></li>
              <li><a href="about">About</a></li>
              <li><a href="logout">Logout</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <h1>Businesses List</h1>
    </div> <!-- /container -->
    
     <div class="span12">
     <div class="hero-unit">
    <table>
<tr><td>ID</td><td> Name </td><td> Address </td><td> Category </td><td> Phone Number </td></tr>
<% 

	Object admin = session.getAttribute("connectedAdmin");
	if (admin == null)
	{
		out.print("<font color=red>You are not allowed to view this screen!</font>");
	}
	else
	{
		Object ob = request.getAttribute("businesses");
		@SuppressWarnings("unchecked")
		List<Business> listOfBusinesses = (List<Business>)ob;
		for (int i=0; i<listOfBusinesses.size(); i++ )
		{
			//out.println(listOfBusinesses.get(i).printCouponFields());
			Business currentBusiness = listOfBusinesses.get(i);
			int businessID = currentBusiness.getBusinessId();
			String name = currentBusiness.getBusinessName();
			String businessAddress = currentBusiness.getBusinessAddress();
			String businessCategory = currentBusiness.getBusinessCatgory(); 
			String businessPhoneNumber = currentBusiness.getBusinessPhoneNumber();
			
	%>
			<tr><td> <%= businessID %> </td><td> <%= name %> </td><td> <%= businessAddress %> </td><td> <%= businessCategory %> </td><td> <%= businessPhoneNumber %> </td><td> <a href=businessByID/<%=businessID%>> select </a></td><td><a href=updateBusinessByID/<%=businessID%>> update </a></td><td><a href=deleteBusinessByID/<%=businessID%>> delete </a></td></tr>
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
