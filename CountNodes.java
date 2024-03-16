public class CountNodes {
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

    public static int nodes(Tree root){
        if(root == null){
            return 0;
        }
        int leftsubtree = nodes(root.left);
        int rightsubtree = nodes(root.right);
        return leftsubtree + rightsubtree + 1;
    }
    public static void main(String args[]){
        Tree root = new Tree(10);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        System.out.println(nodes(root));
    }
}
