package leetcode.jzoffer18;

public class RecursionSumArr {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        // 终止条件 l从0开始 而数组长度从1开始
        if (l == arr.length) return 0;
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        // 高斯求和 ((1+10)*10)/ 2
        // 递归本质是把同一问题缩小化，步骤是分为两步：
        // 1.找出终止条件  2.抽象递归过程
        // 例如  Sum( arr[0...n-1] ) = arr[0] + Sum( arr[1....n-1] )
        //      Sum( arr[1...n-1] ) = arr[1] + Sum( arr[2....n-1] )
        //      Sum( arr[2...n-1] ) = arr[2] + Sum( arr[3....n-1] )
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {};
        System.out.println(sum(arr));
        System.out.println(sum(arr2));
    }
}
