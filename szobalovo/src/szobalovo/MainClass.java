package szobalovo;

import java.io.IOException;

public class MainClass {

	//  class which contains the main functions.
	//It is create the required instances
	public static void main(String[] args) {

		Engine engine = new Engine();
		try {
			engine.initNewGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MainMenuGUI(engine);
	}

}
