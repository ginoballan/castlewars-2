package castlewars;

public 
class Card_DropXCards 
extends CW_Card
implements SpecialCard
{
	private int modifier;
	public Card_DropXCards() 
		{
		super(CW_CardTypes.CARD_DROPXCARDS);
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
