import java.util.Arrays;

/**
 * Encapsulates a series of grades for a single student 
 * and provides relevant information about the collection.
 * 
 * @author Alan Wernick
 */
public class Grades {
	private static final int INITIAL_SIZE = 10;

	private String name;
	private int[] entries;
	private int index;
	
	
	public Grades() {
		this.name = "";
		this.entries = new int[INITIAL_SIZE];
		this.index = 0;
	}
	
	/**
	 * Sets the name of the student owner
	 * of the grades.
	 * @param name the name of the student
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the name of the student owner.
	 * @return name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Inserts a grade into the collection.
	 * @param grade the grade to be added to the collection
	 */
	public void addEntry(int grade) {
		if(this.index == entries.length) {
			int[] tmp = new int[entries.length + 1];
			for(int i = 0; i < entries.length; i++) {
				tmp[i] = entries[i];
			}
			entries = tmp;
		}
		entries[index++] = grade;
	}

	/**
	 * Returns the total number of grades in the
	 * collection.
	 * @return length of the collection
	 */
	public int length() {
		return this.entries.length;
	}
	
	/**
	 * Calculates the average of all the grades
	 * contained in the collection.
	 * @return the average grade of the collection.
	 */
	public double average() {
		double average = 0;

		for(int i: this.entries) {
			average += i;
		}

		return average /= this.entries.length;
	}
	
	/**
	 * Returns the median grade of the 
	 * collection.
	 * @return the median grade of the collection.
	 */
	public double median() {
		double median;
		int length = this.entries.length;

		// Make a copy so we can sort it without modifying the original
		int[] copy = Arrays.copyOf(this.entries, index);
		Arrays.sort(copy);

		if(length % 2 == 0) {
			median = ((double) copy[length/2] + (double)copy[length/2 - 1])/2;
		} else {
			median = (double) copy[length/2];
		}
		
		return median;
	}
	
	
	/**
	 * Returns the maximum grade stored.
	 * @return the maximum grade
	 */
	public int maximum() {
		int max = 0;
		for(int entry: entries) {
			if(entry > max) {
				max = entry;
			}
		}

		return max;
	}
	
	/**
	 * Returns the minimum grade stored.
	 * @return the minimum grade
	 */
	public int minimum() {
		int min = this.entries[0];
		for(int entry: entries) {
			if(entry < min) {
				min = entry;
			}
		}

		return min;
	}
	
	public String toString() {
		return String.format("%s %s", name, Arrays.toString(entries)); 
	}
}
