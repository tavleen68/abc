<!DOCTYPE html>
<html>

<body>
	
	<form action="/BankAppTomcat/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>
	
	<div align="center">
		<h2 align="center">Amount ${amount} has been transferred successfully from ${fromAcc} to ${toAcc}</h2>
	</div>
	
	<div align="left">
			<a href="/BankAppTomcat/dashboard/AccSummary">Home</a>
	</div>
	
</body>
</html>