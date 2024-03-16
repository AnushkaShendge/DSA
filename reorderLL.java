public class reorderLL {
    static Node head;
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public static Node mid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void mergeList(Node firstPart, Node secPart) {
        Node firstPartNext = firstPart.next;
        Node secPartNext = secPart.next;

        firstPart.next = secPart;
        secPart.next = firstPartNext;

        firstPart = firstPartNext;
        secPart = secPartNext;
    }
    
    public static void reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return; // No need to reorder for small lists
        }

        // Find the middle of the linked list
        Node middle = mid(head);

        // Reverse the second half of the linked list
        Node secondHalf = reverse(middle.next);
        middle.next = null; // Break the list into two halves

        // Merge the two halves back together
        mergeList(head, secondHalf);
    }
    
    public static void main(String[] args) {
        head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        head.next = sec;
        sec.next = third;
        third.next = fourth;

        reorderList(head);

        // Print the reordered list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
