package iGraphs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_JoinWin extends GUI_Frame implements Serializable
{
	private static final long serialVersionUID = 1L;
	public GUI_JoinWin(iGUI iGUI) {
		super(iGUI);
				
		setVisible(true);
		setSize(400, 170);		
		final JTextField IPstr = new JTextField();
		JLabel IPLab = new JLabel("IP del serv");
		JButton joinGameButton = new JButton("Unirse a juego");
		JPanel topJPanel = new JPanel();
		topJPanel.add(IPLab); 
		topJPanel.add(IPstr);
		topJPanel.add(joinGameButton);
		topJPanel.setLayout(new GridLayout(3,1));
		add(topJPanel, BorderLayout.NORTH);	

		joinGameButton.addActionListener(new ActionListener() {
	 		@Override
			public void actionPerformed(ActionEvent arg0) {
	 	 		GUI.getP().getiNH().startClient(IPstr.getText());
	 			}
	 		}
		);}
}