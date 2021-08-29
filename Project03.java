public class Project03 {
    
    static void printNcharacters(String str, int numCharacters) {
      for (int i = 0; i < numCharacters; i++) {
        System.out.print(str);  
      }
      System.out.println();
    }
    
    
    public static void main(String[] args)
    {
       printNcharacters("@", 12);
       printNcharacters("*", 3);
       printNcharacters("$", 5);
       printNcharacters("$@", 4);
       printNcharacters("&@$%", 5);
    }
}
