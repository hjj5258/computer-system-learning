import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = new int[capacity];
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
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 为指定位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (data.length == size) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 是否包含该元素
     *
     * @param e
     * @return
     */
    public boolean contains(int e) {
        boolean res = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
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
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public int find(int e) {
        int res = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                res = i;
                break;
            }
        }
        return res;
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
