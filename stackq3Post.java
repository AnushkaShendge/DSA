import java.util.Stack;
import java.util.Scanner;

public class stackq3Post {
    public static int presedance(char c){
        if( c == '^')
        return 4;
        else if(c == '*' || c == '/')
        return 3;
        else if(c == '+' || c == '-')
        return 2;
        else 
        return 1;
        
    }
    public static String InfixToPostfix(String infix){
        Stack<Character> s = new Stack<>();
        String  postfix = "";

        for(int i =0 ; i < infix.length() ; i++){
            char c = infix.charAt(i);
            if(c == '('){
                s.push(c);
            }
            else if(c == ')'){
                while(!s.isEmpty() && s.peek() != '('){
                    postfix += s.pop();
                }
                if(!s.isEmpty() && s.peek() == ')'){
                    s.pop();
                }
            }  
            else if(c == '+' || c == '/' || c == '*' || c == '^' || c == '-'){
                while(!s.isEmpty() && presedance(s.peek()) >= presedance(c)){
                    postfix += s.pop();
                }
                s.push(c);
            }
            else{
                postfix += c;
            }
        }
        while(!s.isEmpty()) {
            postfix += s.pop();
            
        }
    return postfix;
           
    }
    public static void main(String args[]){
       
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infix = obj.nextLine();
        System.out.println("Infix: " + infix);
        String postfix = InfixToPostfix(infix);
        System.out.println("Postfix :" +postfix);
    }
}
