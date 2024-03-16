import java.util.Stack;
import java.util.Scanner;

public class stackq4Pree {
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
    public static String reverse(String prefix){
        String rev = "";
        for(int i= prefix.length() - 1; i >= 0 ; i--){
            char c = prefix.charAt(i);
            rev += c;
        }
        return rev;
    }
    public static String InfixToPrefix(String infix){
        Stack<Character> s = new Stack<>();
        String  prefix = "";

        for(int i =infix.length() -1  ; i >= 0 ; i--){
            char c = infix.charAt(i);
            if(c == ')'){
                s.push(c);
            }
            else if(c == '('){
                while(!s.isEmpty() && s.peek() != ')'){
                    prefix += s.pop();
                }
                if(!s.isEmpty() && s.peek() == ')'){
                    s.pop();
                }
            }  
            else if(c == '+' || c == '/' || c == '*' || c == '^' || c == '-'){
                while(!s.isEmpty() && presedance(s.peek()) > presedance(c)){
                    prefix += s.pop();
                }
                s.push(c);
            }
            else{
                prefix += c;
            }
        }
        while(!s.isEmpty()) {
            prefix += s.pop();
            
        }
        return reverse(prefix);     
    }
    public static void main(String args[]){
       
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infix = obj.nextLine();
        System.out.println("Infix: " + infix);
        String prefix = InfixToPrefix(infix);
        System.out.println("Postfix :" +prefix);
    }
}

    

