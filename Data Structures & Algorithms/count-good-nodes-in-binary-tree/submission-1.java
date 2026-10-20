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
        Deque<Map.Entry<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.add(Map.entry(root, root.val));

        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i=0; i<size; i++){                
                Map.Entry<TreeNode,Integer> poll = deque.pollFirst();
                TreeNode node = poll.getKey();
                Integer pathMax = poll.getValue();

                if(node.val >= pathMax){
                    ans++;
                }

                int newMax = Math.max(pathMax, node.val);

                if(node.left != null) {
                    deque.addLast(Map.entry(node.left, newMax));
                }
                if(node.right != null){
                    deque.addLast(Map.entry(node.right, newMax)); 
                } 
            }
        }
        return ans;
    }
}











