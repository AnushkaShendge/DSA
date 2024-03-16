import java.util.Stack;

public class postfixExpTreeFormUsingStack {
    static class Tree {
        int data;
        Tree right;
        Tree left;

        Tree(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }

    public static Stack<Tree> s = new Stack<>();

    public static Tree treeFormation(String postfix) {
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (!isOperator(c)) {
                Tree t = new Tree(c - '0');
                s.push(t);
            } 
            else {
                Tree t = new Tree(c);
                t.right = s.pop();
                t.left = s.pop();
                s.push(t);
            }
        }
        return s.pop();
    }

    public static void traversal(Tree root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (isOperator((char) root.data)) {
            System.out.print((char) root.data + " ");
        }
        else{
            System.out.print(root.data + " ");
        }
        traversal(root.right);
    }

    public static int expTree(Tree root) {
        if (root == null) {
            return 0;
        }
        if (!isOperator((char) root.data)) {
            return root.data;
        }
        int leftVal = expTree(root.left);
        int rightVal = expTree(root.right);
        switch ((char) root.data) {
            case '+':
                return leftVal + rightVal;
            case '-':
                return leftVal - rightVal;
            case '/':
                if (rightVal != 0) {
                    return leftVal / rightVal;
                } else {
                    System.out.println("Can't divide by 0");
                    return 0;
                }
            case '*':
                return leftVal * rightVal;
            case '^':
                return (int) Math.pow(leftVal, rightVal);
            default:
                return 0;
        }
    }

    public static void main(String args[]) {
        String postfix = "12*43++";
        Tree root = treeFormation(postfix);
        traversal(root);
        System.out.println();
        System.out.println("Expression evaluation using tree: " + expTree(root));
    }
}
