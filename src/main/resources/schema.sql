
CREATE TABLE login_details (user_id VARCHAR(200) NOT NULL,password VARCHAR(200) NOT NULL,Name VARCHAR(200) NOT NULL,Account_number INT NOT NULL,PRIMARY KEY (user_id));


CREATE TABLE Enquiry_details (Account_number INT NOT NULL,Branch_code INT NOT NULL,Account_type VARCHAR(200) ,Balance INT NOT NULL,Currency VARCHAR(200) ,Status VARCHAR(200) NOT NULL,PRIMARY KEY (Account_number));


CREATE TABLE Customer_transactions (Account_number INT NOT NULL, Branch_code INT NOT NULL, Description VARCHAR(200), Withdrawal INT, Deposit INT, Closing_balance INT, Time DATETIME NOT NULL, PRIMARY KEY (Account_number));
