/**
 * Represents a player, with a name and an age, and a hand Card array that contains the cards in their ahnd
 * @author Aarooran Anankan
 * @version 1.0
 */
class Player {
    
    //Instance Variables
    private String name = "";
    private int age = 0;
    private Card[] hand = new Card[0];

    /**
     * Creates a player out of the provided name, age, and hand Card array
     * @param name The name of the player
     * @param age The age of the player
     * @param hand The cards in the player's hand
     */
    public Player(String name, int age, Card[] hand) {
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    /**
     * Creates a player out of the provided name and age
     * @param name The name of the player
     * @param age The age of the player
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * A getter that gets the player's name
     * @return The player name
     */
    public String getName() {
        return this.name;
    }

    /**
     * A getter that gets the player's age
     * @return The player age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * A getter that gets the cards in the player's hand
     * @return The cards in the player's hand
     */
    public Card[] getHand() {
        return this.hand;
    }

    /**
     * Returns the size of the hand
     * @return The size of the hand
     */
    public int size() {
        return this.hand.length;
    }

    /**
     * A method that adds a card from the deck to the hand of the player
     */
    public void draw(Deck deck) {
            
        if (deck!=null) {
            
            Card[] newHand = new Card[this.hand.length+1];
            
            for (int i=0; i<this.hand.length; i++) {
                newHand[i] = this.hand[i];
            }

            //Removes the top card of the deck and adds it to the hand
            newHand[newHand.length-1] = deck.draw();

            this.hand=newHand;
        }
    }

    /**
     * Discards card from hand to discard pile
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        
        if (card!=null && discardPile != null) {
            
            //Checks if the card is in the hand, if it is, it saves the index
            boolean exists = false;
            int cardIndex = -1;
            
            for (int i=0; i<this.hand.length; i++) {
                if (this.hand[i]==card) {
                    exists = true;
                    cardIndex = i;
                    i=this.hand.length;
                }
            }

            //If card exists in hand, discard it from the hand
            if (exists==true) {

                Card[] newHand = new Card[this.hand.length-1];
            
                //Copying the array up till the card location
                for (int i = 0; i < cardIndex; i++) {
                   newHand[i] = this.hand[i];
                }

                //Copying the array after the card location
                for (int i=cardIndex+1; i < newHand.length; i++) {
                    newHand[i-1] = this.hand[i];
                }

                this.hand=newHand;

                //Adds the discarded card to the discard pile
                discardPile.addCard(card);

                return true;
            }

            //If card doesn't exist in hand, return false
            else {
                return false;
            }
        }
        return false;
    }

    /**
     * Returns the specified card to the deck
     * @param card The provided card
     * @param deck The provided deck
     * @return
     */
    public boolean returnCard(Card card, Deck deck) {

        if (card!=null && deck != null) {
            
            //Checks if the card is in the hand, if it is, it saves the index
            boolean exists = false;
            int cardIndex = -1;
            
            for (int i=0; i<this.hand.length; i++) {
                if (this.hand[i]==card) {
                    exists = true;
                    cardIndex = i;
                    i=this.hand.length;
                }
            }

            //If card exists in hand, discard it from the hand
            if (exists==true) {

                Card[] newHand = new Card[this.hand.length-1];
            
                //Copying the array up till the card location
                for (int i = 0; i < cardIndex; i++) {
                   newHand[i] = this.hand[i];
                }

                //Copying the array after the card location
                for (int i=cardIndex+1; i < newHand.length; i++) {
                    newHand[i-1] = this.hand[i];
                }

                this.hand=newHand;

                //Adds the card to the deck
                deck.addCard(card);

                return true;
            }

            //If card doesn't exist in hand, return false
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    /**
     * toString Override method
     */
    public String toString() {
        
        String playerHand = this.name + ", " + this.age;

        for (int i=0; i<this.hand.length; i++) {
            
            playerHand = playerHand + ", " + hand[i].toString();
        }

        if (playerHand != "") {
            playerHand = playerHand + ".";
        }

        return playerHand;
    }
}