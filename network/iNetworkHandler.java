package network;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import game.Player;
public class iNetworkHandler 
{//############\\ 
@SuppressWarnings("unused")
private Player 	p;
private Client 	c;
private Server 	s;
private String 	IP = "localhost";
private static final int port = 42069;
public iNetworkHandler	( Player p )  
	{	
	this.p = p;	
	//IP =  "localhost";	
	}
public void startServer ( ) 
	{
	if(p.isGameCreator()) {
		try{
			s = new Server(this);
			System.out.println("nuevo server");
			s.start(port);
			} 
		catch(IOException ex) {
		    System.err.println("Error encountered! Port is likely already in use! Exiting program...");
		    ex.printStackTrace();}
		}
	}
public void startClient ( ) 
	{
	if(!p.isGameCreator()) 
		{
		if(c ==  null)
			c = new Client(this);
		
		System.out.println(c.startConnection());	
		
		}    	
	}
public void startClient ( String IP ) 
	{
	this.IP = IP;
	startClient();
	}
//###############################//
public Player getP ( ) 
	{
	return p;
	}
public String getIP ( ) 
	{
	return IP;
	}
public ArrayList<Socket> getClients ( ) 
	{
	return s.getClients();
	}
public static int getPort( ) 
	{
	return port;
	}
public void setP ( Player p ) 
	{
	this.p = p;
	}
public void setIP ( String ip ) 
	{
	this.IP = ip;
	}
//#######################//
@Override
public String  toString() 
	{
	return "\niNetworkHandler "
		+ "\n\tc=" + c + ", "
		+ "\n\ts=" + s + ", "
		+ "\n\tIP=" + IP + ", "
		+ "\n\tport=" + port + "]";
	}
}//###################//