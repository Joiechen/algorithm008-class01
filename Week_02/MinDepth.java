package Week_02;


//题目 111. 二叉树的最小深度：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
public class MinDepth {

    /**
     * 求最小深度需要判断一下左节点或者右节点是否为null。
     * 因为如果根的左节点或者右节点为null，是不满足根到叶子节点这个定义的。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

}