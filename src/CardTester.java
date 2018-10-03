/**
 * This is a class that tests the Card class.
*/
public class CardTester {
	/**
	* The main method in this class checks the Card operations for consistency.
	*	@param args is not used.
	*/
	public static void main(String[] args) {

		
		//CARD 1
		System.out.println("–––– CARD 1 TESTS ––––");
		Card one = new Card("ace", "spades", 1);
		System.out.println("Card 1 suit: " + one.suit());
		System.out.println("Card 1 rank: " + one.rank());
		System.out.println("Card 1 point: " + one.pointValue());
		
		//CARD 2
		System.out.println("–––– CARD 2 TESTS ––––");
		Card two = new Card("ace", "spades", 1);
		System.out.println("Card 2 suit: " + two.suit());
		System.out.println("Card 2 rank: " + two.rank());
		System.out.println("Card 2 point: " + two.pointValue());
		System.out.println("Card 1 matches Card 2: " + one.matches(two));
		
		//CARD 3
		System.out.println("–––– CARD 3 TESTS ––––");
		Card three = new Card("queen", "hearts", 11);
		System.out.println("Card 3 suit: " + three.suit());
		System.out.println("Card 3 rank: " + three.rank());
		System.out.println("Card 3 point: " + three.pointValue());
		System.out.println("Card 1 matches Card 3: " + one.matches(three));
		System.out.println("Card 2 matches Card 3: " + two.matches(three));
		
		
		}
}