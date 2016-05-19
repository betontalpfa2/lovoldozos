package szobalovo;


public class MainClass {

	//  class which contains the main functions.
	//It is create the required instances
	public static void main(String[] args) {
		// create an instance from the engine class
		Engine engine = new Engine();
		
		// create the local engine(client)
		LocalEngine localEngine = new LocalEngine(engine); 
		
		// show the Menu
		localEngine.startMenu();
		
	}

}
