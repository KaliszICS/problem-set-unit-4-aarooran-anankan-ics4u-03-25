/**
 * Represents a discard pile that takes is inputted by the user or is empty, with a getter, size, addCard, removeCard, and removeAll methods
 * @author Aarooran Anankan
 * @version 1.0
 */
class DiscardPile {
    
    //Instance Variable
    private Card[] discardPile;

    /**
    * Takes in an array of cards and sets it as the discard pile
    * @param cardArray an array of cards that is given by the user
    */
    public DiscardPile(Card[] cardArray) {
        this.discardPile = cardArray;
    }

    /**
     * Creates an empty discard pile
     */
    public DiscardPile() {
        this.discardPile = new Card[0];
    }

    /**
     * A getter that gets the discard pile
     * @return The discard pile
     */
    public Card[] getDiscardPile() {
        return this.discardPile;
    }

    /**
     * A getter that gets the size (amount of cards) of the discard pile
     * @return The size (amount of cards) of the discard pile
     */
    public int size() {
        return this.discardPile.length;
    }

    /**
     * Adds the provided card into the discard pile
     * @param card The provided card that is added tot he discard pile
     */
    public void addCard(Card card) {
            
        if (card!=null) {
            
            Card[] newDiscardPile = new Card[this.discardPile.length+1];
            
            for (int i=0; i<this.discardPile.length; i++) {
                newDiscardPile[i] = this.discardPile[i];
            }

            newDiscardPile[newDiscardPile.length-1] = card;
            this.discardPile=newDiscardPile;
        }
    }

    /**
     * Removes the provided card from the discard pile and returns it
     * @param card The provided card that is removed from the discard pile
     * @return The card that is removed from the discard pile
     */
    public Card removeCard(Card card) {
            
        if (card!=null) {
            
            int cardIndex = -1;
            Card[] newDiscardPile = new Card[this.discardPile.length-1];

            //Finding the card index
            for (int i = 0; i < discardPile.length; i++) {

                if (discardPile[i]==card) {
                    cardIndex = i;
                }
            }

            if (cardIndex==-1) {
                return null;
            }

            //Copying the array up till the card location
            for (int i = 0; i < cardIndex; i++) {
                newDiscardPile[i] = this.discardPile[i];
            }

            //Copying the array after the card location
            for (int i=cardIndex+1; i < newDiscardPile.length; i++) {
                newDiscardPile[i-1] = this.discardPile[i];
            }

            this.discardPile=newDiscardPile;
            
            return card;
        }

        else {
            return null;
        }
    }

    /**
     * Returns an array of cards and removes them from your discard pile, returns an empty card array when there are no cards in the discard pile
     * @return The array of cards that is removed from the discard pile
     */
    public Card[] removeAll() {
        
        //Copies the discard pile so we can return it after we clear the original
        Card[] copyDiscardPile = this.discardPile;

        //Clears the original
        this.discardPile = new Card[0];

        return copyDiscardPile;
    }

    /**
     * Returns all the cards in the card format of "Name" of "Suit", etc. as a String
     * @return All the cards in the card format of "Name" of "Suit", etc.
     */
    public String toString() {

        String allDiscardCards = "";

        for (int i=0; i<this.discardPile.length; i++) {
           
            if (i==0) {
                allDiscardCards = discardPile[i].toString();
            }

            else {
            allDiscardCards = allDiscardCards + ", " + discardPile[i].toString();
            }
        }

        if (allDiscardCards != "") {
            allDiscardCards = allDiscardCards + ".";
        }

        return allDiscardCards;
    }
}
