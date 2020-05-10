package Week_03;

//面试题68 - II. 二叉树的最近公共祖先:https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
public class LowestCommonAncestor {


    //递归
    //时间复杂度 O(N)O(N) ： 其中 NN 为二叉树节点数；最差情况下（树退化为链表时），需要递归遍历树的所有节点。
    //空间复杂度 O(N)O(N) ： 最差情况下，递归深度达到 NN ，系统使用 O(N)O(N) 大小的额外空间。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

}
