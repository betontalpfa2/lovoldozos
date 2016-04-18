package szobalovo;

public interface IGUI extends IServer{
	/**
	 * 
	 */
	void init();
	
//	void fossilizeWord(int wordIndex);
	void setScore(int score);

	void fossilizeWord(int wordIndex);

}
