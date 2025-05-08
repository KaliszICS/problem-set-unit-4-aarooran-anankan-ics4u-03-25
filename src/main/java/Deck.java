import java.util.*;

/**
 * Represents a deck that can either be inputted by the user or creates a default unshuffled deck 
 * @author Aarooran Anankan
 * @version 1.0
 */
class Deck {

    //Instance Variables
    private Card[] deck;
    private String[] suitDefault = new String[] {"Hearts", "Clubs", "Diamonds", "Spades"};
    private String[] nameDefault = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private int[] valueDefault = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    /**
    * Takes in an array of cards and sets it as the deck
    * @param cardArray an array of cards that is given by the user
    */
    public Deck(Card[] cardArray) {
        this.deck = cardArray;
    }


    /**
     * Creates an unshuffled deck that acts as the default deck, goes in name order from Ace to King, and suit order from Hearts, Clubs, Diamonds, and Spaces
     */
    public Deck() {

        Card[] unshuffledDeck = new Card[52];
        int index = 0;
        
        for (int suit=0; suit<=suitDefault.length; suit++) {
            for (int name=0; name<=nameDefault.length; name++) {
                for (int value=0; value<=valueDefault.length; value++) {
                    unshuffledDeck[index]= new Card(nameDefault[name], suitDefault[suit], valueDefault[value]);
                    index++;
                }
            }
        }
        
        this.deck = unshuffledDeck;
    }

    /**
     * Returns the size of the deck
     * @return
     */
    public int size() {
        return this.deck.length;
    }

    /**
     * Returns the card at the top of the deck and reomves it from the deck
     * @return
     */
    public Card draw() {

        if (this.deck.length == 0 || this.deck[0]==null) {
            return null;
        }

        Card top = new Card(nameDefault[0], suitDefault[0], valueDefault[0]);

        for (int i=0; i<this.deck.length; i++) {
            this.deck[i] = this.deck[i+1];
        }

        return top;
    }

    /**
     * Shuffles the deck, rearranging the order of the cards
     */
    public void shuffle() {
        
		Random rand = new Random();
		
		for (int i = 0; i < this.deck.length; i++) {
			
            int randInd = rand.nextInt(this.deck.length);

            //swap
			Card temp = this.deck[randInd];
			this.deck[randInd] = this.deck[i];
			this.deck[i] = temp;
		}
    }
    
     /**
      * 
      * @param card
      */
    public void addCard(Card card) {

        if (card!=null) {
            
            Card[] newDeck = new Card[this.deck.length+1];
            
            for (int i=0; i<this.deck.length; i++) {
                newDeck[i] = this.deck[i];
            }

            newDeck[newDeck.length-1] = card;
            this.deck=newDeck;
        }
    }

    /**
     * 
     * @param cards
     */
    public void reshuffle(Card[] cards) {

        //Adding Card Array
        if (cards!=null) {
            
            Card[] newDeck = new Card[this.deck.length+cards.length];
            
            //Copying this.deck cards to the newDeck
            for (int i=0; i<=this.deck.length; i++) {
                if (cards[i]!=null) {
                    newDeck[i] = this.deck[i];
                }
            }

            //Adding the cards in the inputted array into the newDeck
            for (int i=this.deck.length; i<=newDeck.length; i++) {
                int index = 0;
                newDeck[i] = cards[index];
                index++;
            }

            this.deck=newDeck;
        }

        //Shuffle
        Random rand = new Random();
		
		for (int i = 0; i < this.deck.length; i++) {
			
            int randInd = rand.nextInt(this.deck.length);

            //Swap
			Card temp = this.deck[randInd];
			this.deck[randInd] = this.deck[i];
			this.deck[i] = temp;
		}
    }
}