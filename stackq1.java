import java.util.Stack;
public class stackq1 {
    public static void prvSmaller(int arr[], int n){
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        System.out.println("-1" + " " );
        for(int i=1 ; i< n ; i++){
            while(!s.isEmpty() && s.peek() >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                System.out.println("-1" + " " );
            }
            else{
                System.out.println(s.peek() + " ");
            }
            s.push(arr[i]);
        }
    }
    public static void main(String args[]){
        int arr[] = { 15 , 10 , 18 , 12 , 4 , 6, 2 , 8};
        prvSmaller(arr, 8);
    }
}
