import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import length.Foot;
import length.Inch;
import length.Length;
import length.Meter;
import length.Yard;

/**
 * Contains main entry point of program.
 * @author awernick
 */
public class Lab4 {

	/**
	 * Main entry point of program. Reads data.txt
	 * and converts tokens into Length objects for
	 * processing.
	 * @param args runtime arguments for program
	 */
	public static void main(String[] args) {
		Scanner in = null;
		try {
		    in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException exception) {
		    throw new RuntimeException("failed to open data.txt");
		}
		
		ArrayList<Length> lengths = new ArrayList<Length>();

		while (in.hasNextDouble()) {
		    double value = in.nextDouble();
		    String unit = in.next();
		    Length length = null;
		    
		    switch(unit) {
		    	case "feet":
		    	case "foot":
		    		length = new Foot(value);
		    		break;
		    	case "inch":
		    	case "inches":
		    		length = new Inch(value);
		    		break;
		    	case "meter":
		    	case "meters":
		    		length = new Meter(value);
		    		break;
		    	case "yard":
		    	case "yards":
		    		length = new Yard(value);
		    		break;
		    }

		    System.out.println(length);
		    lengths.add(length);
		}
		
		System.out.println("");
		
		// Minimum - Max
		lengths.sort((Length l1, Length l2)->l1.compareTo(l2));
		Length min = lengths.get(0);
		Length max = lengths.get(lengths.size()-1);

		System.out.printf("Minimum is %s: %.1f %s\n", min.getClass(), min.getLength(), min.getUnit());
		System.out.printf("Maximum is %s: %.1f %s\n", max.getClass(), max.getLength(), max.getUnit());
		System.out.println("");
		
		// Sum: First - Last
		Length meters = new Meter(0.0);
		Length inches = new Inch(0.0);
		Length feet   = new Foot(0.0);
		Length yard   = new Yard(0.0);

		for(Length l: lengths) {
			meters.add(l);
			inches.add(l);
			feet.add(l);
			yard.add(l);
		}

		System.out.println("Sum of Lengths Adding from First to Last");
		System.out.printf("%s: %.3f %s\n", meters.getClass(), meters.getLength(), meters.getUnit());
		System.out.printf("%s: %.1f %s\n", inches.getClass(), inches.getLength(), inches.getUnit());
		System.out.printf("%s: %.1f %s\n", feet.getClass(), feet.getLength(), feet.getUnit());
		System.out.printf("%s: %.1f %s\n", yard.getClass(), yard.getLength(), yard.getUnit());

		// Sum: Last - First
		meters = new Meter(0.0);
		inches = new Inch(0.0);
		feet   = new Foot(0.0);
		yard   = new Yard(0.0);

		Object[] array = lengths.toArray();
		for(int i = array.length-1; i >= 0; i--) {
			Length l = (Length) array[i];
			meters.add(l);
			inches.add(l);
			feet.add(l);
			yard.add(l);
		}

		System.out.println();
		System.out.println("Sum of Lengths Adding from Last to First");
		System.out.printf("%s: %f %s\n", meters.getClass(), meters.getLength(), meters.getUnit());
		System.out.printf("%s: %f %s\n", inches.getClass(), inches.getLength(), inches.getUnit());
		System.out.printf("%s: %f %s\n", feet.getClass(), feet.getLength(), feet.getUnit());
		System.out.printf("%s: %f %s\n", yard.getClass(), yard.getLength(), yard.getUnit());

	}
}
