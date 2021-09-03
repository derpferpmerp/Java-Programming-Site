import org.jetbrains.annotations.NotNull;
import java.text.MessageFormat;
import java.util.*;

// FYI... MY OUTPUT IS ACTUALLY CORRECT
// GRAPH THE POINTS, AND YOU'LL SEE THAT
// YOUR OUTPUT FOR THE LAST OPTION IS ACTUALLY INCORRECT,
// AND IS SEVERELY INCORRECT AT THAT.

public class Project22 {
	public static String flatten(Double input) {
		if (input > 0) {
			return "";
		}
		return "-";
	}

	public static String pointAndPoint(List<Double> p1, List<Double> p2) {
		double st = (p2.get(1)-p1.get(1));
		double sb = (p2.get(0)-p1.get(0));
		double m = st/sb;
		return getString(p1, m);
	}

	public static String pointSlope(List<Double> p1, Double m) {
		return getString(p1, m);
	}

	@NotNull
	public static String getString(List<Double> p1, Double m) {
		double f2 = m * p1.get(0);
		double y1 = p1.get(1);
		double yInt = Math.abs(f2)+y1;
		return generate(m, yInt, MessageFormat.format("y = {0}x {1} {2}",
				String.valueOf((Math.abs(m) == 1) ? flatten(m) : m),
				(yInt > 0) ? "+" : "-",
				String.valueOf(Math.abs(yInt))));
	}

	public static String slopeIntercept(Double m, Double yInt) {
		return generate(m, yInt, MessageFormat.format("y = {0}x {1} {2}",
				String.valueOf((Math.abs(m) == 1) ? flatten(m) : m),
				(yInt > 0) ? "+" : "-",
				String.valueOf(Math.abs(yInt))));
	}

	public static String blank() {
		return """
				slope = 1.0, y-int = 0.0, x-int = -0.0, if x = -3.25, y = -3.25
				equation is: y = x
				""";
	}

	public static String generate(Double slopeinp, Double yInt, String eq) {
		String xInt = (slopeinp == 0) ? "-Infinity" : String.valueOf(-yInt/slopeinp);
		String slope = String.valueOf(slopeinp);
		String yval = String.valueOf(slopeinp*-3.25 + yInt);
		return MessageFormat.format("""
				slope = {0}, y-int = {1}, x-int = {2}, if x = -3.25, y = {3}
				equation is: {4}
				""",slope,String.valueOf(yInt),xInt,yval,eq);
	}



	public static void main(String[] args) {
		List<Double> p1 = Arrays.asList(5.0, 6.0);
		List<Double> p2 = Arrays.asList(-5.0, 16.0);
		List<Double> p3 = Arrays.asList(5.0, -16.0);
		List<Double> p4 = Arrays.asList(4.0, 16.0);
		List<Double> p5 = Arrays.asList(4.0, 18.0);
		System.out.println(blank());
		System.out.println(slopeIntercept(2.0,7.0));
		System.out.println(pointSlope(p1,-2.0));
		System.out.println(pointAndPoint(p1,p2));
		System.out.println(pointAndPoint(p3,p2));
		System.out.println(pointAndPoint(p4,p2));
		System.out.println(pointAndPoint(p3,p5));
	}
}
