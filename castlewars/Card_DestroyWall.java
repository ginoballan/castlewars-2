package castlewars;

import castlewars.CW_Card;
import castlewars.CW_CardTypes;

public 
class Card_DestroyWall 
extends CW_Card  
implements SpecialCard
{
	private int modifier;
	public Card_DestroyWall() 
		{
		super( CW_CardTypes.CARD_DESTROYWALL );
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
