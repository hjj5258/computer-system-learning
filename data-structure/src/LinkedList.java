/**
 * 线性结构之链表
 *
 * @param <E>
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            if (e != null) {
                return e.toString();
            }
            return "";
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新元素
     *
     * @param e
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        add(0, e);
    }

    /**
     * 在链表尾部添加新元素
     *
     * @param e
     */
    public void addLast(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
//                    Node node = new Node(e);
//                    node.next = prevNode.next;
//                    prevNode.next = node;
        }
        prevNode.next = new Node(e, prevNode.next);
        size++;
    }

    /**
     * 获取索引对应E
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur == null ? null : cur.e;
    }

    /**
     * 获取最后一个对应E
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取最前一个对应E
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        if (cur != null) {
            cur.e = e;
        }
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        // do gc
        delNode.next = null;
        size--;

        return delNode.e;
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            // 每次移动
            prev = prev.next;
        }

        // 如果不等于null 说明找到了
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node temp = dummyHead.next;
        while (temp != null) {
            str.append(temp + "->");
            temp = temp.next;
        }
        str.append("NULL");
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
//        for (int i = 0; i < 5; i++) {
//            linkedList.addFirst(i);
//        }
//        System.out.println(linkedList.toString());
//
//        System.out.println("add operation");
//        linkedList.add(0, 5);
//        System.out.println(linkedList.toString());
//        System.out.println("add last operation");
//        linkedList.addLast(7);
//        System.out.println(linkedList.toString());
//        System.out.println("get operation");
//        Integer getNode = linkedList.get(0);
//        System.out.println(getNode == null ? "null" : getNode.toString());
//
//        System.out.println("set operation");
//        linkedList.set(6, 10);
//        System.out.println(linkedList.toString());
//        System.out.println("contains operation");
//        System.out.println(linkedList.contains(-1));
//
//        linkedList.remove(2);
//        System.out.println("remove   operation");
//        System.out.println(linkedList.toString());
//
//        linkedList.removeLast();
//        System.out.println("removeLast   operation");
        System.out.println(linkedList.toString());
    }
}
