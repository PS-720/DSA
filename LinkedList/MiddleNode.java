class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class MiddleNode {
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
            count++;
        }
        count = (count/2) + 1;
        temp = head;
        for(int i = 1; i < count; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public static void main(String[] args) {
        MiddleNode ob = new MiddleNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode middle = ob.middleNode(head);
        System.out.println("Middle node value: " + middle.val);
    }
}