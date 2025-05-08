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

    

}
