public class preorderTreeFormation {
    public static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node Tree(int Node[]) {
            idx++;
            if (Node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(Node[idx]);
            newNode.left = Tree(Node);
            newNode.right = Tree(Node);

            return newNode;
        }

    }

    public static void traversal(Node root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        System.out.println(root.data + " ");
        traversal(root.right);
    }

    public static void main(String args[]) {
        int Node[] = { 1, 2, 4, -1, -1, 5, -1, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.Tree(Node);
        System.out.println(root.data);
        traversal(root);

    }
}