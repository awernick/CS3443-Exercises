import java.time.YearMonth;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The class represents a specific day and provides comparisons
 * between other Date objects.
 * 
 * @author Alan Wernick
 */
public class Date implements Comparable<Date>{

	// -- Constants --
	private static String ERROR_MESSAGE = "Invalid Date";
	public static String[] MONTH_NAMES = {
		"", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY",
		"AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
	};

	// -- Fields --
	private int day;
	private int month;
	private int year;
	private boolean valid;

	// -- Constructor -- 
	
	/**
	 * Accepts a string with the following format: mm dd, yyyy.
	 * The month parameter is a bit more lenient, and allows 
	 * for different formats such as the full month name, abbreviations,
	 * or digit representation.
	 * @param string string representation of a day with format mm dd, yyyy
	 */
	public Date(String string) {
		day   = -1;
		month = -1;
		year  = -1;

		// Tokenize string input
		string = string.replaceAll("[,.]", ""); // Replace unnecessary chars
		Scanner tokenizer = new Scanner(string);
		try {
			setMonth(tokenizer.next());
			int day = tokenizer.nextInt(); // Need to set the year first
			setYear(tokenizer.nextInt()); 
			setDay(day);
			valid = true;
		} 
		catch (NoSuchElementException e) { valid = false; } 
		catch (InvalidDateException d) 	 { valid = false; }

		// Prevent memory leak
		tokenizer.close();
	}
	
	// -- Setters -- 
	
	
	/**
	 * Sets the month based on a string representation. This method
	 * converts a string into a digit representation of the month.
	 * @param month month name or abbreviation.
	 * @throws InvalidDateException thrown if the string does not match any months.
	 */
	private void setMonth(String month) throws InvalidDateException {
		month = month.toUpperCase();
		for(int i = 1; i < MONTH_NAMES.length; i++) {
			if(MONTH_NAMES[i].contains(month))
				setMonth(i); // Set integer representation.
		}
	
		// Print error if the month was not found
		if(this.month == -1) {
			throw new InvalidDateException("Incorrect month");
		}
	}

	/**
	 * Sets the digit representation of a month.
	 * @param month month in digit format
	 * @throws InvalidDateException thrown if the month value is not valid
	 */
	private void setMonth(int month) throws InvalidDateException {
		if(month <= 12 && month >= 1)
			this.month = month;
		else 
			throw new InvalidDateException("Incorrect month");
	}

	/**
	 * Sets the day. 
	 * @param day day in digit format
	 * @throws InvalidDateException thrown if the day is greater than the amount of days in the month
	 */
	private void setDay(int day) throws InvalidDateException {
		int month_days = YearMonth.of(this.year, this.month).lengthOfMonth();
		if(day > month_days || day < 1 ) {
			throw new InvalidDateException("Incorrect day");
		} else {
			this.day = day;
		}
	}

	/**
	 * Sets the year
	 * @param year year value
	 */
	private void setYear(int year) {
		this.year = year;
	}

	/**
	 * Checks if the date constructed is valid or not.
	 * @return true if the date is valid, false otherwise.
	 */
	public boolean isValid() {
		return valid;
	}

	@Override
	public int compareTo(Date o) {
		// Check the year
		if(this.year < o.year) {
			return -1;
		} else if(this.year > o.year) {
			return 1;
		}

		// Check the month
		if(this.month < o.month) {
			return -1;
		} else if(this.month > o.month) {
			return 1;
		}

		// Check the day
		if(this.day < o.day) {
			return -1;
		} else if (this.day > o.day) {
			return 1;
		}

		// Everything is the same if we reached this point.
		return 0;
	}

	@Override
	public String toString() {
		if(!valid) {
			return ERROR_MESSAGE;
		} else {
			String titleizedMonth = StringUtils.toTitleCase(MONTH_NAMES[this.month]);
			return String.format("Date: %s %d, %d", titleizedMonth, this.day, this.year);
		}
	}
}
