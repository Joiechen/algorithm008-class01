package Week_01;

//题目 https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class mergetwosortedlist {

    //双指针从后向前遍历
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2==null || nums2.length==0) return;
        if (nums1.length < (m+n)) return;
        int p1 = m - 1, p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0){
            nums1[p--] = (nums1[p1]<nums2[p2] ? nums2[p2--]:nums1[p1--]);
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }

}