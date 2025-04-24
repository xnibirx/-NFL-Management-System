import java.io.Serializable;
/**
 * Represents a game between two teams in the NFL Management System.
 * Implements Serializable to allow object serialization.
 *@author Nibir Nandi Dibbo
 *@version 1.0
 *@since 1.8
 */
public class Game implements Serializable {
	/**
     * The default serialVersionUID for serialization.
     */ 
	private static final long serialVersionUID = 1L;
	/**
     * The name of the first team.
     */
	private String team1;
	/**
     * The name of the second team.
     */
	private String team2;
	/**
     * The date of the game.
     */
	private String date;
	/**
     * The location of the game.
     */
	private String location;
	/**
     * The score of the game.
     */
	private String score; 
	
	/**
     * Constructs a new Game object.
     * @param team1 The name of the first team
     * @param team2 The name of the second team
     * @param date The date of the game
     * @param location The location of the game
     * @param score The score of the game
     */
	public Game (String team1, String team2 , String date, String location , String score )

	{
		this.team1=team1;
		this.team2=team2;
		this.date=date;
		this.location=location;
		this.score=score;
	}
	
	/**
     * Returns a formatted string representation of the game.
     * @return A formatted string containing game details
     */
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-12s %-15s %s",team1, team2, date, location, score);	}
}
