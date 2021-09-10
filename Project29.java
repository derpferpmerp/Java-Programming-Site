import java.util.*;
import static java.util.Collections.reverse;

public class Main {
  
  public static Integer toBase10(Integer input, Integer base) {
  	String stringed = String.valueOf(input);
    Integer out = 0;
    for (int i=0; i<stringed.length(); i++) {
    	int otherI = stringed.length()-i-1;
        int chrNum = Integer.parseInt(String.valueOf(stringed.charAt(i)));
        out += chrNum * ((int) Math.pow(base,otherI));
    }
    return out;
  }
  
  public static String compress(List<Integer> lst) {
  	Map<Integer,String> lNumToChar = new HashMap<>();
    List<String> mappedValues = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","z");
    List<Integer> mappedKeys = Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60);
    for (int i=0; i<mappedKeys.size();i++) {
    	lNumToChar.put(mappedKeys.get(i),mappedValues.get(i));
    }
    List<String> outList = new ArrayList<>();
    for (int i=0; i<lst.size(); i++) {
    	int num = lst.get(i);
        if (lst.get(i) >= 10) {
        	outList.add(lNumToChar.get(lst.get(i)));
        } else {
        	outList.add(String.valueOf(lst.get(i)));
        }
    }
    return String.join("",outList);
  }
  
  public static String uncompress(String input) {
  	Map<String,Integer> lNumToChar = new HashMap<>();
    List<String> mappedValues = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","z");
    List<Integer> mappedKeys = Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60);
    for (int i=0; i<mappedKeys.size();i++) {
    	lNumToChar.put(mappedValues.get(i),mappedKeys.get(i));
    }
    List<String> lst = Arrays.asList(input.split(""));
    List<Integer> outList = new ArrayList<>();
    for (int i=0; i<lst.size(); i++) {
        if (mappedValues.contains(lst.get(i))) {
        	int rChar = lNumToChar.get(lst.get(i));
            outList.add(rChar);
        } else {
        	outList.add(Integer.parseInt(lst.get(i)));
        }
    }
    List<String> out = new ArrayList<>();
    for (int i=0; i<outList.size(); i++) {
    	out.add(String.valueOf(outList.get(i)));
    }
    return String.join("",out);
    
  }
  
  public static String toBaseN(Object baseN, Integer fromBase, Integer base) {
  	Integer rem;
    String based = String.valueOf(baseN);
    Integer baseN2 = Integer.parseInt(uncompress(String.valueOf(based)));
    System.out.println(baseN2);
    Integer input = toBase10(baseN2, fromBase);
    Integer nDiv = input;
    List<Integer> lst = new ArrayList<>();
    do {
        rem = (int) nDiv % base;
        nDiv /= base;
        nDiv = (int) Math.floor(nDiv);
        lst.add(rem);
    } while (nDiv > 0);
    reverse(lst);
    return compress(lst);
  }


  public static void main(String[] args) {
    int input = 2304;
    System.out.println(toBase10(input,5));
    System.out.println(toBaseN(98765,10,16));
    System.out.println(toBaseN("2BA4",10,2));
  }
}
