public class heightTree {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            right = left = null;
        }  
    }
    public static int MaxHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = MaxHeight(root.left);
        int rightHeight = MaxHeight(root.right);
        int max = Math.max(leftHeight, rightHeight);
        return max + 1;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        
        
        System.out.println(MaxHeight(root));
       // traversal(root2);
    }
}
