package iGraphs;
import java.util.ArrayList;

public interface iGraphs
{
	public void render ( );
	public void showIntro ( );
	public void loadGame ( );
	public void saveGame ( ArrayList<String> settingsList );
	public void joinGame ( );
	public void waitLobby ( );
	public void gameSettings( );
	public void showOptions ( );
	public void playGame ( );
	public void showDialog ( String infoString );
	public void showTurnPlayed();
}
