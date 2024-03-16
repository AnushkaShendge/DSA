import java.util.Stack;

public class minStack {
    public static Stack<Integer> data = new Stack<>();  
    public static Stack<Integer> min = new Stack<>();
    public static void push(int val){
        data.push(val);
        if( min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    public static int pop(){
        int val = data.pop();
        if( min.peek() == val){
            min.pop();
        }
        return val;
    }
    public static int peek(){
        if(!data.isEmpty()){
            return data.peek();
        }
        return -1;
    }
    public static int min(){
        if(!min.isEmpty()){
            return min.peek();
        }
        return -1;
    }
    public static void main(String args[]){
        push(1);
        push(2);
        push(3);
        push(4);
        pop();
        pop();
       // peek();
        System.out.println("Minimum : " +min());
    }
}
