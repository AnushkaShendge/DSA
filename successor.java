public class successor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node successor;
    static Node predecessor;

    public static void findSuccessorPredecessor(Node root, int key) {
        if (root == null) {
            return;
        }

        // If the key is found
        if (root.data == key) {
            // Find the in-order successor
            if (root.right != null) {
                Node current = root.right;
                while (current.left != null) {
                    current = current.left;
                }
                successor = current;
            }

            // Find the in-order predecessor
            if (root.left != null) {
                Node current = root.left;
                while (current.right != null) {
                    current = current.right;
                }
                predecessor = current;
            }
            return;
        }

        // If key is smaller, move to the left subtree
        if (key < root.data) {
            successor = root;
            findSuccessorPredecessor(root.left, key);
        }
        // If key is larger, move to the right subtree
        else {
            predecessor = root;
            findSuccessorPredecessor(root.right, key);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int key = 40;
        findSuccessorPredecessor(root, key);

        if (successor != null) {
            System.out.println("Successor of " + key + " is " + successor.data);
        } else {
            System.out.println("No successor found for " + key);
        }

        if (predecessor != null) {
            System.out.println("Predecessor of " + key + " is " + predecessor.data);
        } else {
            System.out.println("No predecessor found for " + key);
        }
    }
}
