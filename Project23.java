import java.text.MessageFormat;
import java.util.*;
import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Project23 {
	private static String equation;

	public static Map<String,Double> getCo(String inp) {
		Pattern xCoPat = Pattern.compile("[-+.\\d]+(?=x)");
		Pattern yCoPat = Pattern.compile("[-+.\\d]+(?=y)");
		Matcher matchX = xCoPat.matcher(inp);
		Matcher matchY = yCoPat.matcher(inp);
		double xCo = 1.0;
		double yCo = 1.0;
		xCo = getxCo(matchX, xCo);
		yCo = getxCo(matchY, yCo);
		Map<String,Double> out = new HashMap<>();
		out.put("Y",yCo);
		out.put("X",xCo);
		return out;
	}

	private static double getxCo(Matcher matchX, double xCo) {
		double yCo;
		if (matchX.find()) {
			if (Objects.equals(matchX.group(), "-")) {
				yCo = -1.0;
			} else if (Objects.equals(matchX.group(), "+")) {
				yCo = 1.0;
			} else {
				String matchXString = matchX.group();
				if (matchXString.contains("+")) {
					String cropped = matchXString.substring(1);
					xCo = Double.parseDouble(cropped);
				} else {
					xCo = Double.parseDouble(matchXString);
				}
			}
		} else {
			xCo = 1.0;
		}
		return xCo;
	}

	public static Map<String,String> normalize(String inp) {
		String inpLowerCase = inp.toLowerCase();
		String outString = inpLowerCase.replaceAll("[\\s*]","");
		Map<String,String> out = new HashMap<>();
		List<String> splitted = Arrays.asList(outString.split("="));
		String normd = inpLowerCase.replaceAll("[\\s*]","");

		Map<String, Double> coEfs = getCo(normd);
		double xCo = coEfs.get("X");
		double yCo = coEfs.get("Y");
		for (String side : splitted) {
			int other = 0;
			for (int i=0; i<splitted.size(); i++) {
				if (i != splitted.indexOf(side)) {
					other = i;
					break;
				}
			}
			if (side.contains("y") && side.contains("x")) {
				xCo *= -1;
				double yIntInit = Double.parseDouble(splitted.get(other));
				double slope = xCo / yCo;
				double yInt = yIntInit / yCo;
				String yIntOut = (yInt >= 0.0) ? "+" : "-";
				yIntOut += String.valueOf(Math.abs(yInt));
				out.put("Y-INT",yIntOut);
				out.put("EQ","y = "+slope+"x"+yIntOut);
				out.put("SLOPE",String.valueOf(slope));
				return out;
			} else if (side.contains("y") && !side.contains("x")) {
				xCo *= -1;
				Pattern yIntPat = Pattern.compile("[-+]+[\\d.]+(?![xy])");
				Matcher matchYInt = yIntPat.matcher(normd);
				double yIntMatched = 0.0;
				if (matchYInt.find()) {
					String matchYIntString = matchYInt.group();
					if (matchYIntString.contains("+")) {
						String cropped = matchYIntString.substring(1);
						yIntMatched = Double.parseDouble(cropped);
					} else {
						yIntMatched = Double.parseDouble(matchYIntString);
					}
				}
				return normalize(MessageFormat.format("{0}Y{1}x={2}", yCo, xCo, yIntMatched));
			}
		}
		System.out.println(coEfs);
		return out;
	}

	public static void genLine(String equation) {
		Map<String, String> resultMap = normalize(equation);
		double slope = Double.parseDouble(resultMap.get("SLOPE"));
		double yIntercept = Double.parseDouble(resultMap.get("Y-INT"));
		String eqFixed = resultMap.get("EQ");
		System.out.println(equation);
		System.out.println("Slope: "+slope+", Y-Int: "+yIntercept);
		System.out.println("Equation: "+eqFixed);
	}

	public static void main(String[] args) {
		String input = showInputDialog("Enter an Equation.");
		genLine(input);
	}
}