package Week_06;

//题目：https://leetcode-cn.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // dp[i]: longestValidParentheses end at pos i
        int len = s.length();
        int dp[] = new int[len];
        int res=0;
        for(int i=0;i<len;i++) {
            if(s.charAt(i)=='(') dp[i]=0; // can't end with '('
            else {
                if(i==0) dp[i]=0;
                // condition 1: ...()
                else if(s.charAt(i-1)=='(') {
                    if(i==1) dp[i]=2;
                    else dp[i]=dp[i-2]+2;
                }
                // condition 2: ((...))
                else {
                    if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(') {
                        dp[i]=dp[i-1]+2;
                        if(i-dp[i-1]-2>=0) dp[i]+=dp[i-dp[i-1]-2];
                    } 
                    else dp[i]=0;
                }
            }
            // System.out.println(dp[i]);
            res=Math.max(res, dp[i]);
        }
        return res;
    }
}