/**
 * @author hjj
 * @create 2020/8/17 10:20
 */
public class Template {
    /**
     * 对外接口
     *
     * @param a
     */
    public static void sort(Comparable[] a) {

    }

    /**
     * 比较
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                str.append(a[i]);
            } else {
                str.append(a[i] + ",");
            }
        }
        str.append("]");
    }

    /**
     * 检测数组是否有序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
