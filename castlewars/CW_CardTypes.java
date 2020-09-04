package castlewars;

public enum 
CW_CardTypes
{	/* 1< x < 3 */
	CARD_ATTACK			(false,true ,false,"Carta atacar",			"Utiliza soldados activos para atacar muro y castillo rival"),
	CARD_BUILDWALL		(true ,true ,false,"Carta construye-muros","Recupera entre 15 y 40 puntos de muro"),
	CARD_DESTROYWALL	(true ,true ,false,"Carta destruye-muros",	"Daña entre 15 y 40 puntos de muro"),
	CARD_DROPXCARDS		(true ,true ,true ,"Carta descarte", 		"Hace descartar al oponente entre 1 y 3 cartas"),
	CARD_KILLXSOLDIERS	(true ,true ,true ,"Carta matar soldado", 	"Mata x soldados"),
	CARD_EXTRAXCARDS 	(true ,false,true ,"Carta levanta cartas", 	"Levanta x cartas extra del mazo"),
	CARD_RESTORECASTLEHP(true ,true ,false,"Carta recupera salud", 	"Roba entre 1 y 3 cartas"),
	CARD_SOLDIER		(true ,false,false,"Carta soldado", 		"Activa ese soldado para atacar"),
	CARD_STEALXCARDS	(true ,true ,true ,"Carta roba cartas",     "Roba entre 1 y 3 cartas"),
	CARD_SWAPXCARDS		(false,true ,true ,"Carta intercambia cartas","Intercambia cartas con un rival");

	private boolean hasModifier;
	private boolean altMod;
	private boolean endTurn;
	private String CardName;
	private String CardDescription;

	private CW_CardTypes (
			  boolean hasModifier,
			  boolean endTurn,
			  boolean altMod , 
		 	  String CardName, 
			  String CardDescription) 
				{		
				this.hasModifier = hasModifier;
				this.endTurn = endTurn;
				this.altMod = altMod;
				this.CardName = CardName;
				this.CardDescription = CardDescription;	
				}

	public boolean hasModifier() {
		return hasModifier;
	}
	public boolean hasAltMod() {
		return altMod;
	}
	public boolean isEndTurn() {
		return endTurn;
	}
	public String getCardName() {
		return CardName;
	}
	public String getCardDescription() {
		return CardDescription;
	}

}