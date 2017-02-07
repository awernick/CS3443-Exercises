import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the main entry point of the program.
 * 
 * @author Alan Wernick
 */
public class DateTest {
	
	/**
	 * Main entry point to the program.
	 * Reads data from the dates.txt file and converts it to 
	 * Date and DateRange objects. Those objects are then
	 * printed to STDOUT.
	 * 
	 * @param args runtime arguments for the program.
	 */
	public static void main(String[] args) {
		Date prev = null;
		Scanner in = null;

		try {
			in = new Scanner(new File("dates.txt"));
		} catch(FileNotFoundException e) {	
			System.err.println("Failed to open dates.txt");
			System.exit(1);
		}
	
		while(in.hasNextLine()) {
			Date date = new Date(in.nextLine());
			System.out.println(date);

			if(prev != null) {
				try {
					if(prev.compareTo(date) == -1) {
						DateRange range = new DateRange(prev, date);
						System.out.println(range);
					}
				} catch (InvalidDateException i) { /* NOOP */ }
			}
			prev = date;
		}
	}
}
