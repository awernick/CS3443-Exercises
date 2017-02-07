import java.io.File;
import java.util.Scanner;

/**
 * This class consists of a static method that reads
 * a file from the package called data.txt
 * and parses the contents of it to classify whether
 * they are a number or a string.
 * 
 * @author Alan Wernick
 *
 */
public class Lab1 {

	/**
	 * Main entry point of the program. 
	 * Reads the data.txt file from the package and calls
	 * numberTokenCounter to process the contents.
	 * 
	 * @param args the arguments passed to the program
	 */
	public static void main(String[] args) {
		Scanner in = null;

		try {
			in = new Scanner(new File("data.txt"));
		}
		catch (Exception FileNotFoundException) {	
			System.err.println("Could not open data.txt");
			System.exit(1);
		}
		
		numberTokenCounter(in);
	}
	
	/**
	 * Reads from input and classifies if the token is either 
	 * a number (double) or a string of some sort. 
	 *  
	 * @param input Scanner object with input to classify.
	 */
	
	public static void numberTokenCounter(Scanner input) {
		int numberCount = 0;
		int nonCount = 0;
		double total = 0.0;

		while(input.hasNext()) {
			if(input.hasNextDouble()) {
				double d = input.nextDouble();
				total += d;
				numberCount++;
			} else {
				input.next();
				nonCount++;
			}
		}

		String output = String.format("%d %d %.1f", numberCount, nonCount, total);
		System.out.println(output);
	}

}
