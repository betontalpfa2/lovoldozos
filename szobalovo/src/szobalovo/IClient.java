package szobalovo;

import java.io.IOException;
import java.util.List;

public interface IClient {
	
	/**
	 * Tries to connect to given server. It throws exception on error.
	 */
	void connect(String hostname, int port);
	
	/**
	 * Functions for start a new game
	 * @throws IOException 
	 */
	void initNewGame() throws IOException;
	
	/**
	 * 
	 * @return
	 */
	List<String> getCloudWords();
	
	/**
	 * Functions for controlling the game
	 */
	
	/**
	 * 
	 * @return
	 */
	Character getNewLetter();
	
	/**
	 * 
	 * @param ch
	 * @param position
	 * @param wordIndex
	 */
	void insertCharacter(Character ch, int position, int wordIndex);

	GameSettings getSettings();
	// check the word, if it is appropriate the function returns with true otherwise with false
	boolean checkword(String word);
	//fuction to get the time of play
	int getTimeofPlay();
	
	//scores
	 int getHittedScores();
	
	 int getBadScores();
	
	 int getMissedScores();
	
	 void addHittedScores(int newhit);
	
	 void addBadScores(int newbad);
	
	 void addMissedScores( int newmiss);
	
	//fucntion to get and set the scores related to the last game
	 int getLastHittedScores();
	
	 int getLastBadScores();
	
	 int getLastMissedScores();
	
	 void addLastHittedScores(int newhit);
	
	 void addLastBadScores(int newbad);

	 void addLastMissedScores( int newmiss);

}
