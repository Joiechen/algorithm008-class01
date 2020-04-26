package Week_02;

import java.util.Stack;

//题目 1021. 删除最外层的括号： https://leetcode-cn.com/problems/remove-outermost-parentheses/
public class RemoveOuterParentheses {

    //Stack解法
    public static String removeOuterParentheses01(String S) {
        String ans = "";
        Stack<Character> stack = new Stack<Character>();
        char[] s = S.toCharArray();
        int begin = 1;
        for(int i = 0; i < s.length; i++)
        {
            if(s[i] == '(')    stack.push(s[i]);
            else
            {
                stack.pop();
                if(stack.isEmpty())
                {
                    ans += S.substring(begin, i);
                    begin = i + 2;
                }
            }
        }
        return ans;
    }

    //计数器
    public static String removeOuterParentheses02(String S) {
        String ans = "";
        int count = 0;
        int begin = 1;
        char[] s = S.toCharArray();
        for(int i = 0; i < s.length; i++)
        {
            if(s[i] == '(') count++;
            else            count--;
            if(count == 0)
            {
                ans += S.substring(begin, i);
                begin = i + 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String test1 = "(()())(())";
        String test2 = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses01(test1));
        System.out.println(removeOuterParentheses02(test2));
    }

}