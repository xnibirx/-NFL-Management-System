import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents a team in the NFL Management System.
 * Contains information about the team, its coach, and players.
 * Implements Serializable to allow object serialization
 * @author Nibir Nandi Dibbo
 * @version 1.0
 * @since 1.8
 */

public class Team implements Serializable{
	/**
     * The serialVersionUID for serialization.
     */
	private static final long serialVersionUID = 1L;
	/**
     * The name of the team.
     */
	public String teamName;
	/**
     * The city where the team is based.
     */
	private String city;
	/**
     * The coach of the team.
     */
	private Coach coach ;
	
	/**
     * The list of players on the team.
     */
	 List<Player>players  = new ArrayList<Player>(); 
	
	  /**
	  * Constructs a new Team object.
	  * @param teamName The name of the team
	  * @param city The city where the team is based
	  * @param coach The coach of the team
	  */
	public Team (String teamName, String city, Coach coach) {
		this.teamName=teamName;
		this.city=city;
		this.coach=coach;
		
	}
	
	/**
     * Adds a player to the team.
     * @param player The player to add
     * @return The updated list of players
     */
	public List<Player> addPlayer(Player player) 
	{
	   players.add(player); // Directly add to the team's player list
		 return players ;
	}
	
    /**
     * Gets the list of players on the team.
     * @return The list of players
     */
	public List<Player> getPlayers () {
		return this.players;
	}
	
    /**
     * Returns a formatted string representation of the team.
     * @return A formatted string containing team details
     */
	@Override
	public String toString() {
		
		return String.format("%-10s %-15s %-30s %d", teamName, city, coach.toString(), players.size());	}

}
