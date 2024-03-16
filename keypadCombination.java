public class keypadCombination {
    public static String[] keypad = {"." , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv"  , "wxyz"};
    public static void Combination(String s , int idx , String Combination){
        if(idx == s.length()){
            System.out.println("Combinations in keypad :" +Combination);
            return;
        }
        char curr = s.charAt(idx);
        String Map = keypad[curr - '0'];
        for(int i =0 ; i < Map.length() ;i++){
            Combination(s, idx+1, Combination + Map.charAt(i));

        }
    } // O(4^N) --> 4(pqrs --> 4 letter in some idx)
    public static void main(String args[]){
        String s = "08";
        Combination(s, 0, "");
    }
    
}
