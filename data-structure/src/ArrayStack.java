public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;
    private int size;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        this(10);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            str.append(array.get(i));
            if (i != array.getSize() - 1) {
                str.append(",");
            }
        }
        str.append("] top");
        return str.toString();
    }
}
