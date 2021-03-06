package szobalovo;

import java.io.IOException;
import java.util.List;

public interface IEngine extends IClient{
	
	/**
	 * Functions for main menu
	 */
	/*GameSettings getSettings();
	void saveSettings(GameSettings gameSettings);*/
	
	/**
	 * Functions for start a new game
	 * @throws IOException 
	 */
	void initNewGame() throws IOException;
	List<String> getCloudWords();
	void saveSettings(GameSettings gameSettings);
	
	/**
	 * Functions for controlling the game
	 */
//	Character getNewLetter();
//	void insertCharacter(Character ch, int position, int wordIndex);
	
	
	
}
