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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        return recurse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recurse(TreeNode root, Integer min, Integer max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return recurse(root.left, min, root.val) 
                && recurse(root.right, root.val, max);
    }
}
