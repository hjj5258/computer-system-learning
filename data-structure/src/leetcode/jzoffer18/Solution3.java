package leetcode.jzoffer18;

/**
 * 递归删除链表符合val的元素
 *
 * @author hjj
 * @create 2021/06/01/13:52
 */
public class Solution3 {
    /**
     * 自己写的
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode1(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val)
            return deleteNode1(head.next, val);

        head.next = deleteNode1(head.next, val);
        return head;
    }

    /**
     * 视频中的
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        head.next = deleteNode2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(9);
        ListNode listNode1 = deleteNode2(listNode, 5);
        System.out.println(listNode1);
    }
}
