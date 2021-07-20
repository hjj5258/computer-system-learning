package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个按照升序排列的长度为 n 的整数数组，以及 q 个查询。
 * <p>
 * 对于每个查询，返回一个元素 k 的起始位置和终止位置（位置从 0 开始计数）。
 * <p>
 * 如果数组中不存在该元素，则返回 -1 -1。
 * <p>
 * 输入格式
 * 第一行包含整数 n 和 q，表示数组长度和询问个数。
 * <p>
 * 第二行包含 n 个整数（均在 1∼10000 范围内），表示完整数组。
 * <p>
 * 接下来 q 行，每行包含一个整数 k，表示一个询问元素。
 * <p>
 * 输出格式
 * 共 q 行，每行包含两个整数，表示所求元素的起始位置和终止位置。
 * <p>
 * 如果数组中不存在该元素，则返回 -1 -1。
 * <p>
 * 数据范围
 * 1≤n≤100000
 * 1≤q≤10000
 * 1≤k≤10000
 * 输入样例：
 * 6 3
 * 1 2 2 3 3 4
 * 3
 * 4
 * 5
 * 输出样例：
 * 3 4
 * 5 5
 * -1 -1
 *
 * @author hjj
 * @create 2021/07/20/23:35
 */
public class AcWing789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] oneLine = br.readLine().split(" ");
        int n = Integer.parseInt(oneLine[0]);
        int q = Integer.parseInt(oneLine[1]);


        String[] twoLine = br.readLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(twoLine[i]);
        }

        for (int i = 0; i < q; i++) {
            String readLine = br.readLine();
            if (readLine == null || "".equals(readLine)) return;

            int target = Integer.parseInt(readLine);
            int x = target;

            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                // 如果区间中间位置数值 大于 目标值，右边界将等于 mid 位置，即 l -> mid
                if (arr[mid] >= x) r = mid;
                    // 否则左边界将等于 mid+1，即 mid+1 -> r
                else l = mid + 1;
            }

            // 如果 l >= r && arr[l] != x，则未找到
            if (arr[l] != x) {
                System.out.println("-1 -1");
            }
            // 如果相等，则找到该位置输出数据 l下标
            else {
                System.out.print(l + " ");

                // 因为题目中限定了至多2个一样的元素，继续寻找数组中剩余的终止位置
                int l1 = 0, r2 = n - 1;
                while (l1 < r2) {
                    int mid = (l1 + r2 + 1) >> 1;
                    if (arr[mid] <= x) l1 = mid;
                    else r2 = mid - 1;
                }
                System.out.print(l1 + "\n");
            }
        }
    }
}
