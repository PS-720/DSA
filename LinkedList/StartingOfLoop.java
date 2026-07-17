class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class StartingOfLoop {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        StartingOfLoop solution = new StartingOfLoop();

        // Create a linked list with a loop for testing
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a loop

        ListNode loopStart = solution.detectCycle(head);
        if (loopStart != null) {
            System.out.println("Loop starts at node with value: " + loopStart.val);
        } else {
            System.out.println("No loop detected.");
        }
    }
}