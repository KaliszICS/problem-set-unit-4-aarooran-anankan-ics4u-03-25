/**
 * Represents a card with a name, suit, and value (to compare worth), that can return the card name and the check if two cards are the same
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
     * @param suit The Suit of the card
     * @param value The Value of the card (represents if a card is worth more or less than another)
     */
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * A getter that gets the card's name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * A getter that gets the card's suit
     * @return
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * A getter that gets the value's name
     * @return
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns " "Name" of "Suit" "
     * @Override
     */
    public String toString() {
        return this.name + " of " + this.suit;
    }

    /**
     * Returns true when two cards have the same Name, Suit, and Value, false otherwise
     * @Override
     */
    public boolean equals(Object obj) {
        
        if(obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        
        Card card = (Card)obj;
        if(card.getName().equals(this.name) && card.getSuit().equals(this.suit) && card.getValue()==(this.value)) {
            return true;
        }
        
        return false;
    }
}