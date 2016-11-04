#language: en

Feature: Bank Transfer
	As a user, I want to transfer money from one account to another account.
	After transfer, the money of original account and destination account should
	changed consistently.
	
	Background:
		* Create an account '0001' as origin account
		* Save 100 to account '0001'
		* Create an account '0002' as destination account
	
	Scenario: Success transfer
		When Transfer 30 from account '0001' to '0002'
		Then The account '0001' should have 70
		And The account '0002' should have 30
	 
	Scenario: Failed to transfer when account is no enough money
		When Transfer 120 from account '0001' to '0002'
		Then The transfer result should be 'fail'
		And The account '0001' should have 100
		And The account '0002' should have 0
	 	