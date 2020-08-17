/**
 * @author hjj
 * @create 2020/8/17 10:43
 */
public class Selection extends Template {
    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                // 最小的标志位 a[0]
                int min = i;
                // ex less(a[1], a[0]) a[1] 是否小于 a[0]
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 2, 5, 4, 9};
        Selection.show(arr);
        Selection.sort(arr);
        Selection.show(arr);

        System.out.println(isSorted(arr));
    }
}
