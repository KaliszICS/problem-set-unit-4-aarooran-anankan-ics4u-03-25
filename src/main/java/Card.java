/**
 * RAWR
 * @author Aarooran Anankan
 * @version 1.0
 */

class Card {

    //Instance Variables
    private String name;
    private String suit;
    private int value;

    /**
     * Constructor that sets the values of the instance variables to that of the parameters
     * @param name The Name of the card
     * @param suit the Suit of the card
     * @param value the Value of the card (represents if a card is worth more or less than another)
     */
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * A getter that get's the card's name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * A getter that get's the card's suit
     * @return
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * A getter that get's the value's name
     * @return
     */
    public int getValue() {
        return this.value;
    }

    @Override
    /**
     * Returns "Name of Suit"
     */
    public String toString() {
        return this.name + " of " + this.suit;
    }

    @Override
    /**
     * Returns true when, false otherwise
     */
    public boolean equals(Object obj) {
        
        if(obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        
        Card card = (Card)obj;
        if(card.getName().equals(this.name) &&&&&) {
            return true;
        }
        
        return false;
    }
}