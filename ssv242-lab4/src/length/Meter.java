package length;

/**
 * Length representation in terms of meters.
 * @author awernick
 *
 */
public class Meter extends Length {

	/**
	 * Store the length in meters.
	 * @param length length in meters
	 */
	public Meter(double length) {
		super(length);
	}

	@Override
	public void add(Length other) {
		double length = getLength();
		length += other.toMeters();
		setLength(length);
	}

	@Override
	public String getUnit() {
		if(getLength() > 1.0) {
			return "meters";
		} else {
			return "meter";
		}
	}

	@Override
	public double toMeters() {
		return getLength();
	}

}
