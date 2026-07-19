class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode left = head;
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;

        left = sortList(left);
        right = sortList(right);
        return mergeList(left, right);
    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode t1 = head1;
        ListNode t2 = head2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                temp.next = t1;
                t1 = t1.next;
            }
            else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        // To attach remaining nodes
        temp.next = (t1 != null) ? t1 : t2;

        return dummy.next;
    }
    public static void main(String[] args) {
        SortList solution = new SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode result = solution.sortList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}