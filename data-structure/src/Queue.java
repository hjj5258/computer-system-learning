/**
 * First In First Out 队列先进先出
 * @param <E>
 */
public interface Queue<E> {
    void enQueue(E e);

    E deQueue();

    /**
     * 队列首
     * @return
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}
