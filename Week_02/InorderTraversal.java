package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//题目 二叉树的中序遍历：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {

    //递归
    public List<Integer> inorderTraversal01(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inorderTraversal01(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal01(root.right));
        return result;

    }

    /***
     * 将节点左子树全部压栈
     * 弹出栈顶所有没有右子树的元素并将其加入遍历结果，直到出现右子树
     * 若当前元素有右子树，则将当前元素加入遍历结果
     * 指向当前节点右子树
     * 若当前节点为空，则结束遍历；若当前节点不为空，则继续循环上述操作
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal02(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            while (treeNodeStack.size() > 0 && (node = treeNodeStack.pop()).right == null) {
                result.add(node.val);
            }
            // node不可能为null
            if (node.right != null) {
                result.add(node.val);
            }
            node = node.right;
        }
        return result;
    }

    /**
     * 将节点左子树全部压栈
     * 如果栈不为空则弹出栈顶元素并将其加入遍历结果，指向当前节点右子树
     * 若当前节点和栈均为空，则结束遍历；否则继续循环上述操作
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

}