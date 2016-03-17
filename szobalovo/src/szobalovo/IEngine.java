package szobalovo;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEngine {
	
	/**
	 * Functions for main menu
	 */
	HashMap<String, String> getSettings();
	void saveSettings();
	
	/**
	 * Functions for start a new game
	 */
	void initNewGame();
	ArrayList<String> getCloudWords();
	
	/**
	 * Functions for controlling the game
	 */
	Character getNewLetter();
	void insertCharacter(Character ch, int position, int wordIndex);
	
	
	
}
