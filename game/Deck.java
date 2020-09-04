package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public  
class Deck 
implements Serializable
{ 
private static final long serialVersionUID = 1L;
protected ArrayList<Card> cards = new ArrayList<Card>();

public void shuffle() {
    Collections.shuffle(cards);
}
public Card picktopCard() 
	{
	Card c =  cards.get(0);
	this.cards.remove(0);
	return c;
	}
public Card pickRandomCard() 
	{
	Random rand = new Random();	
	int aux = rand.nextInt(cards.size());	
	Card c = cards.get(aux);
	return getCard(c);
	}
public Card pickCard(int index) 
	{
	Card c = cards.get(index);
	return getCard(c);
	}
public Card getCard(Card c) 
	{
	cards.remove(c);
	return c;
	}
public ArrayList<Card> getCards() 
		{
		return cards;
		}
}
