public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取数组元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向最后添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 为指定位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (data.length == size) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 是否包含该元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        boolean res = false;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * 删除第一个元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // do gc

        // 当个数到达容量的1/4时，进行缩容 lazy
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public int find(E e) {
        int res = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                res = i;
                break;
            }
        }
        return res;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                str.append(data[i]);
            } else {
                str.append(data[i] + ",");
            }
        }
        str.append("]");
        return str.toString();
    }

}
