public class postTraversal {
    public static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static void traversal(Tree root){
        if(root == null){
            return ;
        }
        traversal(root.left);
        traversal(root.right);
        System.out.println(root.data+ " ");
    }
    public static void main(String args[]){
        Tree root = new Tree(10);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        traversal(root);
    }
}
