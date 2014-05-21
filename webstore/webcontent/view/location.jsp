<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<script language="javascript">

function processLocation(userPosition) {
	//document.getElementById("x").innerHTML = "test";
	 var longitude = userPosition.coords.longitude;
	 var latitude = userPosition.coords.latitude;
	 alert(longitude + " " +latitude);
	 
	     $.ajax({
	        url: 'http://localhost:8080/webstore/controller/processLocation',
	        type: 'POST',
	        	data: {
	            	url : 'http://localhost:8080/webstore/controller/processLocation',
	        		longitude: longitude,
	        		latitude : latitude
	            },
	            success: function(data)
	            {
		            document.getElementById("x").innerHTML = data;
	                alert(data);
	            	// window.close();
	            }
	    });
}

window.navigator.geolocation.getCurrentPosition(processLocation);

</script>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
	<title>Insert title here</title>
</head>
<body>
	<div id="x">
	test
	</div>
</body>
</html>