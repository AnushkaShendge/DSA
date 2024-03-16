public class StringPermutation {
    public static void permutation(String s , String Per){
        if(s.length() == 0){
            System.out.println("Permutation :" +Per);
        }
        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            String ns = s.substring(0, i) + s.substring(i+1);
            permutation(ns, Per + curr);
        }
        
    }// O(n!)
    public static void main(String args[]){
        String s = "abc";
        permutation(s, "");
    }
}
