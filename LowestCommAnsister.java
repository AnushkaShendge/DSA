public class LowestCommAnsister {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node LCA(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (a == root.data || b == root.data) {
            return root;
        }
        Node left = LCA(root.left, a, b);
        Node right = LCA(root.right, a, b);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int a = 40, b = 20;
        Node lcaNode = LCA(root, a, b);

        if (lcaNode != null) {
            System.out.println("Lowest Common Ancestor: " + lcaNode.data);
        } else {
            System.out.println("One or both nodes not present in the tree");
        }
    }
}
