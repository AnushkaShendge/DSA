import java.util.Stack;
import java.util.ArrayList;

public class graterNextLL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static int[] nxtGreater(Node head) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> val = new ArrayList<>();
        Node curr = head;

        while (curr != null) {
            val.add(curr.data);
            curr = curr.next;
        }

        int ans[] = new int[val.size()];
        for (int i = 0; i < val.size(); i++) {
            while (!s.isEmpty() && val.get(i) > val.get(s.peek())) {
                int idx = s.pop();
                ans[idx] = val.get(i);
            }
            s.push(i);
        }

        // Handle elements without a greater next element
        while (!s.isEmpty()) {
            int idx = s.pop();
            ans[idx] = -1; // or whatever value you want for elements without a greater next element
        }

        return ans;
    }

    public static void traversal(Node p) {
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        head.next = sec;
        sec.next = third;
        third.next = forth;

        int[] ll = nxtGreater(head);
        traversal(head);
        System.out.println();
        for (int val : ll) {
            System.out.print(val + " ");
        }
    }
}
