import javax.swing.tree.TreeNode;

public class diameterofLongestPathOfTree {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            right = left = null;
        }  
    }
    public static int diameterOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Calculate the diameter through the root and recursively for left and right subtrees
        int diameterThroughRoot = leftHeight + rightHeight + 1;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        // Return the maximum of these values
        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int max = Math.max(leftHeight, rightHeight);
        return max + 1;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        
        System.out.println(diameterOfBinaryTree(root));
       // traversal(root2);
    }
}
