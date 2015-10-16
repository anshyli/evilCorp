package evilbank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;

import static org.junit.Assert.*;

public class EvilBankTest {
	
	@Test
	public void test_compareTo1() {
		System.out.println("Test Transaction compareTo by date in mm/dd/yyyy");
		Transaction trans1 = new Transaction("1234", 10.0, "Check", "10/31/2014");
		Transaction trans2 = new Transaction("1234", 10.0, "Debit", "10/31/2015");
		assertTrue(trans1.compareTo(trans2) == -1);
	}
	@Test
	public void test_compareTo2() {
		System.out.println("Test Transaction compareTo by date in mm/dd/yyyy");
		Transaction trans1 = new Transaction("1234", 10.0, "Check", "10/31/2015");
		Transaction trans2 = new Transaction("1234", 10.0, "Debit", "10/31/2014");
		assertTrue(trans1.compareTo(trans2) == 1);
	}
	@Test
	public void test_compareTo() {
		System.out.println("Test Transaction compareTo by date in mm/dd/yyyy");
		Transaction trans1 = new Transaction("1234", 10.0, "Check", "10/31/2014");
		Transaction trans2 = new Transaction("1234", 10.0, "Debit", "10/31/2014");
		assertTrue(trans1.compareTo(trans2) == 0);
	}
	@Test
	public void test_deleteAcct0() {
		System.out.println("Test BankAssets deleteAcct for existing account with 0.0 balance");
		EvilBankApp aBank = new EvilBankApp();
		Account acct1 = new Account("1234");
		Account acct2 = new Account("4321");
		aBank.bankAssets.getAcctList().add(acct1);
		aBank.bankAssets.getAcctList().add(acct2);
		System.out.println("Show the account list.");
		for (Account acct : aBank.bankAssets.getAcctList()){
			System.out.println("Account number: " + acct.getAcctNo());
		}
		aBank.bankAssets.deletAcct(acct1);
		System.out.println("Show the account list after delete.");
		for (Account acct : aBank.bankAssets.getAcctList()){
			System.out.println("Account number: " + acct.getAcctNo());
		}		
	}
	@Test
	public void test_deleteAcct1() {
		System.out.println("Test BankAssets deleteAcct for existing account with not 0.0 balance");
		EvilBankApp aBank = new EvilBankApp();
		Account acct1 = new Account("1234");
		acct1.setAcctBalance(10.0);
		Account acct2 = new Account("4321");
		aBank.bankAssets.getAcctList().add(acct1);
		aBank.bankAssets.getAcctList().add(acct2);
		System.out.println("Show the account list.");
		for (Account acct : aBank.bankAssets.getAcctList()){
			System.out.println("Account number: " + acct.getAcctNo());
		}
		aBank.bankAssets.deletAcct(acct1);
		System.out.println("Show the account list after delete.");
		for (Account acct : aBank.bankAssets.getAcctList()){
			System.out.println("Account number: " + acct.getAcctNo());
		}		
	}
	@Test
	public void test_deleteAcct2() {
		System.out.println("Test BankAssets deleteAcct for account not existing");
		EvilBankApp aBank = new EvilBankApp();
		Account acct1 = new Account("1234");
		acct1.setAcctBalance(10.0);
		Account acct2 = new Account("4321");
		aBank.bankAssets.getAcctList().add(acct1);
//		aBank.bankAssets.getAcctList().add(acct2);
		System.out.println("Show the account list.");
		for (Account acct : aBank.bankAssets.getAcctList()){
			System.out.println("Account number: " + acct.getAcctNo());
		}
		aBank.bankAssets.deletAcct(acct2);
		System.out.println("Show the account list after delete.");
		for (Account acct : aBank.bankAssets.getAcctList()){
			System.out.println("Account number: " + acct.getAcctNo());
		}			
	}
	@Test
	public void test_toString () {
		System.out.println("Test Transaction toString method.");
		// instantiate a Transaction object
		Transaction aTrans = new Transaction();
		aTrans.setAcctNo("1234");
		aTrans.setChangeAmt(10.0);
		aTrans.setDate("10/11/1111");
		aTrans.setType("Check");
		String theTrans = aTrans.toString();
		assertTrue(theTrans.equals("Transaction type: Check  Account:1234  Change Amount: 10.0  Date: 10/11/1111"));
	}
	@Test
	public void test_writeToFile() {
		System.out.println("Test Transaction writeToFile method.");
		// instantiate a Transaction object
		Transaction aTrans = new Transaction("1234",10.0, "Debit", "10/10/1001");
		aTrans.writeToFile("testWrite2File.txt");
		// testWrite2File.txt file created in C:\Users\gbtc440008ur\git\evil\EvilBank
    	String fileName = System.getProperty("user.dir") + File.separatorChar + "testWrite2File.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			assertTrue(line.equals("Debit|1234|10.0|10/10/1001"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

