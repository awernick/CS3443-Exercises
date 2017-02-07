import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A small utility class that extracts grades from data.txt
 * and sorts them by student. This class provides
 * useful information such as a student's average, the maximum
 * and minimum grade, and a list view of all the grades.
 * 
 * @author Alan Wernick
 *
 */
public class Lab2 {

	/**
	 * Primary entry for the program. The file data.txt
	 * is read and tokenized. The tokenized data is used 
	 * to create Grades objects and later printed to STDOUT.
	 * 
	 * @param args the parameters for execution
	 */
	public static void main(String[] args) {
		Scanner in = null;
		ArrayList<Grades> grades = new ArrayList<Grades>();

		
		// Attempt to open data.txt
		try {
			in = new Scanner(new File("data.txt"));
		} catch(FileNotFoundException e) {
			System.err.println("failed to open data.txt");
			System.exit(1);
		}

		// Tokenize the input and build Grades objects
		while(in.hasNext()) {
			String name = in.next();
			Grades grade = new Grades();
			grade.setName(name);
			while(in.hasNextInt()) {
				grade.addEntry(in.nextInt());
			}
			grades.add(grade);
		}
		
		// Test each grade
		for(Grades grade: grades) {
			testGrades(grade);
		}
	}

	/**
	 * Iterates through the grades and prints 
	 * the student name, average, length of the 
	 * collection, median, maximum and minimum
	 * 
	 * @param grades collection of grades for a student
	 */
	public static void testGrades(Grades grades) {
	    System.out.println(grades.toString()); 
	    System.out.printf("\tName:    %s\n", grades.getName());
	    System.out.printf("\tLength:  %d\n", grades.length());
	    System.out.printf("\tAverage: %.2f\n", grades.average());
	    System.out.printf("\tMedian:  %.1f\n", grades.median());
	    System.out.printf("\tMaximum: %d\n", grades.maximum());
	    System.out.printf("\tMininum: %d\n", grades.minimum());
	}
}
