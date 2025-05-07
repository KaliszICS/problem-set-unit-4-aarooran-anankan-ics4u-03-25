/**
 * 
 */
class Deck {

    //Instance Variables
    private Card card;
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
     * 
     */
    public Deck() {

        Card[] unshuffledDeck;
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
}