/**
 * 链表队列（先进先出）
 *
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public LinkedListQueue.Node next;

        public Node(E e, LinkedListQueue.Node next) {
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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enQueue(E e) {
        Node addNode = new Node(e);
        if (tail != null) {
            tail.next = addNode;
            tail = addNode;
        } else {
            tail = addNode;
            head = tail;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue form an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (head != null) {
            return head.e;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node temp = head;
        str.append("head:");
        while (temp != null) {
            str.append(temp + "->");
            temp = temp.next;
        }
        str.append("NULL");
        str.append("\n tail:" + tail);
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enQueue(1);
        linkedListQueue.enQueue(2);
        linkedListQueue.enQueue(3);
        System.out.println("linkedListQueue.getFront():" + linkedListQueue.getFront());
        System.out.println(linkedListQueue.toString());
        System.out.println("deQueue():" + linkedListQueue.deQueue());
        System.out.println(linkedListQueue.toString());
        System.out.println("deQueue():" + linkedListQueue.deQueue());
        System.out.println(linkedListQueue.toString());
        System.out.println("deQueue():" + linkedListQueue.deQueue());
        // error
        System.out.println(linkedListQueue.toString());
    }
}
