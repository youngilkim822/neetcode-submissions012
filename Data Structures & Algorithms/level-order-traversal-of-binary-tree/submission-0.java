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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        TreeNode temp = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> innerList = new ArrayList<>();
            for(int i=0; i<size; i++){                
                TreeNode poll = deque.pollFirst();
                innerList.add(poll.val);
                if(poll.left != null){
                    deque.addLast(poll.left);
                }

                if(poll.right != null){
                    deque.addLast(poll.right);
                }
            }   
            
            list.add(new ArrayList<>(innerList));
        }
        return list;
    }
}







