package Week_02;

//题目，110. 平衡二叉树 https://leetcode-cn.com/problems/balanced-binary-tree/
public class IsBalance {

    //自顶向下
    /**
     * 自顶向下地判断各个结点。
       判断某顶点为根结点的树是否为平衡二叉树，首先要满足的条件是：对于这个顶点，左子树的高度和右子树的高度之差的绝对值小于等于1。
      其次：左子树为平衡二叉树，右子树也为平衡二叉树。
      综上，自顶向下递归地检查每个顶点。

      缺点：自顶向下计算每个结点的高度时存在大量冗余。
     * @param root
     * @return
     */
    public boolean isBalanced01(TreeNode root) {
        if(root == null)    return true;
        int leftHeight = getHeight01(root.left);
        int rightHeight = getHeight01(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)  
            return false;
        return isBalanced01(root.left) && isBalanced01(root.right);
    }
    private int getHeight01(TreeNode root) {
        if(root == null)    return 0;
        return Math.max(getHeight01(root.left), getHeight01(root.right)) + 1;
    }


    //自底向上
    /**
     * 自底向上递归地返回结点的高度。
       递归的每一层要做的工作：根据向上返回得到的左右子结点的高度，判断是否平衡，若平衡，返回当前结点的高度（左右子节点高度的最大值加一）。若不平衡，则之后的高度都不必再计算了，这棵树必然不平衡，这种情况下向上返回-1。
       递归结束后，若树是平衡的，将得到根结点的高度（不断通过返回的子结点的高度计算得到）；若树是不平衡的，将得到-1。根据这个结果返回true/false即可。
       相对于解法一，这样做可以不断通过返回的子树高度计算当前结点高度，无需向解法一那样结点的高度会被重复计算。而且可以通过返回-1来指示树是不平衡的，
       提前结束结点高度的计算。
     * @param root
     * @return
     */
    public boolean isBalanced02(TreeNode root) {
        return getHeight02(root) != -1;
    }
    private int getHeight02(TreeNode root) {
        if(root == null)    return 0;
        int leftHeight = getHeight02(root.left);
        int rightHeight = getHeight02(root.right);
        if(leftHeight == -1 || rightHeight == -1)
            return -1;
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

}