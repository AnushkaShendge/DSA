public class partitionList {
    public static class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) {
            this.val = val;
        }
    }
        public static ListNode partition(ListNode head, int x) {
            ListNode lessHead = new ListNode(0); // Dummy head for the list with values < x
            ListNode less = lessHead;
            ListNode greaterHead = new ListNode(0); // Dummy head for the list with values >= x
            ListNode greater = greaterHead;
            
            ListNode current = head;
            
            while (current != null) {
                if (current.val < x) {
                    less.next = current;
                    less = less.next;
                } else {
                    greater.next = current;
                    greater = greater.next;
                }
                current = current.next;
            }
            
            // Connect the two lists
            less.next = greaterHead.next;
            greater.next = null; // Terminate the end of the list for values >= x
            
            return lessHead.next; // The new head of the partitioned list
        }
        public static void printll(partitionList.ListNode ll){
            while(ll != null){
                System.out.print(ll.val + " ");
                ll = ll.next;
            }
        }
        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            ListNode sec = new ListNode(6);
            ListNode third = new ListNode(3);
            ListNode forth = new ListNode(2);
            head.next = sec;
            sec.next = third;
            third.next = forth;
            forth.next = null;
            ListNode ll = partition(head, 3);
            printll(ll);
            
        } 
}
