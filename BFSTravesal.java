import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class BFSTravesal {
    public static void bfs(int[] visited, int[][] a, int start) {
        Queue<Integer> q = new LinkedList<>();
        int node;
        System.out.print(start);
        visited[start] = 1;
        q.add(start);
        while (!q.isEmpty()) {
            node = q.remove();
            for (int j = 0; j < a.length; j++) {
                if (a[node][j] == 1 && visited[j] == 0) {
                    System.out.print(j);
                    visited[j] = 1;
                    q.add(j);
                }

            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Node");
        int numNode = sc.nextInt();

        int visited[] = new int[numNode];
        int a[][] = new int[numNode][numNode];
        System.out.println("Enter the adjecency Matrix");
        for (int i = 0; i < numNode; i++) {
            for (int j = 0; j < numNode; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the Starting vertix of traversal");
        int start = sc.nextInt();
        /*
         * for (int i = 0; i < numNode; i++) {
         * if (visited[i] == 0) {
         * bfs(visited, a, i);
         * }
         * }not connected graphs : 0 - 1 - 2
         * 3 - 4
         */
    }
}
