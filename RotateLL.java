public class RotateLL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node rotate(Node head , int k){
        if(head == null || k == 0){
            return head;
        }
        Node tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        k = k % len;
        if(k == 0){
            return head;
        }
        Node newTail = head;
        for(int i = 0 ; i < len - k - 1 ; i++){
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
        
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
        Node ll = rotate(head, 2);
        printll(ll);
        
    } 
}
