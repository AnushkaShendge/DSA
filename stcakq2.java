import java.util.Stack;
public class stcakq2 {
    public static void pushBottom(int data , Stack<Integer> s){
     //My Method
     /* Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s2.push(s1.pop());
        s3.push(s1.pop());
        s3.push(s1.pop());
        s3.push(s1.pop());
        if(s1.isEmpty()){
            s1.push(s2.pop());
            s1.push(s3.pop());
            s1.push(s3.pop());
            s1.push(s3.pop());
        }
        System.out.println("Elements in stack Push BOttom : " +s1);*/

        // Recersive Method
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(data, s);
        s.push(top);
        
    }
    public static void main(String[] args){
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        
        pushBottom(4,s1);
        while(!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
