package leetcode.subject347;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author hjj
 * @create 2021/06/12/19:50
 */
class Solution {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        // k为元素，v为频率
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (treeMap.containsKey(num)) {
                treeMap.put(num, treeMap.get(num) + 1);
            } else {
                treeMap.put(num, 1);
            }
        }

//        因为存储的是元素而非频率，则需要使用到treeMap.get()，而比较器返回的结果则是 a - b
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> treeMap.get(a) - treeMap.get(b));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(treeMap::get));
        for (Integer key : treeMap.keySet()) {
            // 如果还没有超过k
            if (queue.size() < k) {
                queue.add(key);
            }
            // 取出频率进行比较
            else if (treeMap.get(key).compareTo(treeMap.get(queue.peek())) > 0) {
                queue.remove();
                queue.add(key);
            }
        }

        for (int i = 0; i < k; i++) {
            ret[i] = queue.remove();
        }

        return ret;
    }
}
