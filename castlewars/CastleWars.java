package castlewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import game.Card;
import game.Deck;
import game.Match;
import game.Player;

public 
class CastleWars 
extends Match
{
	public static final int  DEFAULTCARDSTYPE = 20;
	public static final int  MAXCARDSPERTYPE = 25;	
	public static final int  MAXDECKCARDS = 15;
	public static final int  MAXPLAYERS = 4;
	public static final int  MINCARDSPERTYPE = 7;
	public static final int  MINPLAYERS = 2;
	public static final int  MINSTARTCARDS = 7;
	private static final long serialVersionUID = 1L;

	private CW_Player currentlyPlaying = null;
	
	public  String CW_objective = "TP" + 
	"   \r\nCastillos en guerra\r\n\" " + 
	"	\"\r\nDebe poderse jugar con GUI o consola. Es por turno. 2 a 4 jugadores. Unico mazo de cartas. \r\n\" + \r\n" + 
	"	\"La distribucion y cantidad de cartas es configurable. A cada jugador se le asignan X cartas al comienzo.\r\n\" + \r\n" + 
	"	\"En su turno, el jugador puede:\r\n\" + \r\n" + 
	"	\"	- Agarrar UNA carta.\r\n\" + \r\n" + 
	"	\"	- Usar una carta, esa vuelve al mazo.\r\n\" + \r\n" + 
	"	\"	- Si es carta soldado, se baja y se puede usar otra.\r\n\" + \r\n" + 
	"	\"Posibles cartas:\r\n\r\n" + 
	"	\"	Atacar con X puntos de daño al castillo a eleccion.   Estos daños se calculan segun las cartas soldado bajadas.\r\n\" + \r\n" + 
	"	\"	Recuperar X puntos de vida.\r\n\r\n" + 
	"	\"	Hacer descartar X cartas al oponente a eleccion.\r\n\" + \r\n" + 
	"	\"	Tomar 1 carta aleatoria del mazo del oponente.\r\n\" + \r\n" + 
	"	\"	Intercambiar 1 carta con una aleatoria del oponente.	\r\n\" + \r\n" + 
	"	\"	Poder tomar otra carta adicional del mazo y jugar nuevamente.\r\n\" + \r\n" + 
	"	\"	Carta soldado. Pueden tener distintos puntos de daño. (1-70%, 2-20%, 5-10%)\r\n\" + \r\n" + 
	"	\"	Carta muro. Pueden tener distintos puntos de defensa. (1-70%, 2-20%, 5-10%)\r\n\" + \r\n" + 
	"	\"	Carta destruye muro. Con distinto punto de daño, puede destruir un muro con igual o menor puntos.\r\n\" + \r\n" + 
	"	\"	Matar soldado del oponente.\r\n\" + \r\n" + 
	"	\"Pierde/n los castillos que se quedan sin vida.\r\n\" + \r\n" + 
	"	\"Opcional:\r\n\" + \r\n" + 
	"	\"	- Grabar el juego para continuar en otro momento.\r\n\" + \r\n"; 
	private final Deck mainDeck 
					  = new Deck();

	/*
	public void run() 
		{
		while (true) {
			tick();
			painter.repaint();
	
			if (!circle && !accepted) {
				listenForServerRequest();
			}
	
		}
	}*//*
	private void render(Graphics g) {
		g.drawImage(board, 0, 0, null);
		if (unableToCommunicateWithOpponent) {
			g.setColor(Color.RED);
			g.setFont(smallerFont);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			int stringWidth = g2.getFontMetrics().stringWidth(unableToCommunicateWithOpponentString);
			g.drawString(unableToCommunicateWithOpponentString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
			return;
	
		if (accepted) {
			for (int i = 0; i < spaces.length; i++) {
				if (spaces[i] != null) {
					if (spaces[i].equals("X")) {
						if (circle) {
							g.drawImage(redX, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
						} else {
							g.drawImage(blueX, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
						}
					} else if (spaces[i].equals("O")) {
						if (circle) {
							g.drawImage(blueCircle, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
						} else {
							g.drawImage(redCircle, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
						}
					}
				}
			}
			if (won || enemyWon) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(10));
				g.setColor(Color.BLACK);
				g.drawLine(firstSpot % 3 * lengthOfSpace + 10 * firstSpot % 3 + lengthOfSpace / 2, (int) (firstSpot / 3) * lengthOfSpace + 10 * (int) (firstSpot / 3) + lengthOfSpace / 2, secondSpot % 3 * lengthOfSpace + 10 * secondSpot % 3 + lengthOfSpace / 2, (int) (secondSpot / 3) * lengthOfSpace + 10 * (int) (secondSpot / 3) + lengthOfSpace / 2);
	
				g.setColor(Color.RED);
				g.setFont(largerFont);
				if (won) {
					int stringWidth = g2.getFontMetrics().stringWidth(wonString);
					g.drawString(wonString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
				} else if (enemyWon) {
					int stringWidth = g2.getFontMetrics().stringWidth(enemyWonString);
					g.drawString(enemyWonString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
				}
			}
			if (tie) {
				Graphics2D g2 = (Graphics2D) g;
				g.setColor(Color.BLACK);
				g.setFont(largerFont);
				int stringWidth = g2.getFontMetrics().stringWidth(tieString);
				g.drawString(tieString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
			}
		} else {
			g.setColor(Color.RED);
			g.setFont(font);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			int stringWidth = g2.getFontMetrics().stringWidth(waitingString);
			g.drawString(waitingString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
		}
	
	}*//*
	private void tick() {
		if (errors >= 10) unableToCommunicateWithOpponent = true;
	
		if (!yourTurn && !unableToCommunicateWithOpponent) {
			try {//playturn player
				int space = dis.readInt();
				if (circle) spaces[space] = "X";
				else spaces[space] = "O";
				checkForEnemyWin();
				checkForTie();
				yourTurn = true;
			} catch (IOException e) {
				e.printStackTrace();
				errors++;
			}
		}
	}*//*
	private void loadImages() {
			try {
				board = ImageIO.read(getClass().getResourceAsStream("/board.png"));
				redX = ImageIO.read(getClass().getResourceAsStream("/redX.png"));
				redCircle = ImageIO.read(getClass().getResourceAsStream("/redCircle.png"));
				blueX = ImageIO.read(getClass().getResourceAsStream("/blueX.png"));
				blueCircle = ImageIO.read(getClass().getResourceAsStream("/blueCircle.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	*/

	public static void main(String[] args) 
	//int cant de jugadores,
	//...
	{

		CW_Player cwp = new CW_Player();
//		cwp.getiGH().showIntro();
		System.out.println(cwp.getcM());
		CW_Player cwp2 = new CW_Player();
		cwp.invite(cwp2);

		/*
		CastleWars cw;
        if(args.length > 0) {
        	try { 
                int n = Integer.parseInt(args[0]);
            	if(n < MAXPLAYERS && n < MAXPLAYERS) {
            		cw = new CastleWars();
            		cw.getpL().get(0).getiGH().gameSettings();
            		//already creates player
            		for(int i = 1; i< n; i++)
        				{
            			CW_Player cwp = new CW_Player();
//        				cwp.joinMatch(cw);
        				}  
            		}else {
                    load
            		//	try {buscarlo en db}
                   	cw = new CastleWars(n);
            	}
        	}catch (NumberFormatException e) {
        		cw = new CastleWars(args[0]);
        	}
        	}else {
			cw = new CastleWars();
		}
        System.out.println(cw);
//        cw.getpL().get(0).getiNH().startServer();
        System.out.println(cw.getpL().get(0));
        */
        
	}
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		
		Random r = new Random();;
		currentlyPlaying = (CW_Player)playerList.get(r.nextInt(playerList.size()));
		currentlyPlaying.setItsTurn(true);
		while(winner == null) {
		tick();
		for (Player p : playerList)
			p.getiGH().render();
		}
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public CastleWars ( int MatchID ) 
		{
		/*Match ( String ID, ArrayList<Player> pL,
				  HashMap<String,Integer> settings){*/
		}	
	public CastleWars ( Player p ) 
		{
		super(p);
		//bienvenido, primera vez acá?
		putSetting("Cantidad de Jugadores",	MINPLAYERS);
		putSetting("Min Cartas Inicio", 		MINSTARTCARDS);
		putSetting("Max Cartas Jugador", 		  MAXDECKCARDS);
		putSetting("[#Carta] Ataque de soldados", DEFAULTCARDSTYPE);
		putSetting("[#Carta] Construir muro", 	DEFAULTCARDSTYPE);		
		putSetting("[#Carta] Destruir muro", 		DEFAULTCARDSTYPE);
		putSetting("[#Carta] Oponente descarta", 	DEFAULTCARDSTYPE);
		putSetting("[#Carta] Matar Soldados", 	DEFAULTCARDSTYPE);
		putSetting("[#Carta] Carta Extra", 		DEFAULTCARDSTYPE);
		putSetting("[#Carta] Restaurar HP", 		DEFAULTCARDSTYPE);
		putSetting("[#Carta] Soldado", 	 		DEFAULTCARDSTYPE);
		putSetting("[#Carta] Robar carta", 		DEFAULTCARDSTYPE);
		putSetting("[#Carta] Intercambiar carta", DEFAULTCARDSTYPE);
//		p.joinMatch(this);
		}
	public CastleWars ( String playerName ) 
		{
			super();
			playerList.get(0).setName(playerName);
			playerList.get(0).getiGH().showIntro();
		} 

	@Override
	public boolean checkSettings(HashMap<String,Integer> set ) 
	{
		ArrayList<String>CW_SETTINGS 
		= new ArrayList<String>();
		CW_SETTINGS.add("Min Cartas Inicio");
		CW_SETTINGS.add("Min Cartas Inicio");
		CW_SETTINGS.add("Max Cartas Jugador");
		CW_SETTINGS.add("[#Carta] Ataque de soldados");
		CW_SETTINGS.add("[#Carta] Construir muro");
		CW_SETTINGS.add("[#Carta] Destruir muro");
		CW_SETTINGS.add("[#Carta] Oponente descarta");
		CW_SETTINGS.add("[#Carta] Matar Soldados");
		CW_SETTINGS.add("[#Carta] Carta Extra");
		CW_SETTINGS.add("[#Carta] Restaurar HP");
		CW_SETTINGS.add("[#Carta] Soldado");
		CW_SETTINGS.add("[#Carta] Robar carta");
		CW_SETTINGS.add("[#Carta] Intercambiar carta");
		boolean validMatch = true;
		if(set != null && !set.isEmpty()) {
			for(String s : CW_SETTINGS) {		
				if (set.containsKey(s)) {
					if(s.startsWith("[#Carta] ")) {
						if (set.get(s) > MAXCARDSPERTYPE 
						||  set.get(s) < MINSTARTCARDS) 
							validMatch = false;
						}
					} 
				else
					validMatch = false;	
				}
			if (set.get("Cantidad de Jugadores") < MINPLAYERS 
			||	set.get("Cantidad de Jugadores") > MAXPLAYERS 
			||	set.get("Min Cartas Inicio")   < MINSTARTCARDS  
			||	set.get("Min Cartas Inicio")   > MAXDECKCARDS 
			||	set.get("Max Cartas Jugador") < MINSTARTCARDS 
			||	set.get("Max Cartas Jugador") > MAXDECKCARDS)
				validMatch = false;
			}
		return validMatch;
	}	
	public void createCWCards ( ) 
	{	//objects si creara los mazos
		for (HashMap.Entry<String, Integer> entry :
			settings.entrySet()) {
			
		    String key = entry.getKey();
		    int value = entry.getValue();
		    if(key.startsWith("[#Carta] ")) {
			    String aux = key.split("[#Carta] ")[8];
			    switch (aux){
			    
				    case ("Ataque de soldados"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_Attack();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    	
				    case ("Construir muro"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_BuildWall();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    	
				    case ("Destruir muro"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_DestroyWall();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    	
				    case ("Oponente descarta"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_DropXCards();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    case ("Matar Soldados"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_KillXSoldiers();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    case ("Carta Extra"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_ExtraXCards();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    	
				    case ("Restaurar HP"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_RestoreCastleHP();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    	
				    case ("Soldado"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_Soldier();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    case ("Robar carta"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_StealXCards();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    	
				    case ("Intercambiar carta"):
				    	for(int i=0;i<value;i++) {
				    		Card c = new Card_SwapXCards();
				    		getMainDeck().getCards().add(c);}
				    	break;
				    	
			    	}
			    }
		    }
		}
	@Override
	public void putSetting ( String ID, int value ) 
	{ // switch xq settings puede escalar demasiado
	if  ( ID.startsWith("[#Carta] ")){
		if( value > MAXCARDSPERTYPE )
			value = MAXDECKCARDS;
		if( value < MINCARDSPERTYPE ) 
			value = MINCARDSPERTYPE;
		settings.put(ID, value);
		}
	else 
		{ switch(ID){
		
			case "Cantidad de Jugadores":
				if( value  > MAXPLAYERS)
					value  = MAXPLAYERS;
				if( value  < MINPLAYERS)
					value  = MINPLAYERS;
				break;
				
			case "Max Cartas Jugador":
				if( value  > MAXDECKCARDS)
					value  = MAXDECKCARDS;
				if( value  < MINSTARTCARDS)
					value  = getS("Min Cartas Inicio");	
					break;
				
			case "Min Cartas Inicio":
				if( value  > MAXDECKCARDS)
					value  = MAXDECKCARDS;
				if( value  < MINSTARTCARDS)
					value  = MINSTARTCARDS;
					break;
			}
		settings.put(ID, value);
		}	
	}
	public void setCurrentlyPlaying ( CW_Player cw_p ) 
		{
		this.currentlyPlaying = cw_p;
		}
	public CW_Player getCurrentlyPlaying ( ) 
		{
		return currentlyPlaying;
		}
	public CW_Player getCW_Player(int index) 
		{
		return (CW_Player)playerList.get(index);
		}
	public Deck  getMainDeck ( ) 
		{
		return mainDeck;
		}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return 
	  "\t\tCastleWars "
	    + "[CW_objective=" + CW_objective + ","
		+ "mainDeck=" + mainDeck + ","
		+ "currentlyPlaying="	+ currentlyPlaying + ","
		+ "ID=" + ID + ", "
		+ "winner=" + winner + ", "
		+ "pL=" + playerList +","
		+ "settings=" + settings + "]";
	}
	
}