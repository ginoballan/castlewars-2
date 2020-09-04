package iGraphs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.Serializable;
import java.util.ArrayList;

import javax.lang.model.util.Elements;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import castlewars.CW_Player;
import game.Player;

public 
class GUI_CW_Win 
extends GUI_Frame 
implements Serializable{

	private static final  long serialVersionUID = 1L;
	private ArrayList<JPanel> info;

	public  GUI_CW_Win(iGUI gui)
	{
	super(gui);
	//hacer ref a cM
//	hacer referencia a cP y tener siempre la posicion sur
	
	int p = GUI.getP().getcM().getPlayerList().size();
	class p_attributes extends Container {
		private static final long serialVersionUID = 1L;
		JLabel nameJL;
		JLabel cardsJL;
		JLabel soldiersJL;
		JLabel hpJL ;
		JLabel wallJL; 
		//getCW_Player
		public p_attributes(String name,int cards, int soldiers, int hp, int wall) 
			{
			nameJL = new JLabel(name);
			cardsJL = new JLabel(""+cards);
			soldiersJL = new JLabel(""+soldiers);
			hpJL = new JLabel(""+hp);
			wallJL = new JLabel(""+wall);
			add(nameJL);
			add(cardsJL);
			add(soldiersJL);
			add(hpJL);
			add(wallJL);
			nameJL.setVisible(true);
			cardsJL.setVisible(true);
			soldiersJL.setVisible(true);
			hpJL.setVisible(true);
			wallJL.setVisible(true);
			}
		}/*
	for(int i = 0 ; i< p;i++){
		CW_Player cwp = (CW_Player)GUI.getP();
		
		String name = cwp.getcM().getpL().get(i).getName();
		int soldiers = cwp.getcM().getpL().get(i).getSd().getCards().size();
		int cards = cwp.getcM().getpL().get(i).getDeck().getCards().size();
		int  hp = cwp.getcM().getpL().get(i).getCastleHP();
		int wall = cwp.getcM().getpL().get(i).getWallHP();

		p_attributes p_a = new p_attributes(name, cards, soldiers, hp, wall);
		info.add(new JPanel());
		for(Component e : p_a.getComponents()) {
			info.get(i).add(e);
		}
	}
*/
	JButton useCard = new JButton ("Usar carta");
	JButton discard = new JButton ("Descartar 1");
	JButton pickCard = new JButton ("Levantar 1");
	
	if(p == 2) {
		info.get(0).setLayout(new GridLayout(1,5));
		info.get(1).setLayout(new GridLayout(1,5));
		add(info.get(0),BorderLayout.NORTH);
		add(info.get(1),BorderLayout.SOUTH);
		}
	if(p == 3) {
		info.get(0).setLayout(new GridLayout(1,5));
		info.get(1).setLayout(new GridLayout(5,1));
		info.get(2).setLayout(new GridLayout(5,1));
		add(info.get(0),BorderLayout.SOUTH);
		add(info.get(1),BorderLayout.EAST);
		add(info.get(2),BorderLayout.WEST);
		}
	if(p == 4) {
		info.get(0).setLayout(new GridLayout(1,5));
		info.get(1).setLayout(new GridLayout(5,1));
		info.get(2).setLayout(new GridLayout(1,5));
		info.get(3).setLayout(new GridLayout(5,1));
		add(info.get(0),BorderLayout.SOUTH);
		add(info.get(2),BorderLayout.EAST);
		add(info.get(1),BorderLayout.NORTH);
		add(info.get(3),BorderLayout.WEST);
		}
	
	

			
			
			
		}

	/*name
	 * hp
	 * wall
	 * //puedo hacer visible el modifier 
	 * como settings adicional
	 * active soldiers 
	 * # cards

		useCard();	depende
		pickCard(); 1 sola
		discard();  cuantas quiera
*/
	}
