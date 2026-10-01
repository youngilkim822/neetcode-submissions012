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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode original = root;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        recurse(root, p, stack1);
        recurse(root, q, stack2);

        int n = stack1.size();
        int m = stack2.size();

        TreeNode ans = null;
        if(m>n){
            ans = find(stack2, stack1);
        }else{
            ans = find(stack1, stack2);
        }

        return ans;
    }

    private boolean recurse(TreeNode root, TreeNode destination, Stack<TreeNode> stack){
        if(root == null) return false;

        stack.push(root);
        if(root == destination) return true;

        if(recurse(root.left, destination, stack)) return true;
        if(recurse(root.right, destination, stack)) return true;

        stack.pop();
        return false;
    }

    private TreeNode find(Stack<TreeNode> stack1, Stack<TreeNode> stack2){
        if(stack1 == null && stack2 == null) return null;
        if(stack1.isEmpty() && stack2.isEmpty()) return null;
        
        //if(stack1.peek() == stack2.peek()) return stack1.peek();
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(stack1.peek() == stack2.peek()) return stack1.peek();
            if(stack1.peek() != stack2.peek()){
                if(stack1.size() != stack2.size()){
                    stack1.pop();
                }else{
                    stack1.pop();
                    stack2.pop();
                }
            }
        }
        return null;
    }
}
