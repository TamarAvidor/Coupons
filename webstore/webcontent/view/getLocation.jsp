<html>
 <head>
<title>Just Simple Title</title>
<script language="javascript">
	function myfunc(ob) 
	{
		alert("latitude="+ob.coords.latitude+" longitude="+ob.coords.longitude);
	}
	function errfunc(ob)
	{
		alert(ob.message);
	}
	if(window.navigator.geolocation)
	{
		window.navigator.geolocation.getCurrentPosition(myfunc,errfunc);
	}
	else
	{
		alert("geolocation is not supported");
	}
</script>
</head>
<body>

</body>
</html>