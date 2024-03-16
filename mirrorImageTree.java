public class mirrorImageTree {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            right = left = null;
        }
    }
    public static Node mirrorImage(Node root){
        if(root == null){
            return null;
        }
        Node root2 = new Node(root.data);
        root2.left = mirrorImage(root.right);
        root2.right = mirrorImage(root.left);
        return root2;
    }
    public static void traversal(Node root){
        if(root == null){
            return;
        }
        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        Node root2 = mirrorImage(root);
        traversal(root);
        System.out.println();
        traversal(root2);
    }
    
}
