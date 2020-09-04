package castlewars;

import game.Card;
import game.Player;

public interface iCardUser 
{
	public void useCard(Card c, Player p);
	public void discard(Card c);
}