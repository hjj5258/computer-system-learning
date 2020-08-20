import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author hjj
 * @create 2020/8/20 10:00
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if ("Insertion".equals(alg)) {
            Insertion.sort(a);
        }
        if ("Selection".equals(alg)) {
            Selection.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
//        String alg1 = args[0];
//        String alg2 = args[1];
//        int n = Integer.valueOf(args[2]);
//        int t = Integer.valueOf(args[3]);
        // 选择排序
        String alg1 = "Selection";
        // 插入排序
        String alg2 = "Insertion";
        // 数据长度
        int n = 2048;
        // 重复次数
        int t = 10;
        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);
        System.out.println("t1:" + t1);
        System.out.println("t2:" + t2);
    }
}
