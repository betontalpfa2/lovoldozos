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
	List<String> insertCharacter(Character ch, int position, int wordIndex);
	
}
