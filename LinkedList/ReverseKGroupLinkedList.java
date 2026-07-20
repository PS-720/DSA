import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class ReverseKGroupLinkedList {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {
            ListNode KthNode = getKthNode(temp, k);

            if (KthNode == null) {
                if (prevNode != null)
                    prevNode.next = temp;
                break;
            }

            ListNode nextNode = KthNode.next;
            KthNode.next = null;

            reverse(temp);

            if (temp == head) {
                head = KthNode;
            } else {
                prevNode.next = KthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }

    public ListNode getKthNode(ListNode temp, int k) {
        k--;

        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }

        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

public class Main {

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Linked List is empty.");
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        ReverseKGroupLinkedList obj = new ReverseKGroupLinkedList();

        System.out.print("Original Linked List: ");
        printList(head);

        head = obj.reverseKGroup(head, k);

        System.out.print("Linked List after reversing in groups of " + k + ": ");
        printList(head);

        sc.close();
    }
}