/**
 * Encapsulates two dates and determines their position
 * within a range.
 * 
 * @author Alan Wernick
 */
public class DateRange {
	private Date date1;
	private Date date2;

	/**
	 * Order does not matter. The class ensures that the range
	 * is in the proper order regardless of how the parameters are passed
	 * @param d1 a Date object
	 * @param d2 another Date object
	 * @throws InvalidDateException thrown if either of the Dates are invalid
	 */
	public DateRange(Date d1, Date d2) throws InvalidDateException {	
		if(d1.isValid())
			this.date1 = d1;
		else
			throw new InvalidDateException("First Date parameter is invalid.");

		if(d2.isValid())
			this.date2 = d2;
		else
			throw new InvalidDateException("Second Date parameter is invalid.");
	}

	public String toString() {
		Date first;
		Date second;
		
		if(date1.compareTo(date2) < 0) {
			first = date1;
			second = date2;
		} else {
			first = date2;
			second = date1;
		}
		
		return String.format("DateRange: %s - %s", first.toString(), second.toString());
	}
}
