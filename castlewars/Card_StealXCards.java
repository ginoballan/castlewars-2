package castlewars;

public 
class Card_StealXCards 
extends CW_Card  
implements SpecialCard
{
	private int modifier;
	public Card_StealXCards() 
		{
		super(CW_CardTypes.CARD_STEALXCARDS);
		setModifier(generateAltModifier());
		}
	public int getModifier() 
		{
		return modifier;
		}
	@Override
	public void setModifier(int mod) 
		{
		this.modifier = mod;
		}
}
