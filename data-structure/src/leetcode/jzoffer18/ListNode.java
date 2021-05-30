package leetcode.jzoffer18;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode curNode = this;
        while (curNode != null) {
            stringBuilder.append(curNode.val + "->");
            curNode = curNode.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
