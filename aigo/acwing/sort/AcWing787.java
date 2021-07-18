package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 视频链接 https://www.bilibili.com/video/BV1Jt411P77c?p=25
 * 给定你一个长度为 n 的整数数列。
 * <p>
 * 请你使用归并排序对这个数列按照从小到大进行排序。
 * <p>
 * 并将排好序的数列按顺序输出。
 * <p>
 * 输入格式
 * 输入共两行，第一行包含整数 n。
 * <p>
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。
 * <p>
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 * <p>
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 *
 * @author hjj
 * @create 2021/07/18/15:37
 */
public class AcWing787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int tmpArr[] = new int[r - l + 1];
        // mid下标
        int mid = (l + r) / 2;

        // 递归左边界到 mid
        mergeSort(arr, l, mid);
        // 递归 mid+1到右边界
        mergeSort(arr, mid + 1, r);

        int k = 0, i = l, j = mid + 1;

        // 如果i、j自增还没有超过 mid、r
        while (i <= mid && j <= r) {
            // 比较两个下标值，并放入临时数组中，完成指针向前移动
            if (arr[i] <= arr[j])
                tmpArr[k++] = arr[i++];
            else
                tmpArr[k++] = arr[j++];
        }

        // 如果上面条件已经满足，则剩余的数组需要拼接到已经排好序的数组上
        // 有两种情况，剩余右边数组，剩余左边数组
        while (i <= mid) tmpArr[k++] = arr[i++];
        while (j <= r) tmpArr[k++] = arr[j++];

        // 将临时数组赋值给元数组，完成结果
        for (i = l, j = 0; i <= r; i++, j++)
            arr[i] = tmpArr[j];
    }
}
