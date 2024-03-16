public class sumOfNodes {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }
    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(sum(root));
    }
}
    

