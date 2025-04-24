import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manages a collection of Game objects and provides operations for loading and displaying games.
 * @author Nibir Nandi Dibbo
 * @version 1.0
 * @since 1.8
 */
public class GameManager {
	/**
     * The list of games being managed.
     */
	List<Game>games = new ArrayList<Game>();


	/**
     * Constructs a new GameManager with the specified list of games.
     * @param games The initial list of games
     */ 
	public GameManager(List<Game> games) {
	this.games = games;
	}
	
	/**
     * Parses a line from a CSV file into individual fields.
     * @param line The line to parse
     * @return An array of strings containing the parsed fields
     */
	public String[] parseLine(String line) {
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
     * Loads games from a CSV file.
     * @param fileName The path to the CSV file containing game data
     * @throws IOException If there is an error reading the file
     */
	public void loadGamesFromFile(String fileName) throws  IOException {
		try (BufferedReader br = new BufferedReader (new FileReader (fileName))){
			String line ;
			while ((line = br.readLine()) != null) {
				String fields[] = parseLine(line);
				String team1 = fields[0];
				String team2 = fields[1];
				String date = fields[2];
				String location = fields[3];
				String score = fields[4];
				Game game = new Game (team1,team2, date, location, score);
				games.add(game);
			}
		}
		catch (IOException e) {
			System.out.println("Error reading File: "+fileName);
		}
		
		
	}
	
	 /**
     * Displays all games using an iterator.
     */
	public void displayGames() {
		Iterator <Game> it = games.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
	
}

}
