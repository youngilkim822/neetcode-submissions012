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
    private int ans = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        int rootVal = root.val;
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        deque.add(root);
        maxDeque.add(root.val);

        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i=0; i<size; i++){                
                TreeNode poll = deque.pollFirst();
                int pathMax = maxDeque.pollFirst();

                if(poll.val >= pathMax){
                    ans++;
                }

                int newMax = Math.max(pathMax, poll.val);

                if(poll.left != null) {
                    deque.addLast(poll.left);
                    maxDeque.addLast(newMax);
                }
                if(poll.right != null){
                    deque.addLast(poll.right);  
                    maxDeque.addLast(newMax);
                } 
            }
        }
        return ans;
    }
}











