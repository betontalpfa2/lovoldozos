package szobalovo;

public interface IServer {
	/**
	 * Tries to create a new server. It throws exception on error.
	 */
	void createServer(String hostname, int port);
	
	/**
	 * 
	 * @param ch
	 * @param position
	 * @param wordIndex
	 */
	void insertLetter(Character ch, int position, int wordIndex);
	
	/**
	 * 
	 * @param wordIndex
	 */
	void destroyWord(int wordIndex);
	
	/**
	 * 
	 */
	void freezeWord(int wordIndex);
	
	
	
}
