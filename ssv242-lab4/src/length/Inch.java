package length;

/**
 * Length representation in terms of inches
 * @author awernick
 */
public class Inch extends Length {

	/**
	 * Conversion constant between meters and inches.
	 */
	public static final double METERS_PER_INCH = 0.0254;

	/**
	 * Store length value in terms of inches
	 * @param length length in inches
	 */
	public Inch(double length) {
		super(length);
	}

	@Override
	public void add(Length other) {
		double length = getLength();
		length += other.toMeters() / METERS_PER_INCH;
		setLength(length);
	}

	@Override
	public String getUnit() {
		if(getLength() > 1.0) {
			return "inches";
		}
		return "inch";
	}

	@Override
	public double toMeters() {
		return getLength() * METERS_PER_INCH;
	}

}
