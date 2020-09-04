package castlewars;

public 
class Card_SwapXCards 
extends CW_Card
implements SpecialCard
{
	private int modifier;
	public Card_SwapXCards() 
	{
	super(CW_CardTypes.CARD_SWAPXCARDS);
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
