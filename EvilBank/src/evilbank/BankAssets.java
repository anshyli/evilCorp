package evilbank;

import java.util.ArrayList;

public class BankAssets {
	private ArrayList<Account> acctList = new ArrayList<Account>();
	
	public BankAssets() {

	}

	public  ArrayList<Account> getAcctList() {
		return this.acctList;
	}

	public  void setAcctList(ArrayList<Account> acctList) {
		this.acctList = acctList;
	}
	
	public void addAcct(Account anAcct) {
		acctList.add(anAcct);
//		return true;
	}
	public boolean deletAcct(Account anAcct) {
		boolean flag = false;
		if (anAcct.getAcctBalance() > 0.0) 	flag = acctList.remove(anAcct);
		else System.out.println("You have " + Account.formatDollar(anAcct.getAcctBalance()) + " balance. Account can not be closed.");
		return flag;
	}
}
