import java.util.*;
import static java.util.stream.Collectors.toCollection;
import static javax.swing.JOptionPane.*;

public class Project20 {

	public static int[] genRandList(int amt) {
		Random rng = new Random();
		int[] list = new int[amt];
		for (int i = 0; i < amt; i++) {
			int integer = rng.nextInt(99) + 1;
			list[i] = integer;
		}
		return list;
	}

	public static String[] sortAsString(int[] arr) {
		String[] ol = new String[arr.length];
		int indxITR = 0;
		while (arr.length != 0) {
			int mx = 0, mxIDX = 0;
			int[] newList = new int[arr.length-1];
			for (int i = 0; i < arr.length; i++) {
				int j = arr[i];
				if (j > mx) {
					mx = j;
					mxIDX = i;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				int g = (i < mxIDX) ? i : ((i > mxIDX) ? i-1 : -1);
				if (Objects.equals(g,-1)) { continue; }
				newList[g] = arr[i];
			}
			arr = newList;
			ol[indxITR] = String.valueOf(mx);
			indxITR += 1;
		}
		return ol;
	}

	public static void main(String[] args) {
		int amountOfNumbers = Integer.parseInt(showInputDialog("How Many Numbers Do You Want to Sort?"));
		int[] randomNumbers = genRandList(amountOfNumbers);
		String[] randOut = new String[randomNumbers.length];
		for (int i = 0; i < randomNumbers.length; i++) {
			randOut[i] = String.valueOf(randomNumbers[i]);
		}
		System.out.println("Unsorted: " + String.join(", ", randOut));
		String[] sortedNumbers = sortAsString(randomNumbers);
		System.out.println("Sorted: " + String.join(", ", sortedNumbers));
	}
}
