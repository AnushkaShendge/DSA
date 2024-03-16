public class stacklist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static class Stack {
        public Node head;

        public boolean isEmpty() {
            return (head == null);
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                return -1; // You can choose a different value to indicate an error
            } else {
                int top = head.data;
                head = head.next;
                return top;
            }
        }

        public int peek() {
            if (isEmpty()) {
                return -1; // You can choose a different value to indicate an error
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println("Top element / Popped element: " + s.peek());
            s.pop();
        }
    }
}
