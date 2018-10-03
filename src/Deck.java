import java.util.List;
import java.util.ArrayList;
/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {
	
	/**
	 * cards contains all the cards in the deck.
	 */
	private List<Card> cards;//List is an abstract class
	
	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;
	
	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>(); // create a blank array list of cards
        for (int j = 0; j < ranks.length; j++) { // loop through the array of ranks given to us
            for (String suitString : suits){ // for each rank, will go through all of the suits
                this.cards.add(new Card(ranks[j], suitString, values[j])); // for each card, will create a new rank, suit, and values in list
            }
        }
        // init the size variable
        this.size = cards.size();
	}
	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return this.size == 0; 
		
	}
	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return this.size; // accessor method
	}
	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}
	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() { // A card is just a some pointer to a custom object, an integer is not a pointer (just a primitive that exists in stack memory)
		// Size shows how many cards are left (but dealt cards remain in ArrayList), and size also telling us which card to pull (acting as a book mark)
        // IS EMPTY if so return null
		if(this.isEmpty()) return null; // if size is 0, we will return null
        size--; // first decrease the size of the deck by one to deal, then access and return card 
        return cards.get(size); // can directly return item, don't need to create a variable and then return the variable
	}
	
	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) { // starts at one below size
			rtn = rtn + cards.get(k); // will print out all the cards
			if (k != 0) {
				rtn = rtn + ", "; // will print a comma between cards if it's not the last one
			}
			if ((size - k) % 2 == 0) { // if size - the current counter is even, will add in a blank line
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}
		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) { 
			rtn = rtn + cards.get(k);
			if (k != size) { 
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}
		
		rtn = rtn + "\n";
		return rtn;
		
	}
}
