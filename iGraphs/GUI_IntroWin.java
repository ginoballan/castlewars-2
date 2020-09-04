package iGraphs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import castlewars.CastleWars;

public 
class GUI_IntroWin 
extends GUI_Frame 
implements Serializable
{
	private static final long serialVersionUID = 1L;
	public GUI_IntroWin(iGUI iGUI) {
		super(iGUI);
		JLabel imageJLabel = new JLabel();
	    BufferedImage imageBufferedReader = null; 
	    File imageFile = new File
    		( "D:\\Google Drive\\Universidad\\2018 UP\\"
		    + "2º cuatrimestre\\06 Programación 3\\proyectos\\"
		    + "TrabajoPracticoBallanUnificado\\picIntro.jpg" );       
	    try {
			imageBufferedReader = ImageIO.read(imageFile);
			imageJLabel = new JLabel(new ImageIcon(imageBufferedReader));}
	    catch (IOException e) {
	    	imageJLabel = new JLabel("Error al cargar la imagen" , SwingConstants.CENTER);	
	    	}	
		JPanel optionsJPanel = new JPanel();
		JButton createGameJButton = new JButton("Crear partida");
		JButton joinGameJButton = new JButton("Unirse a partida"); 
		JButton loadGameJButton = new JButton("Cargar a partida"); 
		optionsJPanel.setLayout(new GridLayout());
	    optionsJPanel.add(createGameJButton);
	    optionsJPanel.add(joinGameJButton);
	    optionsJPanel.add(loadGameJButton);
	    createGameJButton.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
//	    		CastleWars cw_m = new CastleWars(GUI.getP());
//	    		GUI.getP().setcM();
	    		GUI.getP().createMatch();
				System.out.println(GUI.getP().getcM());
				GUI.gameSettings();
				dispose();
			}
		});      
	    joinGameJButton.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent arg0) {	
				GUI.getP().searchForMatch();
				GUI.waitLobby();
//				GUI.joinGame();
				System.out.println("aprieto join");
				dispose();
			}
		});
	    loadGameJButton.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent arg0) {	
				GUI.loadGame();
				dispose();
			}
		});
	    add(imageJLabel, BorderLayout.NORTH);
	    add(optionsJPanel, BorderLayout.SOUTH);
	    pack();
		}//################################//
}
