package leetcode.jzoffer18;

public class Solution {
    public static ListNode deleteNode(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return null;
        ListNode preNode = head;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else
                preNode = preNode.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        System.out.println(deleteNode(listNode, 5));
    }
}
