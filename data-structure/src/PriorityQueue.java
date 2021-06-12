/**
 * @author hjj
 * @create 2021/06/12/19:21
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> data;

    public PriorityQueue() {
        data = new MaxHeap<>();
    }

    public PriorityQueue(int capacity) {
        data = new MaxHeap<>(capacity);
    }


    @Override
    public void enQueue(E e) {
        data.add(e);
    }

    @Override
    public E deQueue() {
        return data.extractMax();
    }

    @Override
    public E getFront() {
        return data.findMax();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


}
