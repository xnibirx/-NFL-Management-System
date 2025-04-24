import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Manages a collection of Team objects and provides operations for loading, displaying, and finding teams.
 * @author Nibir Nandi Dibbo
 * @version 1.0
 * @since 1.8
 */
public class TeamManager {
	
    /**
     * The list of teams being managed.
     */
	List<Team> teams = new ArrayList<Team>();
    /**
     * Constructs a new TeamManager with the specified list of teams.
     * @param teams The initial list of teams
     */
		public TeamManager(List<Team>teams) 
	{
		this.teams=teams;
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

}
    /**
     * Loads teams from a CSV file.
     * @param filename The path to the CSV file containing team data
     * @throws IOException If there is an error reading the file
     */
	public void loadTeamsFromFile(String filename) throws IOException 
	{
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
		{	String line ;
			
			while ((line = bufferedReader.readLine())!=null) // until reader reaches last line ?
			{
			// after the line's word are extracted 
			String[] fields = parseline(line); 
			String teamName = fields[0];
			String city = fields[1];
			String coachName = fields[2];
			String yearsOfExperience = fields[3];
			Coach coach = new Coach ("",coachName,teamName,Integer.parseInt((yearsOfExperience)));
			Team team = new Team (teamName,city,coach);
			teams.add(team);// .add of the array list is used 
			}
		}
		catch(IOException e) 
			{
			System.out.println("Error reading File: "+filename); //***Invalid choice. Try again***
			}
			
		}
	
    /**
     * Displays all teams in a formatted table.
     */
	public void displayTeam () 
	{
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Team        City             Coach                         Players ");
		System.out.println("-------------------------------------------------------------------");
		for (Team team:teams) {
			System.out.println(team.toString());
		}
	}
	
    /**
     * Adds a new team to the manager's list.
     * @param teamName The name of the team
     * @param city The city where the team is based
     * @param coachName The name of the coach
     * @param yearsOfExperience The years of experience of the coach
     */
	public void addTeam(String teamName, String city, String coachName, String yearsOfExperience) {
		
		Coach coach = new Coach ("",coachName,teamName,Integer.parseInt((yearsOfExperience)));
		Team team = new Team (teamName,city,coach);
		teams.add(team);
		System.out.print("Team added successfully!");
	}
	
	
    /**
     * Finds a team by name.
     * @param teamName The name of the team to find
     * @return The Team object if found, null otherwise
     */
	public Team findTeam (String teamName)
	{	
		for(Team team : teams) {
			// teamName of the index's object is compared with parameter teamName
			if (team.teamName.equalsIgnoreCase(teamName)) {
				return team;
			}
		}
		return null;
	}
	
	
	
	
	
	
}
