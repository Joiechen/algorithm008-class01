package Week_02;

//题目 面试题：https://leetcode-cn.com/problems/sort-colors/
public class SortColors {

    //内存消耗比较多，采取了分区快速排序方式
    // all in [0, zero] = 0
    // all in (zero, i) = 1
    // all in (two, len - 1] = 2
    public void sortColors01(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // 为了保证初始化的时候 [0, zero] 为空，设置 zero = -1，
        // 所以下面遍历到 0 的时候，先加，再交换
        int zero = -1;

        // 为了保证初始化的时候 (two, len - 1] 为空，设置 two = len - 1
        // 所以下面遍历到 2 的时候，先交换，再减
        int two = len - 1;
        int i = 0;

        // 当 i == two 的时候，还有一个元素还没有看，
        // 因此，循环可以继续的条件是 i <= two

        while (i <= two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //官方解法比较巧妙， 使用前后指针加一个当前指针进行位置互换，更好理解
    public void sortColors02(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;
    
        int tmp;
        while (curr <= p2) {
          if (nums[curr] == 0) {
            // 交换第 p0个和第curr个元素
            // i++，j++
            tmp = nums[p0];
            nums[p0++] = nums[curr];
            nums[curr++] = tmp;
          }
          else if (nums[curr] == 2) {
            // 交换第k个和第curr个元素
            // p2--
            tmp = nums[curr];
            nums[curr] = nums[p2];
            nums[p2--] = tmp;
          }
          else curr++;
        }
      }


}