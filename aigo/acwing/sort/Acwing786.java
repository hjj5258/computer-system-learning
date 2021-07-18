package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。
 * <p>
 * 输入格式
 * 第一行包含两个整数 n 和 k。
 * <p>
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整数数列。
 * <p>
 * 输出格式
 * 输出一个整数，表示数列的第 k 小数。
 * <p>
 * 数据范围
 * 1≤n≤100000,
 * 1≤k≤n
 * 输入样例：
 * 5 3
 * 2 4 1 5 3
 * 输出样例：
 * 3
 *
 * @author hjj
 * @create 2021/07/18/17:04
 */
public class Acwing786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] oneLine = br.readLine().split(" ");
        int n = Integer.parseInt(oneLine[0]);
        int k = Integer.parseInt(oneLine[1]);
        String[] twoLine = br.readLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(twoLine[i]);

        quickSort(arr, 0, n - 1);
        if (k > 0) System.out.println(arr[k - 1]);
    }

    private static void quickSort(int arr[], int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1, x = arr[(l + r) / 2];

        while (i < j) {
            do i++;
            while (arr[i] < x);
            do j--;
            while (arr[j] > x);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 递归左边界到 j指针
        quickSort(arr, l, j);
        // 递归 j+1指针到右边界
        quickSort(arr, j + 1, r);

    }
}
