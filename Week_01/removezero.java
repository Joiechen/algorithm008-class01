package Week_01;

//题目 https://leetcode-cn.com/problems/move-zeroes
public class removezero {

    public void removeZeros(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

}