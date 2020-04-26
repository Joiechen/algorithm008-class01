package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144. 二叉树的前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class PreorderTraversal {

    // 递归遍历
    public List<Integer> preorderTraversal01(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;
    }
    
    public List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
        
        list.add(root.val);
        if(root.left != null)
            preorderTraversal(root.left, list);
        if(root.right != null)
            preorderTraversal(root.right, list);
        
        return list;
    }


    //迭代遍历
    public List<Integer> preorderTraversal02(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        List<Integer> list = new ArrayList<Integer>();
        
        while(nodeStack.size() != 0 ){
            TreeNode node = nodeStack.pop();
            list.add(node.val);            
            if(node.right != null)
                nodeStack.push(node.right);
            if(node.left != null)
                nodeStack.push(node.left);
        }
        
        return list;
        
    }

}