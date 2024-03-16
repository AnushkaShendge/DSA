import java.util.Stack;
public class QueueUsingStack {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
        static void enQueue(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        static int dequeue(){
            if(s1.isEmpty()){
                return -1;
            }
            int x = s1.pop();
            return x;
        }
        static int peek(){
            if(s1.isEmpty()){
                return -1;
            }
            int x = s1.peek();
            return x;
        }
    }
    public static void main(String args[]){
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        
        System.out.println("Popped elements : " +q.dequeue());
        System.out.println("Popped elements : " +q.dequeue());
        System.out.println("Popped elements : " +q.dequeue());
        System.out.println("Popped elements : " +q.dequeue());
    }
    
}
