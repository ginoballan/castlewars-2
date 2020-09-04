package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server 
{
	private ArrayList<Socket> clients;
	private ServerSocket serverSocket;
	private iNetworkHandler iNH;


	public Server(iNetworkHandler iNH)
			{
			this.iNH = iNH;
			}
	public void start(int port) throws IOException 
		{

		this.clients = new ArrayList<Socket>();
		this.serverSocket = new ServerSocket(port);
		while (true)
			new ClientHandler(serverSocket.accept()).start();
		}
	public void stopServer() throws IOException 
		{
		serverSocket.close();
		}	

	public void setClients(ArrayList<Socket> clients) {
		this.clients = clients;
	}
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public void setiNH(iNetworkHandler iNH) {
		this.iNH = iNH;
	}
	public ArrayList<Socket> getClients() {
		return clients;
	}
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public iNetworkHandler getiNH() {
		return iNH;
	}
	
	class ClientHandler  extends Thread 
		{
			private Socket cs;
			private ObjectInputStream in;
			private ObjectOutputStream out;
			public Socket getCs() {
				return cs;
			}
			public void setCs(Socket cs) {
				this.cs = cs;
			}
			public ObjectInputStream getIn() {
				return in;
			}
			public void setIn(ObjectInputStream in) {
				this.in = in;
			}
			public ObjectOutputStream getOut() {
				return out;
			}
			public void setOut(ObjectOutputStream out) {
				this.out = out;
			}
	
			public 	ClientHandler(Socket socket) 
				{
				this.cs = socket;	
				}
			@Override
			public  void run() 
				{
				try{	
					clients.add(cs);
					out = new ObjectOutputStream(cs.getOutputStream());
			        in = new ObjectInputStream(cs.getInputStream());
					Message m;
					System.out.println(iNH.getP());
					while ((m = (Message) in.readObject()) != null) {
						if("hello".equals(m.getContent())){
							if(m.getOrigin().getcM()== null) {
								//m.getOrigin().setcM(iNH.getP().getcM());
								out.writeObject(iNH.getP().getcM());}
							System.out.println(m.getOrigin().getName());}
						if ("end".equals(m.getContent())) {
							/*out.print("bye");
							sacar del juego / exit match*/
							System.out.println("bye");
							in.close();
							out.close();
				//			cs.close(); 
							break; 
							}
						}
					}
					catch (IOException |ClassNotFoundException  e) {
						e.printStackTrace(); 
					}
				}
		}
}
