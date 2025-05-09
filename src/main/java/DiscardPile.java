/**
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 * @author Aarooran Anankan
 * @version 1.0
 */
class DiscardPile {
    
    //Instance Variables
    private Card[] discardPile;

    /**
    * Takes in an array of cards and sets it as the discard pile
    * @param cardArray an array of cards that is given by the user
    */
    public DiscardPile(Card[] cardArray) {
        this.discardPile = cardArray;
    }

    //IS THIS RIGHTTTT?????
    /**
     * 
     */
    public DiscardPile() {
        this.discardPile = new Card[0];
    }

    public Card[] getDiscardPile() {
        return this.discardPile;
    }

    public int size() {
        return this.discardPile.length;
    }

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

        public Card removeCard(Card card) {
            
        if (card!=null) {
            
            Card[] newDiscardPile = new Card[this.discardPile.length-1];
            
            for (int i=0; i<this.discardPile.length; i++) {
                
                if (this.discardPile[i]==card) {
                }

                else {
                newDiscardPile[i] = this.discardPile[i];
                }
            }

            newDiscardPile[newDiscardPile.length-1] = card;
            this.discardPile=newDiscardPile;

            return card;
        }

        else {
            return null;
        }
    }

    public Card[] removeAll() {
        
        //Copies the discard pile so we can return it after we clear the original
        Card[] copyDiscardPile = new Card[this.discardPile.length];

        for (int i=0; i<this.discardPile.length; i++) {
            copyDiscardPile[i] = this.discardPile[i];
        }

        //Clears the original
        this.discardPile = new Card[0];

        return copyDiscardPile;
    }

    public String toString() {

        String allDiscardCards = "";

        for (int i=0; i<this.discardPile.length; i++) {
            allDiscardCards = allDiscardCards + ", " + discardPile[i].toString();
        }

        if (allDiscardCards != "") {
            allDiscardCards = allDiscardCards + ".";
        }

        return allDiscardCards;
    }
}
