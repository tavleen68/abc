<html>
<body>
	<h2 align="center"> Welcome to Wipro Bank</h2>
	
	<form method="post" action="/BankAppTomcat/dashboard" >
		UserID: 
		<input type="text" name="userID" required></input>
		<br>
		Password:
		<input type="password" name="password" required></input>
		<br>
		<input type="submit" value="Login"></input>
	</form>
	
	<form action="/BankAppTomcat/forgotPassword">
		<input type="submit" value="Forgot Password?"></input>
	</form>
</body>
</html>