import java.util.Scanner;

public class DFSTraversal {
    public static void dfs(int[] visited, int[][] a ,int start){
        System.out.print(start);
        visited[start] = 1 ;
        for(int i = 0 ; i < a.length ; i++){
            if(a[start][i] == 1  &&  visited[i] == 0){
                dfs(visited, a, i);
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Node");
        int numNode = sc.nextInt();

        int visited[] = new int[numNode];
        int a[][] = new int[numNode][numNode];
        System.out.println("Enter the adjecency Matrix");
        for(int i = 0 ; i < numNode ; i++){
            for(int j = 0 ; j < numNode ; j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the Starting vertix of traversal");
        int start = sc.nextInt();
        dfs(visited, a , start);
    }
}
