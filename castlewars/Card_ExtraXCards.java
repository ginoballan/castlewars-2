package castlewars;

public 
class Card_ExtraXCards 
extends CW_Card
implements SpecialCard
{
	private int modifier;
	public Card_ExtraXCards() 
		{
		super(CW_CardTypes.CARD_EXTRAXCARDS);
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
