package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

public abstract class Match 
implements Serializable, Runnable 
{//###########################// 
protected String ID;
protected Player winner = null;
protected final CircularList <Player> playerList = 
	new CircularList<Player> ( );
public 	  class CircularList <E> extends ArrayList<E> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public E get(int index) {
        return super.get(index % size());
    }
}
protected final LinkedHashMap <String,Integer> settings = 
		new LinkedHashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		//# of players to play match
		//tiene put("Cantidad de Jugadores",0);
		{
		put("Cantidad de Jugadores",0);
		// # of players to play match
		}};

public abstract void run ( ) ;
public abstract void tick ( ) ;
public abstract void repaint ( ) ;
public abstract boolean checkSettings(HashMap<String,Integer> set);

protected Match ( ) 
	{
	setID ( );
	}
protected Match ( Player p )
	{
	this();
	p.joinMatch(this);
	p.setGameCreator(true);
	}
//playerList  & settings
public ArrayList<Player> getPlayerList ( ) 
	{
	return playerList;
	}
public void addPlayer ( Player player ) 
	{
	if (settings.get("Cantidad de Jugadores")
	  > this.playerList.size()) 
		
		this.playerList.add(player);
	}
public void removePlayer ( Player player ) 
	{
	if (this.playerList.size() < settings.get("Max Jugadores")) 
		this.playerList.add(player);
	}
public void putSetting ( String ID, int value ) 
	{
	settings.put(ID, value);
	}
public void putSettingsList ( LinkedHashMap<String, Integer> settings ) 
	{	
	this.settings.putAll(settings);	
	}

// g&s  ###############\\
public  final 	LinkedHashMap <String, Integer> getS ( ) 
	{ 
	return settings; 
	}	
public  int  	getS ( String ID ) 
	{ 
	return  settings.get(ID); 
	}	
public  String 	getID ( ) 
	{
	return ID;
	}
public 	Player 	getWinner ( ) 
	{
	return winner;
	}
private void 	setID ( ) 
	{
	ID = UUID.randomUUID().toString();
	}
public  void 	setID ( String iD ) 
	{
	ID = iD;
	}
public  void 	setWinner ( Player winner ) 
	{
	this.winner = winner;
	}

@Override
public  String  toString( ) 
		{
		return "Match [obj=, ID=" + ID + ", winner=" + winner + ", settings=" + settings + "]";
		}

}