package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import castlewars.CastleWars;
import game.Match;

public class Client {
	private ObjectInputStream 			in;
	private ObjectOutputStream 			out;
	private Socket 						clientSocket;
	private iNetworkHandler 			iNH;
	/*
  * public static void main(String[] args) 
	{
		Player cwPlayer2 = new Player("cwPlayer2");
		System.out.println(cwPlayer2.getName());
		
		cwPlayer2.getiNH().startClient(); 
	//	cwPlayer2.getiNH().getC().sendPlayer(); 
		
	//	cwPlayer2.getiGH().waitLobby();
	}*/
//	private static final long serialVersionUID = 1L;

	public Client (iNetworkHandler iNH) {
	this.iNH = iNH;
}

	public boolean startConnection() 
		{
		System.out.println("start cli conn");
		try{
			clientSocket = new Socket(iNH.getIP(), iNetworkHandler.getPort());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			helloMessage();
			iNH.getP().getiGH().waitLobby();
			return true;
		 	}
	 	catch (IOException  e) {
	 		System.out.println("No se encontró el servidor");
	 		iNH.getP().getiGH().joinGame();
	 		return false;}
		finally{
			System.out.println(iNH.getP().getiNH());
			}
		}
	public void stopConnection(){
		try {  
			out.writeObject(new Message(iNH.getP(), iNH.getP(), "bye") );
			in.close();
			out.close();
			clientSocket.close();}
		catch (IOException e) {
			System.err.println(e);}
		}
	public void helloMessage() 
		{try{
			out.writeObject(new Message(iNH.getP(),null,"hello"));
			CastleWars  m = (CastleWars)in.readObject();
			System.out.println(iNH.getP());
			if(!iNH.getP().joinMatch(m));
				System.out.println("No se pudo unir al partido " + m.getID());
			System.out.println(iNH.getP().getcM());
		}
		catch (IOException e) 
			{System.out.println("No hay partidos disponibles");}
		catch (ClassNotFoundException e) 
			{System.out.println("Error al leer saludo inicial");}
		}
	public Message exitMessage () 
		{
		try{
			out.writeObject(new Message(iNH.getP(),iNH.getP(),"end"));
			return (Message) in.readObject();}
		catch (Exception e)	{
			System.out.println("Error al enviar mensaje exit");
			return null;}
		}
	public Message sendMessage (Message msg) 
		{
		try{
			out.writeObject(msg);
			return (Message) in.readObject();}
		catch (Exception e) 
			{return null;}
		}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}
	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}
	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	public void setiNH(iNetworkHandler iNH) {
		this.iNH = iNH;
	}
	public ObjectInputStream getIn() {
		return in;
	}
	public ObjectOutputStream getOut() {
		return out;
	}
	public Socket getClientSocket() {
		return clientSocket;
	}
	public iNetworkHandler getiNH() {
		return iNH;
	}
	}