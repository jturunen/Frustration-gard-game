package com.deadmanssolitaire.deadmanssolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class GameActivity extends AppCompatActivity{


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

    //////////////////////////TODENNäköISYYSLASKENTAA END////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        totalCards = deck.getTotalCards();
        shuffle();
        nullVars();
        Log.d("Jeba", "onCreate");
    }
    ArrayList<String> pickedCards = new ArrayList<>();
    protected void drawCard(View v){
        TextView nextCard = (TextView) findViewById(R.id.cardNumber);
        TextView losingText = (TextView) findViewById(R.id.losingText);
        assert losingText != null;
        losingText.setText(R.string.losingText_placeholder);
        if (!dead) {
            Log.d("Jeba", "drawCard alkaa");
            Log.d("Jeba", String.valueOf(killerCard));
            //Draws a card from the deck
            C = deck.drawFromDeck();
            Log.d("Jeba", "kortti nostettu pakasta");
            Log.d("Jeba", C.toString());

            pickedCards.add(C.toString());

            int listSize = pickedCards.size();
            Log.d("Jeba", String.valueOf(listSize));
            for (int i = 0; i < listSize; i++) {
                Log.i("Jeba: ", pickedCards.get(i));
            }

            //Check if the card is the same as the next card in the order
            if (C.rank == killerCard) {
                Log.d("Jeba", C.toString());
                Log.d("Jeba", "dead");
                dead = true;
                losingText.setText(R.string.player_lost);
            }


            String nextDeadlyCard = "Ace";

            switch (killerCard + 1) {
                case 0:
                    nextDeadlyCard = "Ace";
                    break;
                case 1:
                    nextDeadlyCard = "2";
                    break;
                case 2:
                    nextDeadlyCard = "3";
                    break;
                case 3:
                    nextDeadlyCard = "4";
                    break;
                case 4:
                    nextDeadlyCard = "5";
                    break;
                case 5:
                    nextDeadlyCard = "6";
                    break;
                case 6:
                    nextDeadlyCard = "7";
                    break;
                case 7:
                    nextDeadlyCard = "8";
                    break;
                case 8:
                    nextDeadlyCard = "9";
                    break;
                case 9:
                    nextDeadlyCard = "10";
                    break;
                case 10:
                    nextDeadlyCard = "Jack";
                    break;
                case 11:
                    nextDeadlyCard = "Queen";
                    break;
                case 12:
                    nextDeadlyCard = "King";
                    break;
                case 13:
                    nextDeadlyCard = "Ace";
                    break;
            }
            nextCard.setText(nextDeadlyCard);

            killerCard++;

            // Check if last card was king to start count over and check if player is dead or winner
            if (killerCard == 13 && !dead) {

                killerCard = 0;
                rounds++;

                if (rounds == 4) {
                    Log.d("Jeba", "pelaaja voitti");
                    losingText.setText(R.string.Win);
                } else {
                    System.out.println("Round " + rounds + " passed. " + (4 - rounds) + " left.");
                    //TODO INFO THE PLAYER?
                }
            }
            // set vars for the probability counting
            totalCards--;

            switch (C.getRank()) {
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

            int cardSuit = C.getSuit();
            cardRank = C.getRank();
            ImageView cardImage = (ImageView) findViewById(R.id.imageView);
            assert cardImage != null;
            if (cardSuit == 0) {
                cardImage.setImageResource(returnCardImageSpades(cardRank));
            }
            else if (cardSuit == 1) {
                cardImage.setImageResource(returnCardImageDiamonds(cardRank));
            }
            else if (cardSuit == 2) {
                cardImage.setImageResource(returnCardImageClubs(cardRank));
            }
            else if (cardSuit == 3) {
                cardImage.setImageResource(returnCardImageHearts(cardRank));
            }
            else {

                nextCard.setText(R.string.nextCard_placeholder);
                restartGame(v);
                cardImage.setImageResource(R.drawable.cardback);

            }
        }
    }

    private int returnCardImageSpades(int card){

        if (card == 0) {
            return R.drawable.ace_of_spades;
        } else if (card == 1) {
            return R.drawable.a2_of_spades;
        } else if (card == 2) {
            return R.drawable.a3_of_spades;
        } else if (card == 3) {
            return R.drawable.a4_of_spades;
        } else if (card == 4) {
            return R.drawable.a5_of_spades;
        } else if (card == 5) {
            return R.drawable.a6_of_spades;
        } else if (card == 6) {
            return R.drawable.a7_of_spades;
        } else if (card == 7) {
            return R.drawable.a8_of_spades;
        } else if (card == 8) {
            return R.drawable.a9_of_spades;
        } else if (card == 9) {
            return R.drawable.a10_of_spades;
        } else if (card == 10) {
            return R.drawable.jack_of_spades2;
        } else if (card == 11) {
            return R.drawable.queen_of_spades2;
        } else if (card == 12) {
            return R.drawable.king_of_spades2;
        }
        else {
            return R.drawable.ace_of_spades;
        }
    }

    private int returnCardImageDiamonds(int card){

        if (card == 0) {
            return R.drawable.ace_of_diamonds;
        } else if (card == 1) {
            return R.drawable.a2_of_diamonds;
        } else if (card == 2) {
            return R.drawable.a3_of_diamonds;
        } else if (card == 3) {
            return R.drawable.a4_of_diamonds;
        } else if (card == 4) {
            return R.drawable.a5_of_diamonds;
        } else if (card == 5) {
            return R.drawable.a6_of_diamonds;
        } else if (card == 6) {
            return R.drawable.a7_of_diamonds;
        } else if (card == 7) {
            return R.drawable.a8_of_diamonds;
        } else if (card == 8) {
            return R.drawable.a9_of_diamonds;
        } else if (card == 9) {
            return R.drawable.a10_of_diamonds;
        } else if (card == 10) {
            return R.drawable.jack_of_diamonds2;
        } else if (card == 11) {
            return R.drawable.queen_of_diamonds2;
        } else if (card == 12) {
            return R.drawable.king_of_diamonds2;
        }
        else {
            return R.drawable.ace_of_diamonds;
        }
    }

    private int returnCardImageClubs(int card){

        if (card == 0) {
            return R.drawable.ace_of_clubs;
        } else if (card == 1) {
            return R.drawable.a2_of_clubs;
        } else if (card == 2) {
            return R.drawable.a3_of_clubs;
        } else if (card == 3) {
            return R.drawable.a4_of_clubs;
        } else if (card == 4) {
            return R.drawable.a5_of_clubs;
        } else if (card == 5) {
            return R.drawable.a6_of_clubs;
        } else if (card == 6) {
            return R.drawable.a7_of_clubs;
        } else if (card == 7) {
            return R.drawable.a8_of_clubs;
        } else if (card == 8) {
            return R.drawable.a9_of_clubs;
        } else if (card == 9) {
            return R.drawable.a10_of_clubs;
        } else if (card == 10) {
            return R.drawable.jack_of_clubs2;
        } else if (card == 11) {
            return R.drawable.queen_of_clubs2;
        } else if (card == 12) {
            return R.drawable.king_of_clubs2;
        }
        else {
            return R.drawable.ace_of_clubs;
        }
    }

    private int returnCardImageHearts(int card){

        if (card == 0) {
            return R.drawable.ace_of_hearts;
        } else if (card == 1) {
            return R.drawable.a2_of_hearts;
        } else if (card == 2) {
            return R.drawable.a3_of_hearts;
        } else if (card == 3) {
            return R.drawable.a4_of_hearts;
        } else if (card == 4) {
            return R.drawable.a5_of_hearts;
        } else if (card == 5) {
            return R.drawable.a6_of_hearts;
        } else if (card == 6) {
            return R.drawable.a7_of_hearts;
        } else if (card == 7) {
            return R.drawable.a8_of_hearts;
        } else if (card == 8) {
            return R.drawable.a9_of_hearts;
        } else if (card == 9) {
            return R.drawable.a10_of_hearts;
        } else if (card == 10) {
            return R.drawable.jack_of_hearts2;
        } else if (card == 11) {
            return R.drawable.queen_of_hearts2;
        } else if (card == 12) {
            return R.drawable.king_of_hearts2;
        }
        else {
            return R.drawable.ace_of_hearts;
        }
    }

    protected void cheat(View v) {
        computeProbalitites();
        TextView cheat = (TextView)findViewById(R.id.textView);
        assert cheat != null;
        cheat.setText("Your chances to lose the game is "+numberFormat.format(chance) + "%");
    }


    public static void shuffle() {
        deck.shuffle();
    }


    public static void restartGame(View v) {
        nullVars();
        shuffle();
    }

    public static void nullVars() {
        totalCards = deck.getTotalCards();
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

}
