public class deleteNthNodeFromEnd {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node delete(Node head , int n){
        Node dummy = new Node(0);
        dummy.next = head;
        Node p = dummy;
        Node q = dummy;
        for(int i = 0 ; i < n+1 ; i++){
            p = p.next;
        }
        while(p != null){
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return dummy.next;
    }
    public static void traversal(Node p){
        while( p != null){
            System.out.println("Linked list :" +p.data);
            p = p.next;
        }
    }
    public static void main(String args[]){
        Node head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        
        Node Forth = new Node(4);
        Node fifth = new Node(5);
        head.next = sec;
        sec.next = third;
        third.next = Forth;
        Forth.next = fifth;
        System.out.println("Original LL :");
        traversal(head);
        head = delete(head, 2);
        System.out.println("LL after Deletion :");
        traversal(head);

    }
    
}
