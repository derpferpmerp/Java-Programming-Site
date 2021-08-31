// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.text.MessageFormat;
import java.util.*;

class Main {
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
    
    public static Object withOverlap(String inp, String pat, Boolean dev) {
        Integer ogLength = pat.length();
        List<Integer> posList = new ArrayList<>();
        for (int g = 0; g < pat.length(); g++) {
            posList.add(g);
        }
        Integer amt = 0;
        List<Integer> startPositions = new ArrayList<>();
        for (int i = 0; i < inp.length() - pat.length() + 1; i++) {
            if (pAI(inp,posList,i).equals(pat)) {
                amt += 1;
                startPositions.add(posList.get(0)+i);
            }
        }
        return ((dev) ? startPositions : amt);
    }
    
    public static Object withoutOverlap(String inp, String pat) {
        List<Integer> rWith = (List<Integer>) withOverlap(inp,pat,true);
        List<List<Integer>> chrList = new ArrayList<>();
        for (int i=0; i<rWith.size(); i++) {
            Integer sCoord = rWith.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int g = 0; g<pat.length(); g++) {
                tmp.add(sCoord+g);
            }
            chrList.add(tmp);
        }
        List<Integer> alreadyContains = new ArrayList<>();
        List<Integer> fParsed = new ArrayList<>();
        for (int i=0; i<chrList.size();i++) {
            List<Integer> tmpCrdList = chrList.get(i);
            Boolean isInvalid = false;
            for (int g = 0;g<tmpCrdList.size(); g++) {
                if (!((alreadyContains.contains(tmpCrdList.get(g))))) {
                    tmpCrdList.add(g);
                } else {
                    isInvalid = true;
                }
            }
            if (!isInvalid) {
                fParsed.add(tmpCrdList.get(0));
            }
        }
        
        
        return fParsed;
    }
    
    public static String reverse(String s) {
        List<String> list = new ArrayList<String>(Arrays.asList(s.split("")));
        Collections.reverse(list);
        return String.join("", list);
    }
    
    public static void main(String[] args) {
        String og = "aaabaaaaa";
        String pattern = "aaa";
        
        Integer withOverlapAmount = (Integer) withOverlap(og,pattern,false);
        Object withoutOverlapAmount = withoutOverlap(og,pattern);
        System.out.println(MessageFormat.format("Original String: {0}\nOriginal Word: {1}\n\nReversed: {2}\n\nMatches With Overlap: {3}\n\nMatches Without Overlap: {4}",og,pattern,reverse(og),withOverlapAmount,withoutOverlapAmount));
    }
}
