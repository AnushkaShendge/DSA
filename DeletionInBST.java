public class DeletionInBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node BST(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = BST(root.left, key);
        } else if (key > root.data) {
            root.right = BST(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMinValue(root.right);
            root.right = BST(root.right, root.data);
        }

        return root;
    }

    public static int findMinValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void traversal(Node root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
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
        root = BST(root, key);
        traversal(root);
    }
}
