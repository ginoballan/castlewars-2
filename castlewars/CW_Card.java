package castlewars;

import java.util.Random;

import game.Card;

public abstract 
class CW_Card 
extends Card
{ 
	private CW_CardTypes cardType;

	public	CW_Card (CW_CardTypes ct) 
		{
		super();
		cardType = ct;
		}
	public CW_CardTypes getCardType() 
		{
		return cardType;
		}
	public final static int generateAltModifier() 
		{
		int v = 0;
		int auxMod;	
		Random rand = new Random();	
		auxMod = rand.nextInt(99);	
		if(auxMod < 30) {
			if(auxMod<10) 
				v = 3;
			else
				v = 2;}	
		else 
			v = 1;
		return v;
		}
	public final static int generateModifier() 
		{
		int v = 0;
		int auxAltMod;	
		Random rand = new Random();	
		auxAltMod = rand.nextInt(99);	
		if(auxAltMod < 30) {
			if(auxAltMod<10) 
				v = 40;
			else
				v = 25;}	
		else 
			v = 15;
			
		auxAltMod = rand.nextInt(9);	
		v = v + auxAltMod;
		return v;
		}

}