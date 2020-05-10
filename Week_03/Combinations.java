package Week_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//题目： https://leetcode-cn.com/problems/combinations
public class Combinations {

    /***
     * 回溯法
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine01(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        getAns(1,n, k, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void getAns(int start, int n, int k, ArrayList<Integer> temp, List<List<Integer>> ans) { 
        if(temp.size() == k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= n - (k -temp.size()) + 1; i++) {
            temp.add(i);
            getAns(i+1, n, k, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }


    /*
    递归
    从 n 个数字选 k 个，我们把所有结果分为两种，包含第 n 个数和不包含第 n 个数。这样的话，就可以把问题转换成
    从 n - 1 里边选 k - 1 个，然后每个结果加上 n
    从 n - 1 个里边直接选 k 个。
    把上边两个的结果合起来就可以了。
    */
    public List<List<Integer>> combine02(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        // n - 1 里边选 k - 1 个
        List<List<Integer>> result = combine02(n - 1, k - 1);
        //每个结果加上 n
        result.forEach(e -> e.add(n));
        //把 n - 1 个选 k 个的结果也加入
        result.addAll(combine02(n - 1, k));
        return result;
    }

    
}