import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class revelCardQueue {
    public static int[] revelCard(int arr[]){
        Queue<Integer> q = new LinkedList<>();
        int ans[] = new int[arr.length];
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            q.add(i);
        }
        for(int i = 0 ; i < arr.length ; i++){
            ans[q.remove()] = arr[i];
            if(!q.isEmpty()){
                q.add(q.remove());
            }
        }
        return ans;
    
}
public static void main(String args[]){
        int arr[] = { 17 , 13 , 11 , 2 , 3 , 5 , 7};
        int result[] = revelCard(arr);
        System.out.println("Arrangement in array to revel in asending order is :" +Arrays.toString(result));
    }
    
}
