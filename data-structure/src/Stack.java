/**
 * Last In First Out(LIFO)
 * 先进后出
 */
public interface Stack<E> {

    /**
     * 返回大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 推入一个元素
     * @param e
     */
    void push(E e);

    /**
     * 取出一个元素
     * @return
     */
    E pop();

    /**
     * 查看并返回栈顶
     * @return
     */
    E peek();
}
