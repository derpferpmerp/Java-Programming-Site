import java.text.MessageFormat;
import java.util.*;
import static javax.swing.JOptionPane.*;

public class Project15 {

    public static String cIS(String inp, Integer pos) {
        return String.valueOf(inp.charAt(pos));
    }
    
    public static String pAI(String inp, List<Integer> poslst, Integer opos) {
        List<String> outString = new ArrayList<>();
        for (Integer pos : poslst) {
            outString.add(cIS(inp,pos+opos));
        }
        return String.join("",outString);
    }
    
    public static List<Integer> withOverlap(String inp, String pat, Boolean dev) {
        Integer ogLength = pat.length();
        List<Integer> posList = new ArrayList<>();
        for (int g = 0; g < pat.length(); g++) {
            posList.add(g);
        }
        int amt = 0;
        List<Integer> startPositions = new ArrayList<>();
        for (int i = 0; i < inp.length() - pat.length() + 1; i++) {
            if (pAI(inp,posList,i).equals(pat)) {
                amt += 1;
                startPositions.add(posList.get(0)+i);
            }
        }
        List<Integer> amtListOut = List.of(amt);
        return ((dev) ? startPositions : amtListOut);
    }
    
    public static List<Integer> withoutOverlap(String inp, String pat) {

        List<Integer> rWith = withOverlap(inp,pat,true);
        List<List<Integer>> chrList = new ArrayList<>();

        for (Integer sCoord : rWith) {
            List<Integer> tmp = new ArrayList<>();
            for (int g = 0; g < pat.length(); g++) {
                tmp.add(sCoord + g);
            }
            chrList.add(tmp);
        }

        List<Integer> alreadyContains = new ArrayList<>();
        List<Integer> fParsed = new ArrayList<>();

        for (List<Integer> tmpCrdList : chrList) {
            boolean isInvalid = false;
            for (Integer integer : tmpCrdList) {
                if (!alreadyContains.contains(integer) && !isInvalid) {
                    alreadyContains.add(integer);
                } else {
                    isInvalid=true;
                }
            }
            if (!isInvalid) {
                fParsed.add(tmpCrdList.get(0));
            }
        }

        return fParsed;
    }
    
    public static String reverse(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        List<String> lout = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            lout.add(list.get(i));
        }
        return String.join("", lout);
    }
    
    public static void main(String[] args) {
        String og = showInputDialog("String to Search");
        String pattern = showInputDialog("Pattern to Look For");
        
        Integer withOverlapAmount = withOverlap(og,pattern,false).get(0);
        Integer withoutOverlapAmount = withoutOverlap(og,pattern).size();
        System.out.println(MessageFormat.format("""
                Original String: {0}
                Original Word: {1}
                Reversed: {2}
                Matches With Overlap: {3}
                Matches Without Overlap: {4}""",og,pattern,reverse(og),withOverlapAmount,withoutOverlapAmount));
    }
}
