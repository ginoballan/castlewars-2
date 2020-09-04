package castlewars;

public 
class Card_KillXSoldiers 
extends CW_Card
implements SpecialCard
{
	private int modifier;
	public Card_KillXSoldiers() 
		{
		super(CW_CardTypes.CARD_KILLXSOLDIERS);
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
