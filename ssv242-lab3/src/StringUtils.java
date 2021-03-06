/**
 * Utility class with String helper methods
 * @author Alan Wernick
 */
public class StringUtils {
	public static String toTitleCase(String str) {
		StringBuilder buffer = new StringBuilder();
		str = str.toUpperCase();
		buffer.append(str.charAt(0));
		str = str.toLowerCase();
		buffer.append(str.substring(1));
		return buffer.toString();
	}
}
