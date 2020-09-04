package main;

import castlewars.CW_Player;
import game.Player;

public class funtime 
{
	public static void main(String[] args) //int cant de jugadores,
		{
			
CW_Player cwPlayer1 = new CW_Player("cwPlayer1");
CW_Player cwPlayer2 = new CW_Player("cwPlayer2");
CW_Player cwPlayer3 = new CW_Player("cwPlayer3");
CW_Player cwPlayer4 = new CW_Player("cwPlayer4");
System.out.println(cwPlayer1.getiNH());
/* while(p.getcM().getS("Cantidad de Jugadores") 
	   < p.getcM().getpL().size()) 			 
//System.out.println("while ("+clients.size() + " < "+p.getcM().getpL().size() );
//p.getcM().getS("Cantidad de Jugadores") < p.getcM().getpL().size()
//(clients.size() < p.getcM().getpL().size())
*/

cwPlayer1.playCastleWars(3,7,15,20);
System.out.println(cwPlayer1.getiNH());
System.out.println(cwPlayer1.isgC());
//cwPlayer1.getiNH().startServer();
//cwPlayer1.getiGH().waitLobby();
//cwPlayer2.getiGH().waitLobby();
//cwPlayer3.getiGH().waitLobby();
		}
}

