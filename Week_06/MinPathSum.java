package Week_06;

//题目：https://leetcode-cn.com/problems/minimum-path-sum/
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(j == 0){ //只能从上边
                    dp[j] = dp[j];
                } else if(i == 0){ //只能从左边
                    dp[j] = dp[j-1];
                }else{
                    dp[j] = Math.min(dp[j], dp[j-1]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n-1];
    }
}