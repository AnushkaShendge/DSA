import java.util.HashSet;

public class uniqueSubString{
    public static void SubSquence(String s, int idx , String ns , HashSet<String> set){
        if(idx == s.length()){
            if(set.contains(ns)){
                return;
            }
            System.out.println("Sub Strings :" +ns);
            set.add(ns);
            return;
        }     

        // to be
        char curr = s.charAt(idx);
        SubSquence(s , idx+1 , ns + curr, set);
           
       
        // not to be
        SubSquence(s, idx+1, ns,set);
            
    }// output = 2 ^ (ele in s) = 2 ^ 3 = 8 [O(2^N)](Recursive tree forms)
    public static void main(String args[]) {
        String s = "aaa";
        String ns = "";
        HashSet<String> set = new HashSet<>();
        SubSquence(s, 0, ns, set);
    }
}
    