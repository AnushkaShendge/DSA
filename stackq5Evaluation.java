import java.util.Stack;
public class stackq5Evaluation {
    public  static boolean isOperator(char c){
        return (c == '+' || c == '/' || c == '*' || c == '^' || c == '-');
    } 
    public static int Evaluation(String prefix){
        Stack<Integer> s = new Stack<>();
        for(int i= prefix.length() - 1 ;i >= 0 ; i--){
            char c = prefix.charAt(i);
            if(!isOperator(c)){
                s.push((int)(c - 48));
            }
            else{
                int o1 = s.peek();
                s.pop();
                int o2 = s.peek();
                s.pop();
                switch(prefix.charAt(i)){
                    case '+' : 
                    s.push(o1 + o2);
                    break;
                    case '-' :
                    s.push(o1 - o2);
                    break;
                    case '*' :
                    s.push(o1 * o2);
                    break;
                    case '/' :
                    s.push(o1 / o2);
                    break;
                    case '^' :
                    s.push(o1 ^ o2);
                    break;
                }
            }

        }
        return s.peek();
    }
    public static void main(String args[]){
        String expression = "+9*26";
        System.out.println("Answer after Evaluation : " +Evaluation(expression)); 
}
}
