 package szobalovo;
/*
 * this class represents the client
 * This is initialize the menus, the playerSettings and the playground
 */
public class LocalEngine {
	// string to contains the name of the player
	public String playerName = "Player";
	//create Local Interface to get and set the player Name
	// instance of the PlayerSettings Class
	public PlayerSettings PlayerSet = new PlayerSettings(playerName);
	
	// engine instance
	IClient mainClient;
	//constructor
	public LocalEngine(IClient MainClient)
	{
		this.mainClient = MainClient;
	}
	public void startMenu()
	{
		new MainMenuGUI(mainClient, PlayerSet);
	}
}
