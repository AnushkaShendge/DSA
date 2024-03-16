public class palindrome {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node rev(Node n){
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
    public static Node mid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean isPalindrome(Node head){
        Node start = head;
        Node middle = mid(head);
        Node reverse = rev(middle.next);
        while(reverse != null){
            if(start.data != reverse.data){
                return false;
            }
            start = start.next;
            reverse = reverse.next;
        }
        return true;
    }
    public static void main(String args[]){
        Node head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(2);
        Node forth = new Node(1);
        head.next = sec;
        sec.next = third;
        third.next = forth;
        System.out.println("Given Linked list is Palindrome : " +isPalindrome(head));
        
    }

    
}
