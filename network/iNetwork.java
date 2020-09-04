
package network;

import java.net.Socket;

import game.Match;

public interface iNetwork 
{
	public void sendMessage(Socket socket, Message message);
	public void sendMatch(Match m);
	public void listenForMessage();
	public void broadcastMessage();
	public void acceptConnection();
	public void endConnection();
}
