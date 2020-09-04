package castlewars;

import castlewars.CW_Card;
import castlewars.CW_CardTypes;

public class Card_DiscardXCards 
extends CW_Card  
implements SpecialCard
{
	private int modifier;
	public Card_DiscardXCards() 
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
