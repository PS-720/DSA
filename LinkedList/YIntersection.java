class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class YIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2)
                return temp1;

            if(temp1 == null)
                temp1 = headB;
            if(temp2 == null)
                temp2 = headA;
        }
        return temp1;
    }
    public static void main(String[] args) {
        YIntersection yIntersection = new YIntersection();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        headA.next.next = intersection;
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        ListNode result = yIntersection.getIntersectionNode(headA, headB);
        if(result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}