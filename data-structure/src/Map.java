/**
 * @author hjj
 * @create 2021/06/06/13:36
 */
public interface Map<K, V> {
    void add(K key, V val);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newVal);

    boolean isEmpty();

    int getSize();
}
