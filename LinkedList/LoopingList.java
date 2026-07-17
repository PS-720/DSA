class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class LoopingList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        LoopingList ob = new LoopingList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // Creating a loop for testing
        head.next.next.next.next.next = head.next; // 5 -> 2

        boolean hasCycle = ob.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}