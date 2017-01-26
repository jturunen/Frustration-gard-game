
/* Most of this code is from the old text based game and is not converted to the fx game */

package com.deadmanssolitaire.deadmanssolitaire;

import java.text.DecimalFormat;

public class Probability {

	static int cardRank;
	static double totalCards;
	
	static int killerCard = 0;
	
	static double Ace = 4;
	static double Two = 4;
	static double Three = 4;
	static double Four = 4;
	static double Five = 4;
	static double Six = 4;
	static double Seven = 4;
	static double Eight = 4;
	static double Nine = 4;
	static double Ten = 4;
	static double Jack = 4;
	static double Queen = 4;
	static double King = 4;
	
	static double chance;

	public static void main(String[] args)
	{
		DecimalFormat numberFormat = new DecimalFormat("#0.00");
		DecimalFormat numberFormat2 = new DecimalFormat("#");
		Deck deck = new Deck();
		Card C;
		totalCards = deck.getTotalCards();
		System.out.println( deck.getTotalCards() );

	   while (deck.getTotalCards()!= 0 )
	   {
		   switch(killerCard) {
		   case 0:
			   chance = Ace / totalCards * 100;
			   System.out.println("Chances to draw Ace is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Ace) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 1:
			   chance = Two / totalCards * 100; 
			   System.out.println("Chances to draw two is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Two) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 2:
			   chance = Three / totalCards * 100;
			   System.out.println("Chances to draw three  is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Three) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 3:
			   chance = Four / totalCards * 100;
			   System.out.println("Chances to draw four is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Four) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 4:
			   chance = Five / totalCards * 100;
			   System.out.println("Chances to draw five is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Five) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 5:
			   chance = Six / totalCards * 100;
			   System.out.println("Chances to draw six " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Six) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 6:
			   chance = Seven / totalCards * 100;
			   System.out.println("Chances to draw seven is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Seven) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 7:
			   chance = Eight / totalCards * 100;
			   System.out.println("Chances to draw eight is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Eight) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 8:
			   chance = Nine / totalCards * 100;
			   System.out.println("Chances to draw  nine is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Nine) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 9:
			   chance = Ten / totalCards * 100;
			   System.out.println("Chances to draw ten is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Ten) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 10:
			   chance = Jack / totalCards * 100;
			   System.out.println("Chances to draw Jack is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Jack) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 11:
			   chance = Queen / totalCards * 100;
			   System.out.println("Chances to draw Queen is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(Queen) + " out of " + numberFormat2.format(totalCards));
			   break;
			   
		   case 12:
			   chance = King / totalCards * 100;	   
			   System.out.println("Chances to draw King is: " + numberFormat.format(chance) + "%");
			   System.out.println("in other words " + numberFormat2.format(King) + " out of " + numberFormat2.format(totalCards));
			   break;
		   }
		   
		   C = deck.drawFromDeck();
		   System.out.println( C.toString() );
		   System.out.println(C.getRank());
		   totalCards--;
		   
		   switch(C.getRank()) {
		   case 0:
			   Ace--;
			   break;
		   case 1:
			   Two--;
			   break;
		   case 2:
			   Three--;
			   break;
		   case 3:
			   Four--;
			   break;
		   case 4:
			   Five--;
			   break;
		   case 5:
			   Six--;
			   break;
		   case 6:
			   Seven--;
			   break;
		   case 7:
			   Eight--;
			   break;
		   case 8:
			   Nine--;
			   break;
		   case 9:
			   Ten--;
			   break;
		   case 10:
			   Jack--;
			   break;
		   case 11:
			   Queen--;
			   break;
		   case 12:
			   King--;
			   break;
		   }	   
		   
		   killerCard++;
		   if (killerCard == 13) {  
			   killerCard = 0;
		   }
	   }
	}
}	

