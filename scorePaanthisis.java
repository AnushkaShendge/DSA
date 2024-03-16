import java.util.Stack;
public class scorePaanthisis {
    public static int Score(String s){
        Stack<Integer> stack = new Stack<>();
        int score = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if( c == '('){
                stack.push(score);
                score = 0 ;
            }
            else{
                int prvsc = stack.pop() ;
                if(score == 0){
                    score = prvsc + 1;
                }
                else{
                    score = prvsc + 2 * score;
                }
            }
        }
        return score;
    }
    public static void main(String args[]){
        String s = "(())";
        System.out.println(Score(s));
    }
    
}
