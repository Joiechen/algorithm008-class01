package Week_02;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    //时间复杂度O(n):其中n为数组nums的长度；线性遍历nums占用O(N);
    //空间复杂度O(k): 双端队列deque中最多同时存储k个元素
    public static int[] maxSlidingWindow(int[] nums, int k) {
    if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst(); 
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) deque.removeLast();
            deque.addLast(nums[j]);
            if(i >= 0) res[i] = deque.peekFirst();
        }
        return res;
    }



    public static void main(String[] args) {
        int[] test1 = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(test1,3);
        for(int i=0;i<res.length;i++){
          System.out.println(res[i]);
        }
    }

}