public class SubTree {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            right = left = null;
        }  
    }
    public static boolean isIdentical(Node root , Node subroot){
        if(root == null && subroot == null){
            return true;
        }
        else if(root == null || subroot == null){
            return false;
        }
        return root.data == subroot.data && isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
    }
    public static boolean subtree(Node root , Node subroot){
        if(subroot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(isIdentical(root, subroot)){
            return true;
        }
        return subtree(root.left, subroot) || subtree(root.right, subroot);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        Node subroot = new Node(2);
        subroot.left = new Node(5);
        subroot.right = new Node(1);
        System.out.println(subtree(root,subroot));
       // traversal(root2);
    }
}
