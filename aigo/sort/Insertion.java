/**
 * @author hjj
 * @create 2020/8/17 15:47
 */
public class Insertion extends Template {
    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            // 左边始终保持是有序的
            // j 代表当前，如果小于j-1就交换 然后在j-- 此时已经交换
            // ex：原 a[j]=4 a[j-1]=9 a[j]=9 a[j-1]=4; j--此时a[j]=4 a[j-1]=xxx
            // 其实就相当于后一位比较前一位 如果小于就换位 然后讲j指向换位后的左边 原j-1 现j 然后在向左边进行比较 直到 j>0 && less(a[j], a[j - 1])
            // 然后向左对比 循环结束 跳出该层级 i++ 向右挪位
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
//                System.out.println("a[j]:" + a[j] + "---》" +"a[j-1]:" + a[j - 1]);
                exch(a, j, j - 1);
//                Insertion.show(a);
            }
        }
    }

//    public static void sort(Comparable[] a) {
//        int length = a.length;
//        for (int i = 1; i < length; i++) {
//            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
//                exch(a, j, j - 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 5, 4, 6, 1};
        Insertion.show(arr);
        Insertion.sort(arr);
//        Insertion.show(arr);

        System.out.println(isSorted(arr));
    }
}
