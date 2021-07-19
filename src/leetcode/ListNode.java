package leetcode;

import java.util.Objects;

/**
 * Defintion of singly linked list
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getLinkedListFromArr(int[] arr) {
        ListNode head = new ListNode();
        ListNode cur;
        cur = head;
        for (int e:arr) {
            ListNode temp = new ListNode(e);
            cur.next = temp;
            cur = temp;
        }
        return head.next;
    }

    public static void printList(ListNode head) {
        while (Objects.nonNull(head)) {
            System.out.printf("%d ",head.val);
            head = head.next;
        }
        System.out.println();
    }
}
