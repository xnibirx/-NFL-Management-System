import java.io.Serializable;
/**
 * Represents a coach in the NFL Management System.
 * Implements Serializable to allow object serialization.
 * @author Nibir Nandi Dibbo
 * @version 1.0
 * @since 1.8
 */
public class Coach  implements Serializable 
{	
	/**
     * The serialVersionUID for serialization.
     */
	private static final long serialVersionUID = 1L;
	
	/**
     * The name of the coach.
     */
	private String name;  
	/**
     * The years of experience of the coach.
     */
	private int yearsOfExperience;
	
	/**
     * Constructs a new Coach object.
     * @param coachId The ID of the coach (unused in current implementation)
     * @param name The name of the coach
     * @param teamName The name of the team the coach belongs to
     * @param yearsOfExperience The years of experience of the coach
     */
	public Coach(String coachId, String name, String teamName, int yearsOfExperience) {
	
		this.name = name;
		this.yearsOfExperience = yearsOfExperience;
		
	}
	
	/**
     * Returns a string representation of the coach.
     * @return A formatted string containing the coach's name and years of experience
     */
	@Override
	public String toString() {
		return this.name + " (" + this.yearsOfExperience + " years)";
	}
	
	
	

}
