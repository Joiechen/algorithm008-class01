### 动态规划 Dynamic Programming

1. “Simplifying a complicated problem by breaking it down into simpler sub-problems”(in a recursive manner)
2. Divide & Conquer + Optimal substructure 分治 + 最优子结构
3. 顺推形式: 动态递推

#### DP 顺推模板

```python
function DP():
    dp = [][] # 二维情况
    for i = 0 .. M {
        for j = 0 .. N {
            dp[i][j] = _Function(dp[i’][j’]...)
        }
    }
    return dp[M][N];
```

#### 关键点

动态规划 和 递归或者分治 没有根本上的区别(关键看有无最优的子结构)
拥有共性:找到重复子问题

差异性:最优子结构、中途可以淘汰次优解

#### 常见的 DP 题目和状态方程

##### 爬楼梯

##### 不同路径

##### 打家劫舍

##### 最小路径和

##### 股票买卖

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/

#### 高阶的 DP 问题

##### 复杂度来源

1. 状态拥有更多维度(二维、三维、或者更多、甚至需要压缩)
2. 状态方程更加复杂

本质:内功、逻辑思维、数学

##### 爬楼梯问题改进

https://leetcode-cn.com/problems/min-cost-climbing-stairs/

- 1、2、3
- x1, x2, …, xm 步
- 前后不能走相同的步伐

##### 编辑距离

https://leetcode-cn.com/problems/edit-distance/

- 如果 word1[i] 与 word2[j] 相同，显然 dp=dp[i-1][j-1]
- 如果 word1[i] 与 word2[j] 不同，那么 dp[i][j] 可以通过
  - 1 在 dp[i-1][j-1] 的基础上做 replace 操作达到目的
  - 2 在 dp[i-1][j] 的基础上做 insert 操作达到目的
  - 3 在 dp[i][j-1] 的基础上做 delete 操作达到目的

取三者最小情况即可