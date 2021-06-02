/**
 * @author hjj
 * @create 2021/06/02/21:14
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains();

    int getSize();

    boolean isEmpty();
}
