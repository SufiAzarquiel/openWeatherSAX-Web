package util;

public class MathUtil {
	public static float redondear(float a) {
		float roundOff = (float) (Math.round(a * 100.0) / 100.0);
		return roundOff;
	}
}
