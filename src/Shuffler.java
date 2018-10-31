import java.util.ArrayList;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 5;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		/*
		 * created an ArrayList called names, added names within the ArrayList, then 
		 * passed the list over to the new method, where they will be shuffled
		 */
		System.out.println("SHUFFLING NAMES");
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sophia");
		names.add("Annamarie");
		names.add("Angela");
		names.add("Aaron");
		names.add("Alex");
		names.add("Jeff");
		names.add("Tim");
		names.add("Michael");
		wordShuffle(names);
	}

	public static void wordShuffle(ArrayList<String> names) {
		for (int k = names.size() - 1; k > 0; k--) {
			
			int pos = (int)(Math.random() * k);
			
			String temp = names.get(pos);
			names.set(pos, names.get(k));
			names.set(k, temp);
		}
		
	}

	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		//multi-loop counter
		int k = 0; 
		//create a temp array with the same length
		int[] temp = new int[values.length];
		//note the midpoint of the array
		int mid = values.length/2;
		//counter to help us space out this "perfect shuffle"
		int spacer = 0;
		
		//loop through the first half
		for (; k < mid; k++) {
			//telling temp to go to spacer, and spacer needs to go up by 2
			//spacing out every other one so that they'll be shuffled
			temp[spacer] = values[k]; 
			spacer += 2; 
		}
		
		//after loop...reset spacer
			spacer = 1;
			
		//loop through the second half
		for (; k < values.length; k++) {
			temp[spacer] = values[k]; 
			spacer += 2; 
		}
		
		//copy the values back to the original array...a simple one to one transfer
		//using a new variable because k keeps changing
		for (int x = 0; x < values.length; x++) {
			values[x] = temp[x];
		}
	}
	
	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for (int k = values.length - 1; k > 0; k--) {
			int pos = (int) (Math.random() * (k +1));
	//3 part swap:
		//copy from position to temp
			int temp = values[pos];
		//copy from k to position
			values[pos] = values[k];
		//copy from temp to k
			values[k] = temp;
			} 
		}
	}
