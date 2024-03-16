import java.util.ArrayList;

public class DirectedCycleGraph {
    public static class Edge {
        int src;
        int des;

        Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 1));
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, int curr, int[] vis, int[] rec) {
        vis[curr] = 1;
        rec[curr] = 1;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.des] == 1) {
                return true;
            } else if (vis[e.des] != 1) {
                if (isCyclicUtil(graph, e.des, vis, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = 0;
        return false;
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int vertices) {
        int[] vis = new int[vertices];
        int[] rec = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            if (vis[i] != 1) {
                if (isCyclicUtil(graph, i, vis, rec)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int vertices = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        createGraph(graph);
        System.out.println(isCyclic(graph, vertices));
    }
}
