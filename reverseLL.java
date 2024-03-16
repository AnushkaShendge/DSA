public class reverseLL {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node rev(Node head){
        Node curr = head;
        Node prv = null;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prv;
            prv = curr;
            curr = temp;
        }
        return prv;
    }
    public static void traversal(Node p){
        while( p != null){
            System.out.println("Elements in reverse :" +p.data);
            p = p.next;
        }
    }
    public static void main(String args[]){
        Node head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        head.next = sec;
        sec.next = third;
        third.next = forth;
        head = rev(head);
        traversal(head);
    }
    
}
