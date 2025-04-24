
/*
* Student Name: Nibir Nandi Dibbo
* Lab Professor: Abul Qasim
* Due Date: 06 April 2025
* Modified: 06 April 2025
* Description: Assignment -2
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * The main class for the NFL Operations Management System.
 * Provides a menu-driven interface for managing teams, players, and games.
 * @author Nibir Nandi Dibbo
 * @version 1.0
 * @since 1.8
 */
public class NFLManagementSystem {
	

	/**
	 * Instance of TeamManager class
	 */
	public static TeamManager teamManager ;
	/**
	 * Instance of PlayerManager class
	 */
	public static PlayerManager playerManager;
	/**
	 * Instance of GameManager class
	 */
	public static GameManager gameManager;
	
    /**
     * The main entry point for the NFL Management System.
     * @param args Command-line arguments (unused)
     * @throws Exception If any critical error occurs during execution
     */
	public static void main(String[] args) throws Exception 
	{	
		// instantiation of the objects
		List<Game>games = new ArrayList<Game>();
		gameManager = new GameManager(games);
		List<Player>players = new ArrayList<Player>();
		playerManager = new PlayerManager(players);
		List<Team> teams = new ArrayList<Team>();
		teamManager = new TeamManager (teams);
		
		// loading of the .csv files to the respective methods
		// handling exceptions if loading fails 
		// loading games.csv
		try 
		{	
		gameManager.loadGamesFromFile("C:\\LEVEL 2\\eclipse\\Nibir_Dibbo_Assign022\\src\\games.csv");
		}
		catch(IOException e ) 
		{
			System.err.println("Error openning file games.csv");
		}
		//loading teams.csv
		try {
			teamManager.loadTeamsFromFile("C:\\LEVEL 2\\eclipse\\Nibir_Dibbo_Assign022\\src\\teams.csv");
			}
		catch(IOException e ) {
				System.err.println("Error openning file teams.csv");
			}
		//loading players.csv
	     try {
	    	 playerManager.loadPlayersFromFile("C:\\LEVEL 2\\eclipse\\Nibir_Dibbo_Assign022\\src\\players.csv", teamManager);
	     }
	     catch (IOException e) 
	     {
	    	 System.err.println("Error opening file players.csv");
	     }
	     
		//Showing Menu inside main method and repeating showing it until user chooses option 7
	    while(true) {
	    	// handling exception of showMenu method if user inputs wrong data type
		try 
		{ 
			
		showMenu();
		break;
		}
		catch (Exception e) {
			// exception statement 
			System.err.println("***Invalid choice. Try again***");
		}
	    }
	    // printing use of Serializable interface and default serialversionUID at the end of the code
		System.out.println("------------Use of the serializable interface and serialVersionUID  number----------");
		System.out.println("The objects from classes that implement serializable interface can be converted to byte stream and reconstructed, it is way to identify which objects can be saved and restored");
		System.out.println("If NFL Management system's objects are updated adding/removing fields without updating previous uid, this will force sync to previous version of the classes of the objects");
		System.out.println("Serializable allows object state to be saved to a byte stream. serialVersionUID ensures class version compatibility during deserialization.");
	}
	
	
	/**
	 * Displays the main menu and handles user input
	 */
	public static void showMenu() {
		// until the flag is false , show menu will keep popping up
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		
		while (flag!=false) {
			// printing options for different execution
			System.out.println();
			System.out.println("NFL Operations Management System");
			System.out.println("1. Display Teams");
			System.out.println("2. Display Players");
			System.out.println("3. Display Scheduled Games");
			System.out.println("4. Add Team");
			System.out.println("5. Add Player to Team");
			System.out.println("6. Find Team");
			System.out.println("7. Exit");
			System.out.println("Enter choice: ");
			
			// declaring variable to store user choice 
			scanner = new Scanner (System.in);
			int choice =scanner.nextInt();
			scanner.nextLine();
			
			switch(choice){
			case 1:
				// option 1 :
				// displaying updated teams 
				teamManager.displayTeam();
				break;
			case 2:
				// option 2 :
				// displaying updated players 
				playerManager.displayPlayers();
				break;
			case 3:
				// option 3 :
				// displaying updated games 
				gameManager.displayGames();
				break;
			case 4:
				// option 4 :
				// prompting user input for new  team name
				System.out.println("Enter team name: ");
				String teamName=scanner.nextLine();
				
				System.out.println("Enter city: ");
				String city=scanner.nextLine();
				
				System.out.println("Enter coach name: ");
				String coachName=scanner.nextLine();
				
				System.out.println("Enter coach years of experience: ");
				String experience=scanner.nextLine();
				// adding the new team calling add team method for Team Manager class 
				teamManager.addTeam(teamName,city,coachName,experience);
				break;
				
			case 5:
				// option 5 :
				// prompting user input for new player name
				System.out.println("Enter player ID: ");
				String playerID=scanner.nextLine();
				
				System.out.println("Enter player name: ");
				String name=scanner.nextLine();
				
				System.out.println("Enter player age: ");
				int age =scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter team name: ");
				String teamNameOfPlayer=scanner.nextLine();
				
				System.out.println("Enter player position: ");
				String position=scanner.nextLine();
				
				// adding new player to player playerManager object's array list
				Player player;
				player = new Player(playerID,name,age,teamNameOfPlayer,position);
				playerManager.addPlayer(player);
				
				//finding the team and adding player to it's array list of players 
				Team TargetTeam = teamManager.findTeam(teamNameOfPlayer);
				if (TargetTeam!=null) {
					TargetTeam.addPlayer(player);
					System.out.println("Player added successfully!");
					System.out.println();
					
				}
				else {
					System.out.println("Team not found. Player not added.");
				}
				break;
				
			case 6:
				// option 6 :
				//prompting user input for team name and finding it 
				System.out.println("Enter team name to search: ");
				String searchTeamName=scanner.nextLine();
				if(teamManager.findTeam(searchTeamName)!=null){;
				System.out.println("Team found:  "+(teamManager.findTeam(searchTeamName)).toString());
				}
				else {
					System.out.println("Team not found.");
				}
				break;
				
			case 7:
				// option 7 :
				// exiting the menu turning flag to flase 
				flag=false;
				System.out.println("*****************************************************");
				System.out.printf("  ...Exiting the program by %s...\n","Nibir Nandi Dibbo");
				System.out.println();
				System.out.println("*****************************************************");
				break;
			default:
				System.out.println("***Invalid choice. Try again***");
				break;
			
		}
			
		
		}
		
	}
	
	
	
	
	
	
	
	
	
}
