package leetcode.subject350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author hjj
 * @create 2021/06/07/11:15
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums1) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                arr.add(i);
                int count = map.get(i) - 1;
                if (count == 0) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        int[] rst = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            rst[i] = arr.get(i);
        }
        return rst;
    }
}
