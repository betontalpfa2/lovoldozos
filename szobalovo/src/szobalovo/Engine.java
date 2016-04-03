package szobalovo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class Engine implements IEngine {
	GameSettings gameSettings;
	List<String> wordCloud;
	List<String> dictionaryWords;
	String currentAlphabet;	

	public Engine() {
		gameSettings = new GameSettings();
		gameSettings.setDefaults();
		generateAlphabet();
	}
	
	/**
	 * Returns the current settings of the game.
	 * The GameSettings class contains all settings.
	 */
	@Override
	public GameSettings getSettings() {
		return gameSettings;
	}

	/**
	 * saveSettings() verify the consistency of the gameSettings parameter, then
	 * copy it to its own field.
	 */
	@Override
	public void saveSettings(GameSettings gameSettings) {
		gameSettings.verify();
		this.gameSettings = gameSettings;
		generateAlphabet();
	}



	@Override
	public void initNewGame() throws IOException {
		readDictionaryWords();
		generateWordCloud();
		
	}


	@Override
	public List<String> getCloudWords() {
		return wordCloud;
	}

	/**
	 * Give a random character from the alphabet.
	 */
	@Override
	public Character getNewLetter() {
		Character c;
		int index = RandRange.get(currentAlphabet.length());
		c = currentAlphabet.charAt(index);
		return c;
	}

	@Override
	public void insertCharacter(Character ch, int position, int wordIndex) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void generateWordCloud() {
		wordCloud = generateRandomWords();
		unpinLetters(wordCloud);
		
	}

	/**
	 * unpinLetters gets a parameter with array of strings. It goes threw the 
	 * strings and it replaces a letter with an underscore '_' in each of them.
	 * @param words
	 */
	private static void unpinLetters(List<String> words) {
		ListIterator<String> it = words.listIterator();
		while (it.hasNext()){
			StringBuilder str = new StringBuilder(it.next());
			int unpinIndex = RandRange.get(0, str.length()-1);
			str.setCharAt(unpinIndex, '_');
			it.set(str.toString());
		}
	}

	/**
	 * generateRandomWords(): generates random words for word cloud based on
	 * gamesettings.
	 * @return
	 */
	private List<String> generateRandomWords() {
		List<String> words = new ArrayList<String>();
		int nOfgeneratedWords = gameSettings.nOfgeneratedWords;
		int minWordLength = gameSettings.minWordLength;
		int maxWordLength = gameSettings.maxWordLength;
		int lengthOfDictionary = dictionaryWords.size();
		String str;
		
		for(int i = 0 ; i< nOfgeneratedWords; i++){
			do{
				int index = RandRange.get(0, lengthOfDictionary-1);
				str = dictionaryWords.get(index);
			}
			while(str.length()<minWordLength | str.length()>maxWordLength);
			words.add(str);
		}
		return words;
	}
	
	/**
	 * A simple class to generate random numbers between a range.
	 * @author ebenera
	 *
	 */
	static class RandRange {
		private static Random ran = new Random(System.currentTimeMillis());
	
		static int get(int min, int max) {
			return ran.nextInt(max+1-min) + min;
		}	
		
		static int get(int maxExclude) {
			return ran.nextInt(maxExclude);
		}	
	}
	
	/**
	 * readWords(): Choose the proper dictionary file based on the gameSettings
	 * Enum. and it reads all words into the dictionaryWords.
	 * @throws IOException
	 */
	private void readDictionaryWords() throws IOException{
		dictionaryWords = new ArrayList<String>();
		String fileName = gameSettings.language.toString().toLowerCase() + ".txt";
		String path = "resources/dictionaries/" + fileName;
		InputStream is = Engine.class.getResourceAsStream(path);
		assert is != null: "Cannot load resource file";
		if (is == null){
			System.out.println("is is null");
		}
		try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			String line;
			while ((line = reader.readLine()) != null) {
				dictionaryWords.add(line);
			}            
        } finally {
            try { is.close(); } catch (Throwable ignore) {}
        }
	}

	private void generateAlphabet() {
		String hunExtension = "\u00E1\u00E9\u00ED\u00F3\u00F6\u0151\u00FA\u00FC\u0171";
		currentAlphabet ="abcdefghijklmnopqrstuvwxyz";
		
		switch (gameSettings.language) {
		case HUNGARIAN:
			currentAlphabet = currentAlphabet + hunExtension;
			break;

		default:
			throw new IllegalArgumentException("Unrecognised language: " + gameSettings.language.toString());
		}
		
	}
	
	public Character[] toCharacterArray( String s ) {

		   if ( s == null ) {
		     return null;
		   }

		   int len = s.length();
		   Character[] array = new Character[len];
		   for (int i = 0; i < len ; i++) {
		      array[i] = new Character(s.charAt(i));
		   }

		   return array;
		}

/*	public static void main(String[] args){
		Engine engine = new Engine();
		try {
			engine.initNewGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Get new letter: " + engine.getNewLetter());
		System.out.println("Get word cloud: " + engine.getCloudWords());
		System.out.println("Get settings: " + engine.getSettings().toString());
		
	}*/
	
}
