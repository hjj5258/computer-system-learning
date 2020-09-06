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
            return e.toString();

        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
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

        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
//                    Node node = new Node(e);
//                    node.next = prevNode.next;
//                    prevNode.next = node;
            }
            prevNode.next = new Node(e, prevNode.next);
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            str.append(temp.toString());
            if (i != size - 1) {
                str.append("->");
            }
            temp = temp.next;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList.toString());

        System.out.println("add operation");
        linkedList.add(1,5);
        System.out.println(linkedList.toString());
    }
}
