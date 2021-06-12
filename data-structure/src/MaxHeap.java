import java.util.Arrays;
import java.util.Random;

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

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
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
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parent(index));
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
            data.swap(index, j);
            // 交换完之后 index为j
            index = j;
        }
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }


//    public static void main(String[] args) {
//        int n = 1000000;
//        Random random = new Random();
////        MaxHeap<Integer> heap = new MaxHeap<>();
////        for (int i = 0; i < n; i++) {
////            heap.add(random.nextInt(Integer.MAX_VALUE));
////        }
////
////        int[] arr = new int[n];
////        for (int i = 0; i < n; i++) {
////            arr[i] = heap.extractMax();
////        }
////        for (int i = 1; i < n; i++) {
////            if (arr[i - 1] < arr[i]) {
////                throw new IllegalArgumentException("Error");
////            }
////        }
////        System.out.println("Test MaxHeap completed.");
//
//        Integer[] arr = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = random.nextInt(Integer.MAX_VALUE);
//        }
//
//        System.out.println("IsHeapify false : " + testHeap(arr, false) + " s");
//        System.out.println("IsHeapify true : " + testHeap(arr, true) + " s");
//    }
//
//    public static double testHeap(Integer[] testData, boolean isHeapify) {
//        MaxHeap<Integer> maxHeap;
//        long startTime = System.nanoTime();
//        if (isHeapify == true) {
//            maxHeap = new MaxHeap<>(testData);
//        } else {
//            maxHeap = new MaxHeap<>(testData.length);
//            for (Integer num : testData) {
//                maxHeap.add(num);
//            }
//        }
//        long endTime = System.nanoTime();
//
//        int[] arr = new int[testData.length];
//        for (int i = 0; i < testData.length; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//        for (int i = 1; i < testData.length; i++) {
//            if (arr[i - 1] < arr[i]) {
//                throw new IllegalArgumentException("Error");
//            }
//        }
//        System.out.println("Test MaxHeap completed.");
//        return (endTime - startTime) / 1000000000.0;
//    }


    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else {
            maxHeap = new MaxHeap<>(testData.length);
            for (int num : testData)
                maxHeap.add(num);
        }

        long endTime = System.nanoTime();
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < testData.length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) throws InterruptedException {

        int n = 10000000;

        Random random = new Random();
        Integer[] testData1 = new Integer[n];
        for (int i = 0; i < n; i++)
            testData1[i] = random.nextInt(Integer.MAX_VALUE);

        Integer[] testData2 = Arrays.copyOf(testData1, n);

        double time1 = testHeap(testData1, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData2, true);
        System.out.println("With heapify: " + time2 + " s");
    }

}
