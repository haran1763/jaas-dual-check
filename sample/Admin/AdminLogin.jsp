<!Doctype html>
<html>
<head>
</head>
<body>

<h2>Login page</h2>

<form action="j_security_check" method="POST">
	<label>Enter the email</label>
	<input type="text" name="j_username" /><br />
	<label>Enter the password</label>
	<input type="password" name="j_password" /><br />
	<input type="hidden" name="tname" id="demo" />
	<input type="submit" value="get OTP"/>
</form>

<script>
	document.getElementById("demo").value = window.location.pathname;
</script>
</body>
</html>