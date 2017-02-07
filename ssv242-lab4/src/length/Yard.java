package length;

/**
 * Length representation in terms of yards
 * @author awernick
 */
public class Yard extends Length {
	
	/**
	 * Conversion constant between meters and yards.
	 */
	public static final double METERS_PER_YARD = 0.9144;

	/**
	 * Store the length in yards
	 * @param length length in yards
	 */
	public Yard(double length) {
		super(length);
	}

	@Override
	public void add(Length other) {
		double length = getLength();
		length += other.toMeters() / METERS_PER_YARD;
		setLength(length);
	}

	@Override
	public String getUnit() {
		if(getLength() > 1.0)
			return "yards";

		return "yard";
	}

	@Override
	public double toMeters() {
		return getLength() * METERS_PER_YARD;
	}
}
