package iGraphs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import castlewars.CW_Player;
import game.Player;
import network.iNetworkHandler;

public
class GUI_LobbyWin
extends GUI_Frame  
implements Serializable 
{//##############################################//
private static final long serialVersionUID = 1L;
private boolean 	   ready;
private ArrayList<Player> pL;
private ArrayList<JPanel> playerPanelList = new ArrayList<JPanel>();
private ArrayList<JLabel> playerNamesList = new ArrayList<JLabel>();
private ArrayList<JLabel> playerIPList 	= new ArrayList<JLabel>();
//######################################\######################//
public 	GUI_LobbyWin (iGUI gui)
{
	super(gui);	
	System.out.println(GUI.getP());
	/*
	if(GUI.getP().getiNH()==null)
		GUI.getP().setiNH(new iNetworkHandler(GUI.getP()));
	GUI.getP().getiNH().startServer();*/

	/*
	for(Player pp : pL) {
		if(pp.getiNH().getC().getClientSocket()!=null)
			ready = false;}
	*/
	
	pL = GUI.getP().getcM().getPlayerList();
	
	String k = "Cantidad de Jugadores";
	int p = GUI.getP().getcM().getS(k);
	if (pL.size() ==  p)
		ready = true;
	/*
	for(Player pp : pL) {
		if(pp.getiNH().getC().getClientSocket()!=null)
			ready = false;}
	*/
	if(ready == true)
		this.setVisible(false);
	
	
	
	
	//- frame -----------------------------------
	JPanel topPanel = new JPanel();
	JPanel midJPanel = new JPanel();
	JPanel lowerPanel = new JPanel();
	add(topPanel, BorderLayout.NORTH);	
	add(midJPanel, BorderLayout.CENTER);	
	add(lowerPanel, BorderLayout.SOUTH);	
	setVisible(true);
	//setSize(400, 600);		
	// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	// setRelativeTo
	//REVISAR
/*	public void incomingMessage(String mensaje) {
		ta1.append(mensaje);}*/
	JTextArea ta1 = new  JTextArea(5, 20);
	JTextField t1 = new JTextField();
	JLabel etiqueta = new JLabel("cliente");
	JScrollPane scrollPane = new JScrollPane(ta1); 
	ta1.setEditable(false);
	this.setVisible(true);
	ta1.setFont(new Font("Serif", Font.ITALIC, 16));
	ta1.setLineWrap(true);
	ta1.setWrapStyleWord(true);
	/*JButton b1 = new JButton("mensaje a jugador");
	b1.setEnabled(false);
	JButton b2 = new JButton("mensaje a servidor");
	b2.setEnabled(false);
	JButton b3 = new JButton("parar conexion");
	b3.setEnabled(false);
	JButton b4 = new JButton("iniciar conexion");*/
	JPanel panel = new JPanel();
	panel.add(t1);
	panel.add(etiqueta);
	panel.add(scrollPane);
	this.add(panel, BorderLayout.SOUTH);
		
	//-lower-panel-----------------
	lowerPanel.setLayout( new GridLayout(6,1));	
	JButton	copyIPButton  = new JButton("Copiar dirección");
	JButton	continueButton = new JButton("Continuar"); 
	
	JButton	connectButton = new JButton("Conectar cliente");
	JButton disconnectButton= new JButton("Desconectar cliente"); 
	JButton refreshButton= new JButton("refrescar"); 

	JButton stopServerButton = new JButton("Parar servidor");
	JButton startServerButton = new JButton("Iniciar servidor");
//	JButton advSettingsButton  = new JButton("Configuraciones");
	
	if(GUI.getP().isGameCreator()) {
		lowerPanel.add(startServerButton);
		lowerPanel.add(stopServerButton);}
	else{
		lowerPanel.add(connectButton);
		lowerPanel.add(disconnectButton);}
	lowerPanel.add(continueButton);
	lowerPanel.add(copyIPButton);;
	lowerPanel.add(refreshButton);
	
	if(ready == false) 
		continueButton.setEnabled(false);
	//-botones---------------------------------------------\\
	copyIPButton		.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			StringSelection selection = new StringSelection(GUI.getP().getiNH().getIP().toString());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);				
	}});
	connectButton		.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GUI.getP().getiNH().startClient();
			
	}});
	disconnectButton	.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
	}});
	startServerButton	.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GUI.getP().getiNH().startServer();}});
	stopServerButton	.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	//		GUI.getP().getiNH().stopServer();
	}});
	continueButton		.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//hago que todos empiecen el juego
			
			//hacer un ultimo chequeo antes de mandarle mecha
			//System.out.println("currentGame.FinalSettings() =  "+ currentGame.FinalSettings() );
			//System.out.println(currentGame.toString());
			//System.out.println(currentTextProcessor.toString());
			//System.out.println(currentGame.getCurrentPlayer().toString());
	}});
	refreshButton		.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		//	getContentPane().removeAll();
		//  revalidate();
			System.out.println(GUI.getP().getiNH()); 
			System.out.println(GUI.getP().getcM()); 
			
		}});
	
	//-top-panel------------------------
	
	int auxInt = pL.size();
	JLabel playersAmountLabel = new JLabel(k+": " + auxInt 
	+" / "+	GUI.getP().getcM().getS("Cantidad de Jugadores"));
	topPanel.add(playersAmountLabel);
	topPanel.setOpaque(true);
	topPanel.setBackground(Color.DARK_GRAY);	
	playersAmountLabel.setOpaque(true);
	playersAmountLabel.setForeground(Color.white);
	playersAmountLabel.setBackground(Color.DARK_GRAY);
	
	//-mid-panel------------------------
	
	midJPanel.setLayout(new GridLayout(pL.size(),1));
		
	for (int i = 0; i<=pL.size()-1;i++) {
		Player cwp	= GUI.getP().getcM().getPlayerList().get(i);
		//System.out.println(pL.get(i).getName());	
			//System.out.println(i + " < " + pL.size());
			playerPanelList.add(new JPanel());	
			playerNamesList.add(new JLabel(pL.get(i).getName()));
			playerIPList.add(new JLabel(pL.get(i).getiNH().getIP()));		
		
			playerNamesList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			playerIPList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
		
			playerPanelList.get(i).setLayout(new FlowLayout(FlowLayout.LEFT));
			playerPanelList.get(i).add(playerNamesList.get(i));
			playerPanelList.get(i).add(playerIPList.get(i));
			if     (GUI.getP().getcM().getPlayerList().get(i).getName().
			equals (GUI.getP().getName())){
				playerIPList.get(i).setOpaque(true);
				playerIPList.get(i).setBackground(Color.GRAY);
				playerIPList.get(i).setForeground(Color.white);	
				playerPanelList.get(i).setOpaque(true);			
				playerPanelList.get(i).setBackground(Color.GRAY);
				playerNamesList.get(i).setOpaque(true);
				playerNamesList.get(i).setBackground(Color.GRAY);
				playerNamesList.get(i).setForeground(Color.white);}
			midJPanel.add(playerPanelList.get(i));}
		
	
	addWindowListener
		(new WindowAdapter() {
		@Override
		public void windowClosing
		(WindowEvent windowEvent) {
		//currentGame.clearSettings();	
		Component component = (Component) windowEvent.getSource();if(
			JOptionPane.showConfirmDialog(component, 
			"Desea volver al menu principal?", "Main Menu?", 
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				
				if(GUI.getP().isGameCreator()){
					//stop server, kick all players from match
				} else {
					//leave match and erase itself from pL
				}}}});
	
	pack();
	}
}//####################################//

/* sacar una vez que haya connect *//*/*/
//Refresh button 
/*
private void 	paintFrame(JFrame lobbyJFrame)
{{
/* #players x/x
 * nombres - IPs
 * cancel
 * copy
 * continue
 * disconnect 
 * start
 * stop 
 */
//settingsInfo.sort(); aca hago shuffle
