import java.util.Stack;
public class stack{
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        boolean result = stk.empty();
        System.out.println("Is stack empty  " + result);
        stk.push(12);
        stk.push(44);
        stk.push(34);
        stk.push(77);
        System.out.println("Elements in stack :" +stk);
        result = stk.empty();
        System.out.println("Is stack empty  " + result);
        stk.pop();
        stk.pop();
        stk.pop();
        System.out.println("Elements in stack :" +stk);
}
}