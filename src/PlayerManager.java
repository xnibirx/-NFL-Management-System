import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Manages a collection of Player objects and provides operations for loading and displaying players.
 *  @author Nibir Nandi Dibbo
 *  @version 1.0
 *  @since 1.8
 */
public class PlayerManager 
{	 /**
     * The list of players being managed.
     */
	List<Player>players = new ArrayList<Player>();
	
	/**
     * Constructs a new PlayerManager with the specified list of players.
     * @param players The initial list of players
     */
	public PlayerManager(List<Player> players) {
		this.players = players;
	}

	/**
     * Parses a line from a CSV file into individual fields.
     * @param line The line to parse
     * @return An array of strings containing the parsed fields
     */
	public static String[] parseline(String line) 
	{
		
		String[] fields=null;
		ArrayList<String> list = new ArrayList<String>();
		String field = "";
		boolean inQuotes = false;
		char ch = 0;
		
		
		for (int i = 0 ; i < line.length();i++) {
		ch= line.charAt(i);
		if (ch=='"') {
			inQuotes=!inQuotes;
		}
		else if (ch==',' && !inQuotes) {
			list.add(field.strip());
			field="";
		}
		else {
			field=field+ch;
		}
		}
		list.add(field.strip());
		fields = new String[list.size()];
		fields=list.toArray(new String[list.size()]);
		return fields;
		// it is fine 
	}
	
	/**
     * Loads players from a CSV file and associates them with teams.
     * @param filename The path to the CSV file containing player data
     * @param teamManager The TeamManager instance to associate players with teams
     * @throws IOException If there is an error reading the file
     */
	public void loadPlayersFromFile(String filename, TeamManager teamManager) throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			
			while ((line = br.readLine()) != null) 
			{	
				String[] fields=parseline(line);
				String playerId = fields[0];
				String name = fields[1];
				String age = fields [2];
				String team = fields[3];
				String position = fields[4];
				Player player = new Player (playerId,name,Integer.parseInt(age),team,position);
				players.add(player);
				Team targetTeam = teamManager.findTeam(team);
	            if (targetTeam != null) {
	                targetTeam.addPlayer(player);
	            } else {
	                System.out.println("Team not found: " + team);
	            }
			}
			
		}
		catch(IOException e) 
		{
		System.out.println("Error reading File: "+filename); //***Invalid choice. Try again***
		}
		
		
		
		
	}
	
	
	/**
     * Displays all players in a formatted table.
     */
	public void displayPlayers() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("ID    Player            Age   Team        Position ");
		for (Player player : players) {
			System.out.println(player.toString());
		}
		System.out.println("-------------------------------------------------------------------");
	}
	
	/**
     * Adds a new player to the manager's list.
     * @param Player The player to add
     */
	public void addPlayer(Player Player) {
		players.add(Player);
		
	}
	
}