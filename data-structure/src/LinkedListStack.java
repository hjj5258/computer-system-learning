/**
 * 链表实现栈
 * 先进后出
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> data;

    public LinkedListStack() {
        data = new LinkedList<>();
    }

    /**
     * 返回大小
     *
     * @return
     */
    @Override
    public int getSize() {
        if (data == null) {
            return 0;
        }
        return data.getSize();
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (data == null) {
            return true;
        }
        return data.isEmpty();
    }

    /**
     * 推入一个元素
     *
     * @param o
     */
    @Override
    public void push(E o) {
        data.addFirst(o);
    }

    /**
     * 取出一个元素
     *
     * @return
     */
    @Override
    public E pop() {
        return data.removeFirst();
    }

    /**
     * 查看并返回栈顶
     *
     * @return
     */
    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("init LinedListStack");
        System.out.println("linedListStack:" + linkedListStack.toString());
        System.out.println("data isEmpty ? " + linkedListStack.isEmpty());
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println("push 1 2 3");
        System.out.println("peek:" + linkedListStack.peek());
        System.out.println("linedListStack:" + linkedListStack.toString());
        System.out.println("pop: " + linkedListStack.pop());
        System.out.println("linedListStack:" + linkedListStack.toString());
        System.out.println("pop: " + linkedListStack.pop());
        System.out.println("linedListStack:" + linkedListStack.toString());
        System.out.println("pop: " + linkedListStack.pop());
        System.out.println("linedListStack:" + linkedListStack.toString());

    }
}
