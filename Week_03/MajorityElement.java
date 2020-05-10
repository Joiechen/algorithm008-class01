package Week_03;


//题目：https://leetcode-cn.com/problems/majority-element
public class MajorityElement {

    public int majorityElement(int[] nums) {
		int count = 1;
		int group = nums[0];
		for (int i = 1; i < nums.length; i++) {
            //当前队伍人数为零，记录现在遇到的人的队伍号
			if (count == 0) {
				count = 1;
				group = nums[i];
				continue;
			}
            //现在遇到的人和当前队伍同组，人数加 1
			if (nums[i] == group) {
				count++;
            //遇到了其他队伍的人，人数减 1
			} else {
				count--;
			}
		}
		return group;
	}

}