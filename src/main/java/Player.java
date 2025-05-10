/**
 * 
 * @author Aarooran Anankan
 * @version 1.0
 */
class Player {
    
    //Instance Variables
    private String name = "";
    private int age = 0;
    private Card[] hand = new Card[0];

    /**
     * 
     * @param name
     * @param age
     * @param hand
     */
    public Player(String name, int age, Card[] hand) {
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    /**
     * 
     * @param name
     * @param age
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Card[] getHand() {
        return this.hand;
    }

    public int size() {
        return this.hand.length;
    }

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