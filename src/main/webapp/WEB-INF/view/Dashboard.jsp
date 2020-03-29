<html>
<body>
	
	<form action="/BankAppTomcat/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>
	
		<div align="left">
		<a href="/BankAppTomcat/dashboard/AccSummary">Account Summary</a>
		<br>
		<p> Enquiry</p>
		<a href="/BankAppTomcat/dashboard/AccountInfo">Account Information</a>
		<br>
		<p> Fund Transfer</p>
		<a href="/BankAppTomcat/dashboard/FundTransfer">Fund Transfer</a>
		</div>
		<div align="center">
			<h2 align="center">Available Balance: ${Balance} ${Currency}</h2>
		</div>
	 </body>
	 </html>
		
	
	