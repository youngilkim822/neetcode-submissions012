/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int depth = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return maxDepth(root, depth);
    }

    private int maxDepth(TreeNode root, int depth){
        if(root == null) return depth;

        int leftDepth = maxDepth(root.left, depth+1);
        int rightDepth = maxDepth(root.right, depth+1);

        return Math.max(leftDepth, rightDepth);
    }
}
