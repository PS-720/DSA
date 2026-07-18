class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class RemoveNodeEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head.next == null)
        //     return null;

        // int size = 0;
        // ListNode temp = head;
        // while(temp != null) {
        //     temp = temp.next;
        //     size++;
        // }

        // if (n == size)
        // return head.next;

        // temp = head;

        // for(int i = 1; i <= size-n-1; i++) {
        //     temp = temp.next;
        // }
        // temp.next = temp.next.next;
        // return head;

        // Optimal approach

        if(head.next == null)
            return null;

        ListNode fast = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null)
            return head.next;

        ListNode slow = head;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        RemoveNodeEnd obj = new RemoveNodeEnd();

        // Create a linked list for testing
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Remove the 2nd node from the end

        ListNode newHead = obj.removeNthFromEnd(head, n);

        // Print the modified linked list
        ListNode current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}