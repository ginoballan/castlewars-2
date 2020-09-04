package network;

import castlewars.CW_Card;
import castlewars.CW_Player;
import castlewars.CastleWars;
import game.Card;
import game.Match;

public class Turn extends Message
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Turn
	(CW_Player origin, CW_Player destination, String content, CastleWars match, CW_Card usedCard) 
		{
		super(origin, destination, content);
		this.match 	 = match;
		this.usedCard = usedCard;
		}

	private Match  match;
	private Card   usedCard;

	public Match getMatch() 
		{
		return match;
		}
	public Card getUsedCard() 
		{
		return usedCard;
		}
}
