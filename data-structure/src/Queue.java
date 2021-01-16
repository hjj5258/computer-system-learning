/**
 * First In First Out 队列先进先出
 * @param <E>
 */
public interface Queue<E> {
    /**
     * 入队列
     * @param e
     */
    void enQueue(E e);

    /**
     * 出队列
     * @return
     */
    E deQueue();

    /**
     * 队列首
     * @return
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}
