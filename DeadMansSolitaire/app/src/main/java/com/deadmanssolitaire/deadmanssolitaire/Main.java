/* This is the text based game*/



package com.deadmanssolitaire.deadmanssolitaire;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	static Scanner giveCard = new Scanner(System.in);
	
	static DecimalFormat numberFormat = new DecimalFormat("#0.00");
	static DecimalFormat numberFormat2 = new DecimalFormat("#");
	
	static boolean dead = false;
	
	static Deck deck = new Deck();
	static Card C;
	static int killerCard = 0;
	static int rounds = 0;
	
	
	/////////////////////////TODENNNÄKÖISYYSLASKENTAA START////////////////////////////
	static int cardRank;
	static double totalCards;
		
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
	
	//////////////////////////TODENN�K�ISYYSLASKENTAA END////////////////////////////
	
	
	
	public static void main(String[] args)
	{
	totalCards = deck.getTotalCards();
		
	   System.out.println( "*---------------------------*");
	   System.out.println( "|----DEAD MAN'S SOLITAIRE---|");
	   System.out.println( "|---------------------------|");
	   System.out.println( "|----------RULES------------|");
	   System.out.println( "|--DRAW CARDS FROM THE DECK-|");
	   System.out.println( "|--IF THE CARD IS SAME AS---|");
	   System.out.println( "|--THE NEXT CARD IN THE ----|");
	   System.out.println( "|--FOLLOWING ORDER----------|");
	   System.out.println( "|--YOU LOSE THE GAME--------|");
	   System.out.println( "|---------------------------|");
	   System.out.println( "|-------HOW TO PLAY---------|");
	   System.out.println( "|--TYPE 'K' TO DRAW A CARD--|");
	   System.out.println( "|--TYPE 'CHEAT' TO SEE------|");
	   System.out.println( "|--PROBABILITIES------------|");
	   System.out.println( "|--TYPE 'RESTART' TO--------|");
	   System.out.println( "|--RESTART THE GAME---------|");
	   System.out.println( "*---------------------------*");
	   startGame();
	}
	
	public static void computeProbalitites() {
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
	}
	
	public static void shuffle() {
		deck.shuffle();
	}
	
	public static void startGame() {
		shuffle();
		nullVars();
		while (dead == false) {
			playGame();
		}
	}

	public static void playGame() {
		
		String nextCard =  giveCard.nextLine();
		if (nextCard.equals("k") | nextCard.equals("K")) {
			
			C = deck.drawFromDeck();
			   System.out.println( "The card number that will kill you: " + (killerCard+1) );
			   System.out.println( C.toString() );
			   
			   if ( C.rank == killerCard) {
				   System.out.println( C.toString() + " Killed you");
				   dead = true;
				   restartGame();
			   
			   }
			  
			   killerCard++;
			   if (killerCard == 13 && dead == false) {
				   
				   killerCard = 0;
				   rounds++;
				   
				   if (rounds == 4) {
					   System.out.println( "GZ, YOU WON!");
					   restartGame();
				   }
				   else {
					   System.out.println( "Round " + rounds + " passed. " + (4-rounds)+" left.");
				   }
			  }
			   
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
		}
		
	   else if (nextCard.equals("cheat") | nextCard.equals("CHEAT")) {
		   computeProbalitites();
	   }
	   
	}
		
	public static void restartGame() {
		System.out.println( "Type restart to restart the game.");
		
		String restart =  giveCard.nextLine();
		if (restart.equals("restart") | restart.equals("RESTART")) {
			startGame();
		}
		else {
			System.out.println( "You ended the game");
		}
	}
	
	public static void nullVars() {
		   dead = false;
		   killerCard = 0;
		   rounds = 0;
		   Ace = 4;
		   Two = 4;
		   Three = 4;
		   Four = 4;
		   Five = 4;
		   Six = 4;
		   Seven = 4;
		   Eight = 4;
		   Nine = 4;
		   Ten = 4;
		   Jack = 4;
		   Queen = 4;
		   King = 4;
	}
		
}
	