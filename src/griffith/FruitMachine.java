package griffith;
import java.util.*;
public class FruitMachine {

	public static class declaringconstants {
		public static final int CREDITPERGAME = 20;
	}

	public static int startCredit = 200;
	public static int creditPerGame = 20;
	public static int playerCredit = startCredit;
	public static int count = 0;
	
    // ANSI escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";  //To make sure the text and background colour return to their default value
    public static final String ANSI_RED = "\u001B[31m";  //Red color
    public static final String ANSI_GREEN = "\u001B[32m"; //Green Color
    public static final String ANSI_DARK_GRAY = "\u001B[90m"; // Dark Grey
    public static final String ANSI_CYAN = "\u001B[36m"; //Blue Color
    public static final String ANSI_LIGHTBLUE_BG = "\u001b[48;5;87m"; //Blue Color
    public static final String ANSI_DARKGRAY_BG = "\u001B[0m"; // Dark Grey BG
    public static final String ANSI_PURPLE = "\u001B[35m"; // Purple Color

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Name  : Hussaina Hussain
		//Student Id : 3136381
		//Date of Submission : 16/01/24
		Scanner input = new Scanner(System.in);
		
		System.out.println(ANSI_DARKGRAY_BG + " ---------------------------------------------" + ANSI_RESET);
		System.out.println("|" + ANSI_CYAN + " Hello! Welcome to the Fruit Machine Game :) " + ANSI_RESET + "|");
		System.out.println(ANSI_DARKGRAY_BG + " ---------------------------------------------" + ANSI_RESET);
		while (true) //This loop makes sure the program keeps running till the user prefers otherwise
		{
			System.out.println("To access the menu at any time, type '" + ANSI_DARK_GRAY + "menu" + ANSI_RESET + "'");
			if (count >1 && count%3 == 0) //This loop awards the user 500 credits, if they win three times. The other part of the condition makes sure that the user is awarded 500 credits every three turns.
			{
				playerCredit+=500;
				System.out.println(ANSI_GREEN + "Congratulations! You won a bonus of 500 credits." + ANSI_RESET);
			}

			menu();

			if (playerCredit >= 100000) //This condition ends the game when the user reaches certain credit level.
			{
				System.out.println(ANSI_GREEN + "Congratulations! You have reached the end of the game." + ANSI_RESET);
				System.out.println("Thank you for playing : ) ");
				System.exit(0);
			}
		}

	}

	//MENU
	public static void menu()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println(ANSI_CYAN + " \t  MENU" + ANSI_RESET);
		System.out.println("---------------------------");
		System.out.println("1. " + ANSI_DARK_GRAY + "New Game" + ANSI_RESET);
        System.out.println("2. " + ANSI_DARK_GRAY + "View Ruleset" + ANSI_RESET);
        System.out.println("3. " + ANSI_DARK_GRAY + "View Remaining Credits" + ANSI_RESET);
        System.out.println("4. " + ANSI_DARK_GRAY + "Exit Game" + ANSI_RESET);
        System.out.println("Select Option (1-4)");
		System.out.println("--------------------------");
		
		if (input.hasNextInt()) //This conditional is to make sure the code keeps running in case the user enters something else. Learnt this from a youtube tutorial.
		{
			int menuOption = input.nextInt();
			switch(menuOption)
			{
			case 1:  //New Game
				if (playerCredit >= 20)
				{
					newGame();
				}
				else 
				{
					System.out.println(ANSI_RED + "You don't have enough credit, restart the game." + ANSI_RESET);
				}

				break;

			case 2:  //Rule set
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				System.out.println(ANSI_CYAN + "\t   \t      \t    \t          RULESET" + ANSI_RESET);
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				System.out.println("1. Triplet of any number except (9-9-9 and 0-0-0) = 150 credits. ");
				System.out.println("2. 9-9-9 = 1000 credits ");
				System.out.println("3. 0-0-0 = 0 credits ");
				System.out.println("4. 1-2-3 = 100 credits (consecutive successive 3 digits) ");
				System.out.println("5. 9-8-7 = 200 credits (consecutive decreasing 3 digits)");
				System.out.println("6. 2-4-7 = 1000 credits (special set)");
				System.out.println("7. Double numbers = 50 credits.");
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				System.out.println("The above ruleset is for the " + ANSI_GREEN +  "EASY" + ANSI_RESET + " mode");
				System.out.println("For the " + ANSI_GREEN +  "MEDIUM" + ANSI_RESET + " mode, the credits awarded will increase by 50%");
				System.out.println("For the " + ANSI_GREEN +  "HARD" + ANSI_RESET + " mode, the credits awarded will increase by 100%");
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				System.out.println(ANSI_CYAN + "\t   \t      \t    \t          TWIST MODE" + ANSI_RESET);
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				System.out.println("This game also has a sopecial feature called the TWIST MODE. You can select this mode when you start a new game. ");
				System.out.println("This mode will allow you select the difficulty level ");
				System.out.println("If you win, then you score double the points (ex. If you choose difficulty level easy and score 5o credits now you win 100");
				System.out.println("But if you don't win, you lose 50 points.");
				System.out.println("---------------------------------------------------------------------------------------------------------------");

				break;

			case 3: //Remaining Credits
				System.out.println(ANSI_GREEN + "Remaining Credits = " + playerCredit + ANSI_RESET);
				break;

			case 4://Exit Game
				System.out.print("To exit the game enter " + ANSI_RED + "Z" + ANSI_RESET + ": ");
				char exitOption = input.next().charAt(0);
				if (exitOption == 'z' || exitOption == 'Z')
				{
					System.exit(0);
				}	
				else
				{
					System.out.println(ANSI_RED + "Kindly make sure you entered the right prompt." + ANSI_RESET);
				}
				break;
			default:
				System.out.println(ANSI_RED + "Kindly make sure you are entering the right prompt." + ANSI_RESET);
			}
		}
		else
		{
			System.out.println(ANSI_RED + "Kindly ensure you are only entering numbers." + ANSI_RESET);
		}
	}

	//Method for new game option in the menu
	public static void newGame()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select Difficulty Level (" + ANSI_DARK_GRAY + "easy, medium, hard, twist" + ANSI_RESET + "): ");
		String gameOption = input.nextLine();
		switch (gameOption.toLowerCase()) //The statement converts the string to lowercase to ensure the code doesn't break. This conditional just transfers the control to the methods necessary.
		{
		case "easy":
			easy();
			break;
		case "medium":
			med();
			break;
		case "hard":
			hard();
			break;	
		case "twist":
			twist();
			break;
		case "menu":
			menu();
			break;
		default:
			System.out.println("Make sure you've entered the right prompt <3 ");
		}

	}

	//Methods for generating the random symbols for all the game modes.
	public static char easyGen()
	{
		char[] easySymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		Random random = new Random();
		return easySymbols[random.nextInt(easySymbols.length)];
	}

	public static char medGen()
	{
		char[] medSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '@', '#', '$', '%'};
		Random random = new Random();
		return medSymbols[random.nextInt(medSymbols.length)];
	}

	public static char hardGen()
	{
		char[] hardSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '@', '#', '$', '%', '^', '&', '*', '<', '>'};
		Random random = new Random();
		return hardSymbols[random.nextInt(hardSymbols.length)];
	}

	//Methods for each game mode.
	public static void easy()
	{
		playerCredit-=creditPerGame;

		char sym1 = easyGen();
		char sym2 = easyGen();
		char sym3 = easyGen();
		
		System.out.println(ANSI_LIGHTBLUE_BG + "-----------------------------" + ANSI_RESET);
		System.out.println("\t" + sym1 + " " + sym2 + " " + sym3);
		System.out.println(ANSI_LIGHTBLUE_BG + "-----------------------------" + ANSI_RESET);
		
		if((sym1 == sym2 && sym2==sym3) && (sym1!='9' && sym1!= '0'))
		{
			playerCredit+=150;
			System.out.println(ANSI_CYAN + "Congratulations you won 150 credits! \n You shold definitely keep playing!" + ANSI_RESET);
			count+=1;
		}

		else if((sym1 == sym2 && sym2==sym3) && sym1 == '9')
		{
			playerCredit+=1000;
			System.out.println(ANSI_CYAN + "Congratulations you won 1000 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if((sym1 == sym2 && sym2==sym3) && sym1 == '0')
		{
			playerCredit+=0;
			System.out.println(ANSI_GREEN + "Sorry try again next time <3 " + ANSI_RESET);
		}
		else if (sym1 == '1' && sym2 == '2' && sym3 == '3')
		{
			playerCredit+=100;
			System.out.println(ANSI_CYAN + "Congratulations you won 100 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if (sym1 == '9' && sym2 == '8' && sym3 == '7')
		{
			playerCredit+=200;
			System.out.println(ANSI_CYAN + "Congratulations you won 200 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if ((sym1 == sym2) || (sym2 == sym3) || (sym1 == sym3))
		{
			playerCredit+=50;
			System.out.println(ANSI_CYAN + "Congratulations you won 50 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else
		{
			System.out.println(ANSI_GREEN + "Better Luck Next Time :( " + ANSI_RESET);
		}
	}

	public static void med()
	{
		playerCredit-=creditPerGame;

		char sym1 = medGen();
		char sym2 = medGen();
		char sym3 = medGen();
		
		System.out.println(ANSI_LIGHTBLUE_BG + "-----------------------------" + ANSI_RESET);
		System.out.println("\t" + sym1 + " " + sym2 + " " + sym3);
		System.out.println(ANSI_LIGHTBLUE_BG + "-----------------------------" + ANSI_RESET);
		
		if((sym1 == sym2 && sym2==sym3) && (sym1!='9' && sym1!= '0'))
		{
			playerCredit+=225;
			System.out.println(ANSI_CYAN +  "Congratulations you won 225 credits! \n You shold definitely keep playing!" + ANSI_RESET);
			count+=1;
		}

		else if((sym1 == sym2 && sym2==sym3) && sym1 == '9')
		{
			playerCredit+=1500;
			System.out.println(ANSI_CYAN + "Congratulations you won 1500 credits! \n You shold definitely keep playing!" + ANSI_RESET);
			count+=1;
		}
		else if((sym1 == sym2 && sym2==sym3) && sym1 == '0')
		{
			playerCredit+=0;
			System.out.println("Sorry try again next time <3");
		}
		else if (sym1 == '1' && sym2 == '2' && sym3 == '3')
		{
			playerCredit+=150;
			System.out.println(ANSI_CYAN + "Congratulations you won 150 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if (sym1 == '9' && sym2 == '8' && sym3 == '7')
		{
			playerCredit+=300;
			System.out.println(ANSI_CYAN + "Congratulations you won 300 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if ((sym1 == sym2) || (sym2 == sym3) || (sym1 == sym3))
		{
			playerCredit+=75;
			System.out.println(ANSI_CYAN + "Congratulations you won 75 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else
		{
			System.out.println(ANSI_GREEN +  "Better Luck Next Time :( " + ANSI_RESET);
		}
	}

	public static void hard()
	{
		playerCredit-=creditPerGame;

		char sym1 = hardGen();
		char sym2 = hardGen();
		char sym3 = hardGen();
		
		System.out.println(ANSI_LIGHTBLUE_BG + "-----------------------------" + ANSI_RESET);
		System.out.println("\t" + sym1 + " " + sym2 + " " + sym3);
		System.out.println(ANSI_LIGHTBLUE_BG + "-----------------------------" + ANSI_RESET);
		
		if((sym1 == sym2 && sym2==sym3) && (sym1!='9' && sym1!= '0'))
		{
			playerCredit+=300;
			System.out.println(ANSI_CYAN + "Congratulations you won 300 credits! \n You shold definitely keep playing!" + ANSI_RESET);
			count+=1;
		}

		else if((sym1 == sym2 && sym2==sym3) && sym1 == '9')
		{
			playerCredit+=2000;
			System.out.println(ANSI_CYAN + "Congratulations you won 2000 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if((sym1 == sym2 && sym2==sym3) && sym1 == '0')
		{
			playerCredit+=0;
			System.out.println(ANSI_GREEN + "Sorry try again next time <3" + ANSI_RESET);
		}
		else if (sym1 == '1' && sym2 == '2' && sym3 == '3')
		{
			playerCredit+=200;
			System.out.println(ANSI_CYAN + "Congratulations you won 200 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if (sym1 == '9' && sym2 == '8' && sym3 == '7')
		{
			playerCredit+=400;
			System.out.println(ANSI_CYAN + "Congratulations you won 400 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else if ((sym1 == sym2) || (sym2 == sym3) || (sym1 == sym3))
		{
			playerCredit+=100;
			System.out.println(ANSI_CYAN + "Congratulations you won 100 credits! \n You shold definitely keep playing! " + ANSI_RESET);
			count+=1;
		}
		else
		{
			System.out.println(ANSI_GREEN + "Better Luck Next Time :( " + ANSI_RESET);
		}
	}

	public static void twist() //Method for the twist mode of the game.
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select Difficulty Level (easy, medium, hard)");
		String gameOption = input.nextLine();
		int twistCount = count; //To keep track if they are winning or not.
		switch (gameOption.toLowerCase())
		{
		case "easy":
			easy();
			if (count > twistCount) 
			{
				playerCredit*=2;
				System.out.println(ANSI_CYAN + "Just kidding, You've won the double :p " + ANSI_RESET);
			}
			else
			{
				playerCredit-=50;
				System.out.println(ANSI_GREEN + "Its alright, you should try again <3" + ANSI_RESET);
			}
			break;
		case "medium":
			med();
			if (count > twistCount)
			{
				playerCredit*=2;
				System.out.println(ANSI_CYAN + "Just kidding, You've won the double :p " + ANSI_RESET);
			}
			else
			{
				playerCredit-=50;
				System.out.println(ANSI_GREEN + "Its alright, you should try again <3" + ANSI_RESET);
			}
			break;
		case "hard":
			hard();
			if (count > twistCount)
			{
				playerCredit*=2;
				System.out.println("Just kidding, You've won the double :p ");
			}
			else
			{
				playerCredit-=50;
				System.out.println("Its alright, you should try again <3");
			}
			break;	
		case "menu":
			menu();
			break;
		}
		
	}
}
