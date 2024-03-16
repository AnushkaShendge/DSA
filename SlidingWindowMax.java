import java.util.Deque;
import java.util.LinkedList;
public class SlidingWindowMax {
    public static int[] WindowMax(int[] numb , int k){
        int n = numb.length;
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[n-k+1];
        int right = 0;
        for(int i = 0 ; i < n ; i++){
            if(!q.isEmpty() && q.peek() == i-k){
                q.remove();
            }
            while(!q.isEmpty() && numb[q.peekLast()] < numb[i]){
                q.removeLast();
            }
            q.add(i);
            if(i >= k-1){
                res[right++] = numb[q.peek()];
            }
        }
        return res;
    }
    public static void print(int[] res){
        for(int i = 0 ; i < res.length ; i++){
            System.out.print(res[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {6,2,5,4,9,1,3};
        print(WindowMax(arr, 3));
    }
    
}
