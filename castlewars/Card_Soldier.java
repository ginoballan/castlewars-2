package castlewars;

public 
class Card_Soldier 
extends CW_Card  
implements SpecialCard
{
	private int modifier;
	public Card_Soldier() 
		{
		super(CW_CardTypes.CARD_SOLDIER);
		setModifier(generateModifier());
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
