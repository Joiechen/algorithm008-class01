package Week_06;

//题目：https://leetcode-cn.com/problems/edit-distance/
//参考解题：https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-mian-shi-ti-xiang-jie-by-labuladong/
public class MinDistance {

    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 如果其中一个字符串为空串，那么操作数就为另外一个字符串的长度
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果两个字符串最后一个字母相同，那么把两个字符串最后的一个字母都去掉，最小操作数的结果不变
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }

    // 三个数的最小值
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    
}