import java.util.Random;
import java.util.Scanner;

public class Demo {

	
	public static void main(String[] args) {
		
		//Variables for calculating conditionals
		int userMoney = 0;
		int Bet = 1;
		Boolean Win = true;
		int MoreFunds = 0;		
		String addFunds = "y";
		String Continue = "y";
		int WinMultiplier = 1;
		
		//Scanner object created for user input
		Scanner keyboard = new Scanner (System.in);
		
		//Random object created for slot machine results
		Random rand = new Random();
		
		//GUI creation and user entering money
		System.out.println("########### PEREZ SLOTZ ###########");
		System.out.println();
		System.out.println("Welcome to Perez Slotz! Please enter the amount"
				+ " of money you want to wager. Only $1 to play");
		userMoney = keyboard.nextInt();
		
		//Input validation loop
		while (userMoney <= 0)
		{
			
			System.out.println();
			System.out.println("You have have not entered any money. Please enter any amount"
					+ " above $0.");
			
			userMoney = keyboard.nextInt();
			
		}
		
		//Confirmation of user input
		System.out.println("you have entered $" + userMoney);
		System.out.println();
		
		//Scanner objects created for user confirmation to play or continue
		Scanner scan = new Scanner (System.in);
		Scanner add = new Scanner (System.in);
		Scanner more = new Scanner (System.in);
		
		
		//Beginning of game play loop. Validates user still has money to play or still wants to play
		while (userMoney != 0 && Continue.equalsIgnoreCase("y"))		
		{
			System.out.println("########### PEREZ SLOTZ ###########");
			System.out.println();
			
			//Random objects assigned to three spins
			int spin1 = rand.nextInt(3) + 1;
			int spin2 = rand.nextInt(3) + 1;
			int spin3 = rand.nextInt(3) + 1;
			
			//Based on random spin, selects what to display on slots
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
			
			//Confirms a win or loss and stores in boolean
			Win = (spin1 == spin2 && spin1 == spin3 && spin2 == spin3) ? true: false;
			
			//If win, display this message
			System.out.println((Win == true ? "You WIN!!! "
					+ "x10" : " "));
			
			System.out.println();
			
			//If win, add multiplier to variable
			WinMultiplier = (Win == true) ? 10: 1;
			
			//Store the earnings in variable
			Bet =  WinMultiplier * Bet;
			
			//Adds winnings to remaining balance, if not then nothing is added
			userMoney = (Win == true) ? userMoney + Bet : userMoney + 0;
			//Subtracts from balance to simulate betting 
			userMoney--;
			//Resets bet multiplier back to 1
			Bet = 1;
			
			//Displays new balance with earnings added or not plus taking away $1 for betting
			System.out.println("REMAINING BALANCE: $" + userMoney);
			System.out.println();
			
			//Asks user if they want to add more money and stores it
			System.out.println("Would you like to add more credits?"
					+ " Enter y or n");
			addFunds = add.nextLine();
			System.out.println();
			
			//Validation input loop
			while (!addFunds.equalsIgnoreCase("y") && !addFunds.equalsIgnoreCase("n"))
			{
				
				System.out.println();
				System.out.println("Please only use y or n");
				
				addFunds = add.nextLine();
				
			}
			
			//If they still have a balance and do not want add, game continues
			//If user does not want to enter more money and has none left, game ends
			if (userMoney == 0 && addFunds.equals("n"))
			{
				break;
				
			} else {
				
				userMoney = userMoney + 0;
			}
			
			if (addFunds.equalsIgnoreCase("n"))
			{
				userMoney = userMoney + 0;
				
			//If they want to enter more money, it is stored in variable
			} else {
				
			System.out.println("How much would you like to add?");
			MoreFunds = more.nextInt();
			
			//Input validation loop
			while (MoreFunds <= 0)
			{
				
				System.out.println();
				System.out.println("Please enter a proper dollar amount");
				
				MoreFunds = more.nextInt();
				
			}
			
			//Adds more money that was stored to balance 
			userMoney = userMoney + MoreFunds;
			
			System.out.println();
		}
			
			//Asks if the user wants to continue, if not the game ends
			//Displays balance after all factors have been applied
			System.out.println("Would you like to spin? Press y then Enter to continue");
			System.out.println("Press n then Enter to Quit");
			System.out.println("REMAINING BALANCE: $" + userMoney);
			System.out.println();
			Continue = scan.nextLine();
			System.out.println();
			

		}
		
		//End of game and user winnings are displayed
		System.out.println("##################################");
		System.out.println("GAME OVER");
		System.out.println("Printing ticket of: $" + userMoney);
		System.out.println("Thanks for playing!");
		
	}

}

