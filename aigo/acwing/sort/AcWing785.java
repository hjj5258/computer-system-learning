package sort;

/**
 * 视频链接 https://www.bilibili.com/video/BV1Jt411P77c?p=30
 * 给定你一个长度为 n 的整数数列。
 * 请你使用快速排序对这个数列按照从小到大进行排序。
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
 * @create 2021/07/15/0:24
 */

import java.util.Scanner;
import java.io.BufferedInputStream;

class AcWing785 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
//        int arr[] = {3, 2, 1, 6, 5};
//        int n = arr.length;
        sort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void sort(int arr[], int l, int r) {
        // 递归终止条件
        if (l >= r) {
            return;
        }
        int i = l - 1, j = r + 1, x = arr[(l + r) / 2];
        // 开始循环头尾指针
        while (i < j) {
            do {
                i++;
            }
            // 如果arr[i]> x 则暂停
            while (arr[i] < x);

            do {
                j--;
            }
            // 如果arr[j]< x 则暂停
            while (arr[j] > x);

            // 经过上面循环, arr[i]左边的数小于x,arr[j]右边的数大于x
            // 如果 两个指针满足 i<j 则需要进行swap,刚好使得一部分有序,然后继续循环直到,i >= j
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        // 此时j指针与i指针 已经互相经过,即满足 i >= j
        // 那么剩余的数组,则继续按照此规则进行排序,l位置 -> j位置(左边数组)
        sort(arr, l, j);

        // 此时j指针与i指针 已经互相经过,即满足 j > i
        // 那么剩余的数组,则继续按照此规则进行排序,j+1位置 -> r位置(右边数组)
        sort(arr, j + 1, r);
    }
}
