package castlewars;

import java.util.ArrayList;

import game.Card;
import game.Deck;
import game.Match;
import game.Player;

public 
class CW_Player /*<cM extends Match>*/
extends Player 
implements iCardUser
{
	//en realidad deberia aplicar prototype xd
	
	private static final long serialVersionUID = 1L;
	public static final String YELLOW = "Yellow";
	public static final String BLUE = "Blue";
	public static final String GREEN = "Green";
	public static final String BLACK = "Black";
	private CW_SoldierDeck sd = new CW_SoldierDeck();
	private Deck deck = new Deck(); /*player owned cards*/
	private int castleHP = 100;
	private int wallHP = 100;
	private String color; 
	private CastleWars cM; 

	public void play(Runnable game) {
		// TODO Auto-generated method stub
		
	}
	public CW_Player() 
		{
		super();
		this.name = "CW Player ";
		}
	public CW_Player(String name) {
		super(name);
	}
	@Override
	public void createMatch() {
		System.out.println("entro a match");
		CastleWars cw_m = new CastleWars(this);
		this.cM = cw_m;
		cw_m.getPlayerList().add(this);
		setGameCreator(true);
	}
	public  void registerTurn(CW_Player origin, CW_Player Destination, CW_Card c) {
		//DB.put log  turn
		//igh.add line
		if(c.getCardType().isEndTurn())
			origin.passTurn();
	}
	private void pickCardFromMD() 
		{
		getmD().picktopCard();
		}
	private void attack(CW_Player cwp, int damage) 
		{
		int d =  cwp.getWallHP() - damage;
		destroyWall(cwp, damage);
		if(d<0) 
			d =  cwp.getCastleHP() + d; 
		if(d<0) 
			cwp.setLost(true);
		}
	private void buildWall(int amount) 
		{
		if (this.getWallHP() + amount > 100)
			this.setWallHP(100);
		else 
			this.setWallHP(this.getWallHP() + amount);
		}
	private void destroyWall(CW_Player cwp, int damage) 
		{
		int d =  cwp.getWallHP() - damage;
		destroyWall(cwp, damage);
		if(d < 0) {
			cwp.setWallHP(0);
		}else {cwp.setWallHP(d);}
		}
	private void killSoldiers(CW_Player cwp, int amount) 
		{
		for(int i=0;i < amount;i++) {
			Card_Soldier cs = (Card_Soldier)cwp.getSd().pickRandomCard();
			getmD().getCards().add(cs);}
		}
	private void restoreCastleHP(int amount) 
		{
		if (this.getCastleHP() + amount > 100)
			this.setCastleHP(100);
		else 
			this.setCastleHP(this.getCastleHP() + amount);
		}
	private void useSoldier(Card_Soldier cs) {
		sd.getCards().add(deck.getCard(cs));
	}
	private void stealCard(CW_Player cwp, int amount) 
		{
		for (int i = 0;i<amount;i++) 
			takeCard(cwp);
		}
	public void swapCards(CW_Player cwp, ArrayList<CW_Card> give, ArrayList<CW_Card> take) 
		{
		for (Card   c:  give) 
			cwp.getDeck().getCards().add(deck.getCard(c));
		for (Card   c:  take) 
			deck.getCards().add(cwp.getDeck().getCard(c));
		}
	public void takeCard (CW_Player cwp) 
		{
		deck.getCards().add(cwp.getDeck().pickRandomCard());
		}
	public void passTurn() 
		{
		for(int i = 0; i< cM.getPlayerList().size();i++) {
			Player p = cM.getPlayerList().get(i);
			if (p.equals(this)) {
				Player next = cM.getPlayerList().get(i+1);
				next.setItsTurn(true);
				}
			}
		}
	public void useCard(Card c, Player p ) 
		{
		useCard((CW_Card)c,(CW_Player)p);
		}
	public void useCard(CW_Card cwc, CW_Player cwp) 
		{
	    switch (cwc.getCardType()){
	    case CARD_ATTACK:
	    	attack(cwp, sd.sumSoldiersStrength());
	    	break;
	    case CARD_BUILDWALL:
	    	Card_BuildWall cwb = (Card_BuildWall)cwc;
	    	buildWall(cwb.getModifier());
	    	break;
	    case CARD_DESTROYWALL:
	    	Card_DestroyWall cdb = (Card_DestroyWall)cwc;
	    	destroyWall(cwp, cdb.getModifier());
	    	break;
	    case CARD_DROPXCARDS:
	    	Card_DropXCards cdc= (Card_DropXCards)cwc;
	    	for(int i = 0 ; i<cdc.getModifier();i++)
	    		((iCardUser) cwc).discard(cwp.getDeck().pickRandomCard());
	    	break;
	    case CARD_KILLXSOLDIERS:
	    	Card_Soldier cws = (Card_Soldier)cwc;
	    	//kill random soldier
    		killSoldiers(cwp, cws.getModifier());
	    	break;
	    case CARD_EXTRAXCARDS:
	    	Card_ExtraXCards cwe = (Card_ExtraXCards)cwc;
	    	for(int i = 0; i< cwe.getModifier();i++)
	    		pickCardFromMD();
	    	break;
	    case CARD_RESTORECASTLEHP:
	    	Card_RestoreCastleHP rchp = (Card_RestoreCastleHP)cwc;
	    	restoreCastleHP(rchp.getModifier());
	    	break;
	    case CARD_SOLDIER:
	    	Card_Soldier s= (Card_Soldier)cwc;
	    	useSoldier(s);
	    	break;
	    case CARD_STEALXCARDS:
	    	Card_StealXCards sc = (Card_StealXCards)cwc;
	    	stealCard(cwp, sc.getModifier());
	    	break;
	    case CARD_SWAPXCARDS:
	    	//igh showSwapMenu: 
	    	//llama a 	    	
	    	//swapCard(cwp, swc.getModifier());
	    	break;
    	}
	    if(!cwc.getCardType().equals(CW_CardTypes.CARD_SOLDIER))
	    	discard(cwc);
		}
	public void discard(CW_Card cwc) 
		{
		Card c = (Card)cwc;
		discard(c);
		}
	public void discard(Card c) 
		{
		getmD().getCards().add(deck.getCard(c));
		}
	public void discardRand() 
		{
		getmD().getCards().add(deck.pickRandomCard());
		}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CW_Player [color=" + color + /*", iGH=" + iGH + */", regDB=" + isRegDB() /*+ ", iNH=" + iNH */+ ", won=" + hasWon()
				+ ", lost=" + lost + ", gameCreator=" + isGameCreator() + ", itsTurn=" + isItsTurn() + ", ID=" + ID + ", name="
				+ name + /*", cM=" + cM + */", sd=" + sd + ", d=" + deck + ", castleHP=" + castleHP + ", wallHP=" + wallHP 
				+ "]";
	}
	@Override
	public CastleWars getcM() 
		{
		return (CastleWars)cM;
		}
 	public int getCastleHP() {
		return castleHP;
	}
	public void setCastleHP(int castleHP) {
		this.castleHP = castleHP;
	}
	public int getWallHP() {
		return wallHP;
	}
	public void setWallHP(int wallHP) {
		this.wallHP = wallHP;
	}
	public CW_SoldierDeck getSd() {
		return sd;
	}
	public void setSd(CW_SoldierDeck sd) {
		this.sd = sd;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck d) {
		this.deck = d;
	}
	public Deck getmD() {
		CastleWars cm = (CastleWars)cM;
		return cm.getMainDeck();
	}
	
	

}
