package castlewars;

import castlewars.CW_Card;
import castlewars.CW_CardTypes;

public 
class Card_RestoreCastleHP 
extends CW_Card  
implements SpecialCard
{
	private int modifier;
	public Card_RestoreCastleHP() 
		{
		super(CW_CardTypes.CARD_RESTORECASTLEHP);
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
