import java.util.Random;
import java.util.Scanner;

public class Demo {

	
	public static void main(String[] args) {
		
		int userMoney = 0;
		int Bet = 1;
		Boolean Win = true;
		int MoreFunds = 0;		
		String addFunds = "y";
		String Continue = "y";
		int WinMultipler = 1;
		
		Scanner keyboard = new Scanner (System.in);
		Random rand = new Random();
		
		System.out.println("########### PEREZ SLOTZ ###########");
		System.out.println();
		System.out.println("Welcome to Perez Slotz! Please enter the amount"
				+ " of money you want to wager. Only $1 to play");
		
		userMoney = keyboard.nextInt();
		
		while (userMoney <= 0)
		{
			
			System.out.println();
			System.out.println("You have have not entered any money. Please enter any amount"
					+ " above $0.");
			
			userMoney = keyboard.nextInt();
			
		}
		
		System.out.println("you have entered $" + userMoney);
		System.out.println();
		
		Scanner scan = new Scanner (System.in);
		Scanner add = new Scanner (System.in);
		Scanner more = new Scanner (System.in);
		
		while (userMoney != 0 && Continue.equalsIgnoreCase("y"))		
		{
			System.out.println("########### PEREZ SLOTZ ###########");
			System.out.println();
			
			int spin1 = rand.nextInt(3) + 1;
			int spin2 = rand.nextInt(3) + 1;
			int spin3 = rand.nextInt(3) + 1;
			
			
			switch (spin1)
			{
			
			case 1: 
				System.out.print(" BAR ");
				break;
			case 2:
				System.out.print(" 7 ");
				break;
			case 3:
				System.out.print(" JACKPOT ");
				break;
			}
			
			switch (spin2)
			{
			
			case 1: 
				System.out.print(" BAR ");
				break;
			case 2:
				System.out.print(" 7 ");
				break;
			case 3:
				System.out.print(" JACKPOT ");
				break;
			}
			
			switch (spin3)
			{
			
			case 1: 
				System.out.println(" BAR ");
				break;
			case 2:
				System.out.println(" 7 ");
				break;
			case 3:
				System.out.println(" JACKPOT ");
				break;
			}
			
			System.out.println();
			
			Win = (spin1 == spin2 && spin1 == spin3 && spin2 == spin3) ? true: false;
			
			System.out.println((Win == true ? "You WIN!!! "
					+ "x10" : " "));
			
			System.out.println();
			
			WinMultipler = (Win == true) ? 10: 1;
			
			Bet =  WinMultipler * Bet;
			
			userMoney = (Win == true) ? userMoney + Bet : userMoney + 0;
			userMoney--;
			Bet = 1;
			
			System.out.println("REMAINING BALANCE: $" + userMoney);
			System.out.println();
			
			System.out.println("Would you like to add more credits?"
					+ " Enter y or n");
			addFunds = add.nextLine();
			System.out.println();
			
			while (!addFunds.equalsIgnoreCase("y") && !addFunds.equalsIgnoreCase("n"))
			{
				
				System.out.println();
				System.out.println("Please only use y or n");
				
				addFunds = add.nextLine();
				
			}
			
			if (userMoney == 0)
			{
				break;
				
			} else {
				
				userMoney = userMoney + 0;
			}
			
			if (addFunds.equalsIgnoreCase("n"))
			{
				userMoney = userMoney + 0;
				
			} else {
				
			System.out.println("How much would you like to add?");
			MoreFunds = more.nextInt();
			
			while (MoreFunds > 0)
			{
				
				System.out.println();
				System.out.println("Please enter a proper dollar amount");
				
				MoreFunds = more.nextInt();
				
			}
			
			userMoney = userMoney + MoreFunds;
			
			System.out.println();
		}
			
			
			System.out.println("Would you like to spin? Press y then Enter to continue");
			System.out.println("Press n then Enter to Quit");
			System.out.println("REMAINING BALANCE: $" + userMoney);
			System.out.println();
			Continue = scan.nextLine();
			System.out.println();
			

		}
		
		System.out.println("##################################");
		System.out.println("GAME OVER");
		System.out.println("Printing ticket of: $" + userMoney);
		System.out.println("Thanks for playing!");
		
	}

}

