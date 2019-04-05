package bookstore;



 //usues the interface IAccount with implements
 import java.util.Date;
 import java.time.*;
public class  Account {

	private String idName;
	private boolean accountState;
	private String  dateCreated;
	private char credits;

	public Account(){}

	//@Override
	//overrides the method in the interface IAccount
	public void displayInfo(){
			System.out.println("Account info is :" + getAccountState() + "ID : " + getidName() + "Credit value : " + getCredits());
		}

	// accountState setget
	public void setAccountState(boolean accountState){
			this.accountState = accountState;
		}

	public boolean getAccountState(){
			return accountState;
		}

	// dateCreated setget
	public void setDateCreated(String  dateCreated){
			this.dateCreated = dateCreated;
		}

	public String  getDateCreated(){
			return dateCreated;
		}

	// idName setget
	public void setidName(String idName){
	    	this.idName = idName;
		}

	public String getidName(){
			return idName;
		}

	// credits setget
	public void setCredits(char credits){
	    	this.credits = credits;
		}

	public char getCredits(){
			return credits;
		}


	@Override
	public String toString(){
		return"\nName :"+ idName +"\nAccount Active :"+ accountState +"\nDate created :"+ dateCreated +"\nCredits :"+ credits;
	}

}