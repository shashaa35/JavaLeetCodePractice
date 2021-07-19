package leetcode;

import java.util.Objects;

public class ReverseKGroup {
    public ListNode reverse(ListNode head) {
        ListNode cur, nxt;
        nxt = head.next;
        head.next = null;
        cur = head;
        while (Objects.nonNull(nxt)) {
            ListNode temp = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = temp;
        }
        return cur;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            count++;
            if (count == k)
                break;
            cur = cur.next;
        }
        if (count < k) return head;
        ListNode post = reverseKGroup(cur.next, k);
        cur.next = null;
        ListNode tailOfThisGroup = head;
        ListNode newHead = reverse(head);
        tailOfThisGroup.next = post;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedListFromArr(new int[]{1, 2, 3, 4, 5});
        ListNode.printList(head);
        ReverseKGroup obj = new ReverseKGroup();
        head = obj.reverse(head);
        ListNode.printList(head);
        head = obj.reverse(head);
        ListNode.printList(head);
        head = obj.reverseKGroup(head, 2);
        ListNode.printList(head);
    }
}
