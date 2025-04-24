import java.io.Serializable;
/**
 * Represents a player in the NFL Management System.
 * Implements Serializable to allow object serialization.
 * @author Nibir Nandi Dibbo
 * @version 1.0
 */
public class Player implements Serializable


	{
	/**
     * The default serialVersionUID for serialization.
     */ 
	private static final long serialVersionUID = 1L;
	
	/**
     * The ID of the player.
     */
	public String playerid; 
	/**
     * The name of the player.
     */
	public String name ;
	/**
     * The age of the player.
     */
	private int age;
	/**
     * The name of the team the player belongs to.
     */
	public String teamName;
	/**
     * The position of the player.
     */
	public String position;
	
	/**
     * Constructs a new Player object.
     * @param playerid The ID of the player
     * @param name The name of the player
     * @param age The age of the player
     * @param teamName The name of the team the player belongs to
     * @param position The position of the player
     */
	public Player (String playerid,String name,int age,String teamName,String position) 
	{	
		this.playerid=playerid;
		this.name = name;
		this.age = age;
		this.teamName = teamName;
		this.position= position;
	}

	
	/**
     * Gets the player's ID.
     * @return The player's ID
     */
	public String getPlayerid() 
	{
		return this.playerid;
	}
	/**
     * Gets the player's name.
     * @return The player's name
     */
	public String getName() 
	{
		return this.name;
	}

    /**
     * Gets the player's age.
     * @return The player's age
     */
	public int getAge() 
	{
		return this.age;
	}
	/**
     * Gets the player's team name.
     * @return The player's team name
     */
	public String getTeamName() 
	{
		return this.teamName;
	}
	/**
     * Gets the player's position.
     * @return The player's position
     */
	public String getPosition() 
	{
		return this.position;
	}

	 /**
     * Returns a formatted string representation of the player.
     * @return A formatted string containing player details
     */
	@Override

	public String toString() {
		return String.format("%-4s %-15s %3d %-10s %-15s", playerid, name, age, teamName, position);
	}
	
	 
	
	}
