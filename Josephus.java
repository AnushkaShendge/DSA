import java.util.LinkedList;
import java.util.Queue;
public class Josephus {
    public static int josephus(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (q.size() > 1) {
            for (int i = 1; i < k; i++) {
                q.add(q.remove());
            }
            q.remove(); 
        }
        int survivor = q.poll();
        return survivor;
    }
    public static void main(String[] args)
    {
        int n = 4, k = 2; 
        int ans = josephus(n, k);
 
        
        System.out.println("The winner is player " + ans);
    }
}

    
