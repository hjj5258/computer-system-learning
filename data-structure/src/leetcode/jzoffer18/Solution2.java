package leetcode.jzoffer18;

public class Solution2 {
    public static ListNode deleteNode(ListNode head, int val) {
        // 虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode preNode = dummyHead;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else
                preNode = preNode.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        ListNode listNode1 = deleteNode(listNode, 5);
        System.out.println(listNode1);
    }
}
