package szobalovo;

/**
 * 
 * @author aqaefr
 *
 * Abbreviations: nOf*** = number of ***
 */
public class GameSettings {
	public enum Languages {
	    HUNGARIAN,
	    ENGLISH
	}

	/**************************************************************************
	 * BASIC SETTINGS: 
	 **************************************************************************/
	
	/**
	 * numberOfPlayers
	 *   1: Single player
	 *   2: Multiplayer
	 * Note that in multiplayer mode the enemy can be AI or human.
	 */
	public int nOfPlayers;
	
	/**
	 * numberOfHumanPlayers<numberOfPlayers
	 */
	public int nOfHumanPlayers;

	
	/**
	 * The name of the player
	 */
	public String playerName;

	/**
	 * The name of the enemy player
	 */
	public String enemyName;

	/**
	 * The level of the intelligence of the enemy.
	 */
	public int EnemyIntelligence;

	/**
	 * Generated words will use this dictionary.
	 */
	public Languages language;
	
	/*
	 *Time of the play. Min 1 max 5
	 */
	public int playTime;
	/*
	 * number of the hitted words
	 */
	public int playerHittedScore;
	/*
	 * number of the badly hitted words
	 */
	public int playerBadScore;
	/*
	 * number of the missed words
	 */
	public int playerMissedScore;
	
	// scores of the last game:
	/*
	 * number of the hitted words
	 */
	public int playerLastHittedScore;
	/*
	 * number of the badly hitted words
	 */
	public int playerLastBadScore;
	/*
	 * number of the missed words
	 */
	public int playerLastMissedScore;
	/**************************************************************************
	 * GENERATOR SETTINGS 
	 **************************************************************************/
	
	/**
	 * The number of characters in words in the word-cloud must be minWordLength
	 * at least and maxWordLength at most.
	 */
	public int minWordLength;
	public int maxWordLength;
	
	/**
	 * The engine will generate such number of word at the beginning of the game.
	 */
	public int nOfgeneratedWords;
	
	/**
	 * The player sees at this number of characters in the bottom-right on the
	 * screen. These characters can be shot next. 
	 */
	public int nOfPregeneratedLetters;
	

	/**************************************************************************
	 * GAME MODE SETTINGS
	 **************************************************************************/
	
	/**
	 * If isBordersWalls is true the letter will bounce off the wall.
	 * It it is false the letter will disappear. 
	 */
	public boolean isBordersWalls;
	
	/**
	 * If showCursor is true the game will show the target position of the letter. 
	 */
	public boolean showCursor;
	
	
	/**************************************************************************
	 * KEYS:
	 * It is useful for multiplayer on a single machine. 
	 **************************************************************************/

	/**
	 * Keys to control the cannon. 
	 */
	public int rotateCannonRightKey;
	public int rotateCannonLeftKey;
	public int shootLetterKey;
	public int discardLetterKey;
	public int easterEggKey;
	

	/**************************************************************************
	 * NETWORK SETTINGS: 
	 **************************************************************************/

	/**
	 * Variables for TCP/IP socket
	 */
	public int serverAddress;
	public int portNumber;
	
	

	public boolean verify() {
		assert maxWordLength<10: "maxWordLength";
		assert maxWordLength>2: "maxWordLength";

		assert minWordLength>1: "minWordLength";
		assert minWordLength<5: "minWordLength";
		assert minWordLength<maxWordLength: "minWordLength";
		
		assert nOfgeneratedWords>4 : "nOfgeneratedWords";
		assert nOfgeneratedWords<50 : "nOfgeneratedWords";
		
		assert nOfHumanPlayers<3 : "nOfHumanPlayers";
		assert nOfHumanPlayers>0 : "nOfHumanPlayers";
		
		assert nOfPlayers>0 : "nOfPlayers";
		assert nOfPlayers<3 : "nOfPlayers";
		assert nOfPlayers>nOfHumanPlayers : "nOfPlayers";
		
		assert nOfPregeneratedLetters>0 : "nOfPregeneratedLetters";
		assert nOfPregeneratedLetters<10 : "nOfPregeneratedLetters";
		
		return true;
	}
	
	
	void setDefaults(){
		nOfPlayers = 1;
		nOfHumanPlayers = 1;

		playerName = "Player1";

		enemyName = "FearlessEnemy";

		EnemyIntelligence = 50;

		language = Languages.HUNGARIAN;
		
		minWordLength = 2;
		maxWordLength = 6;
		
		nOfgeneratedWords = 20;
		
		nOfPregeneratedLetters = 5;
		          
		isBordersWalls = true;
		
		showCursor = true;
		playTime = 5;
		playerHittedScore = 0;
		playerBadScore = 0;
		playerMissedScore = 0;
		playerLastHittedScore = 0;
		playerLastBadScore = 0;
		playerLastMissedScore = 0;
		
		// TODO
		/*rotateCannonRightKey;
		rotateCannonLeftKey;
		shootLetterKey;
		discardLetterKey;
		easterEggKey;
		
		
		serverAddress = ;
		portNumber;
		*/
		
	}

	
	
}


