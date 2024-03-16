import java.util.ArrayList;
import java.util.Stack;

public class TopologicalOrder {
    public static class Edge {
        int src;
        int des;

        Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
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

    public static void TopoOrderUtil(int vis[], int curr, Stack<Integer> s, ArrayList<Edge> graph[]) {
        vis[curr] = 1;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.des] != 1) {
                TopoOrderUtil(vis, e.des, s, graph);
            }
        }
        s.push(curr);
    }

    public static void topoOrder(int v, ArrayList<Edge> graph[]) {
        int vis[] = new int[v];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (vis[i] != 1) {
                TopoOrderUtil(vis, i, s, graph);
            }
        }
        while (!s.empty()) {
            System.out.println(s.pop() + " ");
        }
    }

    public static void main(String args[]) {
        int vertices = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertices];

        createGraph(graph);

        topoOrder(vertices, graph);
    }
}