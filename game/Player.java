package game;

import java.io.Serializable;
import java.util.UUID;

import network.iNetworkHandler;
import db.DataBase;
import iGraphs.iGraphs;
import iGraphs.iGUI;
//simport iGraphs.iConsole;

public abstract class Player 
implements Serializable
{//##########################################\\
	private static final long serialVersionUID = 1L;

	protected transient iGraphs iGH; //handler
	protected transient boolean regDB; //para autosave
	protected transient iNetworkHandler iNH;
	protected transient static DataBase DB; 

	protected boolean won  = false;
	protected boolean lost = false;
	protected boolean gameCreator = false;  
	protected boolean itsTurn = false;

	protected String ID;
	protected String name;
	protected Match  cM; 
	
	public Player ( )
		{
		setID();
		this.iNH   = new iNetworkHandler(this);
		this.iGH   = new iGUI(this);
		}
	public Player ( String name ) 
		{
		this();
		this.name  = name;
		//esto lo hace TP
		//check TP.checkID
		//iGH.showIntro();
		//this.iGH = new iGraphsConsole(this);
		//Player.DB = getDB();
		}
	
	public abstract void play( Runnable game );
	public void searchForMatch ( ) 
		{
		//en join
		getiNH().startClient(); 
		}
	public boolean joinMatch ( Match m )
		{
		boolean joined = false;
		if(m.getS("Cantidad de Jugadores") > m.getPlayerList().size() ) 
			{
			this.gameCreator = false;
			this.setcM(m); 
			cM.addPlayer(this);	
			joined = true;
			}
		return joined;
		}
	public void invite ( Player player ) 
		{ 
		player.joinMatch(this.getcM()); 
		}
	public abstract void createMatch();
	//public abstract joinMatch();
	//public abstract searchForMatch();
	//public abstract invite();
	
	// G & S ##########################\\	
	public boolean isItsTurn() {
		return itsTurn;
	}
	public boolean isGameCreator ( ) 	
	{
	return gameCreator;
	}
	public boolean isRegDB ( )  
		{
		return regDB;
		}
	public boolean hasWon ( ) {
		//check won y lost es hasWon y HasLost.
		//si para ver si le toca usa isTurn
		return won;
	}
	public boolean hasLost ( ) {
		return lost;
	}
	public Match getcM ( ) 
	{
	return cM;
	}
	public iGraphs getiGH ( ) 
		{
		return iGH;
		}
	public iNetworkHandler getiNH ( ) 
		{
		return iNH;
		}
	public DataBase getDB ( ) 
	{
	if (Player.DB == null)
		Player.DB = new DataBase();
	return Player.DB;
	}
	public String getID ( ) 
		{
		return ID;
		}
	public String getName ( ) 
		{
		return name;
		}

	public void setcM ( Match cM ) 
		{
		this.cM = cM;
		}
	public void setiGH ( iGraphs iGH ) 
		{
		this.iGH = iGH;
		}
	public void setiNH ( iNetworkHandler iNH ) {
		this.iNH = iNH;
	}
	public void setWon(boolean won) {
		if (won)
			cM.setWinner(this);
		this.won = won;
	}
	public void setLost(boolean lost) {
		this.lost = lost;
	}
	public void setGameCreator ( boolean value ) 
		{
		this.gameCreator = value;
		}
	public void setItsTurn ( boolean itsTurn ) {
		this.itsTurn = itsTurn;
	}
	public void setRegDB ( boolean regDB )  
		{
		this.regDB = regDB;
		}
	public void setName ( String name ) 
		{
		this.name = name;
		}
	void setID ( ) 
		{
		ID = UUID.randomUUID().toString();
		}	

	@Override
	public String toString (  ) 
		{
		return 
		"\n###"
		+ "\nPlayer [ID=" + ID + 
		", \nname=" + name + 
		", \ncM=" + cM + 
		", \ngC=" + gameCreator + 
		", \nregDB=" + regDB +
		", \niGH=" + iGH +"]";
		}
}