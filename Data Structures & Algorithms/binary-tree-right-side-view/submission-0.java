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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        deque.addLast(root);
        list.add(root.val);

        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i=0; i<size; i++){
                TreeNode poll = deque.pollFirst();
                if(poll.left != null){
                    deque.addLast(poll.left);
                }
                if(poll.right != null){
                    deque.addLast(poll.right);
                }
            }

            if(!deque.isEmpty()){
                list.add(deque.getLast().val);
            }
        }
        return list;
    }
}
