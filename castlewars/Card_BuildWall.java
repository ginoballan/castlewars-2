package castlewars;

import castlewars.CW_Card;
import castlewars.CW_CardTypes;

public class Card_BuildWall 
extends CW_Card 
implements SpecialCard
{
	private int modifier;
	public Card_BuildWall() 
		{
		super(CW_CardTypes.CARD_BUILDWALL);
//		CastleWarsCard.setModifier(this);
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
