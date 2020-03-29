<html>
<body>
	<form action="/BankAppTomcat/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>
	<h4 align="center">Available balance: ${Balance} </h4>
	
	<div>
	<form method="post" action="/BankAppTomcat/dashboard/FundTransfer/confirm" >
		Select Account: 
		<select name="fromAcc" required>
			<option></option>
			<option>${fromAcc}</option>
		</select>
		<br>
		Beneficiary Account:
		<input type="text" name="toAcc" required></input>
		<br>
		Amount:
		<input type="text" name="amount" required></input>
		<br>
		Description:
		<input type="text" name="Remark"></input>
		<br>
		<input type="submit" value="Confirm"></input>
	</form>
	</div>
	
	<div align="left">
			<br>
			<a href="/BankAppTomcat/dashboard/AccSummary">Home</a>
	</div>
	
</body>
</html>