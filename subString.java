public class subString {
    public static void SubSquence(String s, int idx , String ns){
        if(idx == s.length()){
            System.out.println("Sub Strings :" +ns);
            return;
        }     
        char curr = s.charAt(idx);
        // to be
        SubSquence(s , idx+1 , ns + curr);
        // not to be
        SubSquence(s, idx+1, ns);
    }// output = 2 ^ (ele in s) = 2 ^ 3 = 8 [O(2^N)](Recursive tree forms)
    public static void main(String args[]) {
        String s = "123";
        String ns = "";
        SubSquence(s, 0, ns);
    }
    
}
