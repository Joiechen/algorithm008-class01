package Week_02;

import java.util.LinkedList;
import java.util.Queue;

//题目 104. 二叉树的最大深度： https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {

    //递归
    public int maxDepth01(TreeNode root) {
        if(root == null)    return 0;
        return 1 + Math.max(maxDepth01(root.left), maxDepth01(root.right));
    }


    //层序遍历
    /**
     * 从根结点开始，根结点入列后，只要队列不空，每轮处理时，
     * 先得到队列中顶点的数目，这表示的是当前层顶点的数目。
     * 仅对这些顶点全部出列然后将它们的子结点全部入列，这样就完成了一次while循环，处理的都是同一层顶点。
     * 此时队列中的顶点都是下一层的，下一次while循环处理的自然就是下一层的顶点了
     */
    public int maxDepth02(TreeNode root) {
        if(root == null)    return 0;
        int layer = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty())
        {
            layer++;
            int sz = q.size();
            for(int i = 0; i < sz; i++)
            {
                TreeNode cur = q.poll();
                if(cur.left != null)    q.offer(cur.left);
                if(cur.right != null)   q.offer(cur.right);
            }
        }
        return layer;
    }
}