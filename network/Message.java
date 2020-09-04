package network;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;  

import game.Player;

public class Message implements Serializable
{
	private static final long serialVersionUID = 1L;

	public  Message
		(Player origin, Player destination, String content)
		{
		this.origin 	 = origin;
		this.destination = destination;
		this.content 	 = content;
		this.date 		 = new Date();  
		}
	
	private Player origin;
	private Player destination;
	private String content;
	private Date   date;
	
	@Override
	public  String toString() {
		
		SimpleDateFormat formatter = 
		new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");     

		return
		"Message [origin=" + origin + 
		", destination=" + destination + 
		", content=" + content + 
		", date=" + formatter.format(date) + "]";
	}

	public  Player getOrigin() {
		return origin;
	}
	public  Player getDestination() {
		return destination;
	}
	public  String getContent() {
		return content;
	}
	public  Date   getDate() {
		return date;
	}
}