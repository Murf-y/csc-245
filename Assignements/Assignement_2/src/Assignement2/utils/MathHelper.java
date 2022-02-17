package Assignement2.utils;

public class MathHelper {
	private static final float EPSILON = 0.0001f;
	public static boolean floatAproxEquals(float a, float b) {
		return (Math.abs(a - b) <= EPSILON);
	}
}
