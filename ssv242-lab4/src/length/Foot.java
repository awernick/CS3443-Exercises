package length;

/**
 * Length representation of a Foot measurement.
 * 
 * @author awernick
 */
public class Foot extends Length {

	/**
	 * Conversion constant between meters and feet.
	 */
	public static final double METERS_PER_FOOT = 0.3048;

	/**
	 * Store the length in terms of feet.
	 * @param length length in feet units
	 */
	public Foot(double length) {
		super(length);
	}
	
	@Override
	public void add(Length other) {
		double length = getLength();
		length += other.toMeters() / METERS_PER_FOOT;
		setLength(length);
	}

	@Override
	public String getUnit() {
		if(getLength() > 1.0) {
			return "feet";
		}
		return "foot";
	}

	@Override
	public double toMeters() {
		return getLength() * METERS_PER_FOOT;
	}

}
