package Week_02;

import java.util.HashMap;

//题目，两数之和：https://leetcode-cn.com/problems/two-sum/description/
public class TwoSum {

    //hashmap，时间复杂度：O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.get(dif) != null) {
                res[0] = map.get(dif);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }


}