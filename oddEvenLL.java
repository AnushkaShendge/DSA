public class oddEvenLL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node oddeven(Node head){
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void printll(Node p){
        while(p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        head.next = sec;
        sec.next = third;
        third.next = forth;
        forth.next = null;
        Node ll = oddeven(head);
        printll(ll);
        
    } 
}
