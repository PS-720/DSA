class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseList(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while(second != null) {
            if(first.val != second.val) {
                reverseList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        Palindrome solution = new Palindrome();

        // Create a linked list for testing
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean isPalin = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + isPalin);
    }
}