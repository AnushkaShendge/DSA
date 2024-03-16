import java.util.Stack;
public class decodeString {
    public static String decode(String s){
        Stack<Integer> counts = new Stack<>();
        Stack<String> strings = new Stack<>();
        String res = "";
        int idx = 0 ;
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int count = 0 ;
                while(Character.isDigit(s.charAt(idx))){
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                counts.push(count);
            }
            else if(s.charAt(idx) == '['){
                strings.push(res);
                res = "";
                idx++;
            }else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder(strings.pop());
                int count = counts.pop();
                for(int i = 0 ; i < count ; i ++){
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }else{
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
    public static void main(String args[]){
        String s = "3[ab2[c]]";
        String res = decode(s);
        System.out.println(res);
    }
}

       