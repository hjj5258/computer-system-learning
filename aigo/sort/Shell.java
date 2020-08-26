/**
 * @author hjj
 * @create 2020/8/26 9:42
 */
public class Shell extends Template {
    /**
     * 分组对比 交换 保持小块有序 在插排思想上延申（跳插？）
     * @param a
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 5, 4, 6, 1};
        Shell.show(arr);
        Shell.sort(arr);
        Shell.show(arr);
        System.out.println(isSorted(arr));
    }
}
