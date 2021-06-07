/**
 * @author hjj
 * @create 2021/06/07/19:50
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的中，索引所表示的元素的父亲节点
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的中，索引所表示的元素的左孩子节点
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的中，索引所表示的元素的右孩子节点
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) < 0) {
            data.sawp(index, parent(index));
            index = parent(index);
        }
    }

    private void siftDown(int index) {
//        while (data.get(leftChild(index)).compareTo(data.get(rightChild(index))) > 0) {
//            data.sawp(index, leftChild(index));
//            index = leftChild(index);
//        }

        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            // j+1 就是 leftChild 旁边的 rightChild
            // 如果 rightChild < 数组长度 并且 比较后大于leftChild
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(index);
            // 如果此时index节点 比较后大于 j（可能是left，也可能是right），此时j是两个中最大的那个，则结束循环
            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }

            // 否则进行交换，继续循环
            data.sawp(index, j);
            // 交换完之后 index为j
            index = j;
        }
    }


    public E extractMax() {
        E ret = findMax();
        data.sawp(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    public static void main(String[] args) {

    }

//    private int siftUp(E e, int index) {
//        // 往左走
//        if (e.compareTo(data.get(index)) < 0) {
//            return siftUp(e, leftChild(index));
//        }
//        // 往左走
//        else if (e.compareTo(data.get(index)) > 0) {
//            return siftUp(e, rightChild(index));
//        } else {
//            return index;
//        }
//    }
}
