package szobalovo;
/*
 * This class represents an interface  
 * The PlayerName variable is contains the name of the gamer
 */
 
public class PlayerSettings {

	public String playerName = null;
	//constructor
	public PlayerSettings(String PlayerName)
	{
		this.playerName = PlayerName;
	}
	public void setPlayerName(String PlayerName)
	{
		this.playerName = PlayerName;
	}
	public String getPlayerName()
	{
		// if the playerName is not setted yet
		if(playerName != null)
		{
		return this.playerName;
		}
		else
		{
			return null;
		}
	}

}
