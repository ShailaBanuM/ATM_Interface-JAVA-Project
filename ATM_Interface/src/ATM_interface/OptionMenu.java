package ATM_interface;

import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.text.DecimalFormat;

public class OptionMenu extends Account
{
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap <Integer,Integer> data = new HashMap <Integer,Integer>();
	
	public void getLogin() throws IOException{
		int x=1;
		do{
			try {
				data.put(12345,100);
				data.put(67890,200);
				
				System.out.println(" *****   Welcome to the ATM Project ***** \n \n");
				System.out.println("Enter your Account Number \n");								
				
				setAccNumber(menuInput.nextInt());
				System.out.println();
				
				System.out.println("Enter your Pin Number \n ");
				setPinNumber(menuInput.nextInt());
				System.out.println();
			}
			catch (Exception e)
			{
				System.out.println("\n" +"Wrong Account Number or Pin Number" +"\n");
				x=2;
			}
			int an=getAccNumber();
			int pn=getPinNumber();
			if(data.containsKey(an) && data.get(an) == pn){
				getAccountType();
			}else
				System.out.println("\n" +"Wrong Account Number or Pin Number" +"\n");
		}while(x==1);
		}
		
		public void getAccountType()
		{
			System.out.println();
			System.out.println("Select the Account type you want to access");
			System.out.println("Type 1. Checking Account");
			System.out.println("Type 2. Saving Account");
			System.out.println("Type 3. Exit \n");
			System.out.println("Your Choice please");
			int selection = menuInput.nextInt();

			
			switch(selection)
			{
			case 1:
				getChecking();
				System.out.println();
				break;				
			case 2:
				getSaving();
				System.out.println();
				break;
			case 3:
				System.out.println("Thank you for using this ATM, Bye. \n");
				break;
			}
		}
			public void getChecking()
			{
				System.out.println();
				System.out.println("Checking Account");
				System.out.println("Type 1. View Balance");
				System.out.println("Type 2. Withdraw Funds");
				System.out.println("Type 3. Deposit Funds");
				System.out.println("Type 4. Exit \n");
				System.out.println("Your Choice please");
				int selection = menuInput.nextInt();
				
				switch(selection)
				{
				case 1:
					System.out.println("Checking Account Balance: " +moneyFormat.format(getCheckingBalance()));
					getAccountType();
					System.out.println();
					break;
				case 2:
					getCheckingWithdrawInput();
					getAccountType();
					System.out.println();
					break;
				case 3:
					getCheckingDepositInput();
					getAccountType();
					System.out.println();
					break;
				case 4:
					System.out.println("Thank you for using this ATM, Bye. \n");
					System.out.println();
					break;
				default:
					System.out.println("\n Invalid Choice \n");  
					getChecking();
				}
			}
		
		public void getSaving()
		{
			System.out.println("Saving Account : ");
			System.out.println("Type 1 : View Balance");
			System.out.println("Type 2 : Withdraw Funds");
			System.out.println("Type 3 : Deposit Funds");
			System.out.println("Type 4 : Exit \n");
			System.out.println("Your Choice please");
			
			int selection = menuInput.nextInt();
			System.out.println("\n \n");
			
			switch(selection)
			{
			case 1:
				System.out.println("Saving Account Balance: " +moneyFormat.format(getSavingBalance()));
				getAccountType();
				System.out.println();
				break;
			case 2:
				getSavingWithdrawInput();
				getAccountType();
				System.out.println();
				break;
			case 3:
				getSavingDepositInput();
				getAccountType();
				System.out.println();
				break;
			case 4:
				System.out.println("Thank you for using this ATM, Bye. \n");
				System.out.println();
				break;
			default:
				System.out.println("\n Invalid Choice \n");  
				getChecking();
		}
	}
}
