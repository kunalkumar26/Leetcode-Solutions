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
    
    public TreeNode grmn(TreeNode left, TreeNode curr){
        while(left.right != null && left.right != curr){
            left = left.right;
        }
        return left;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rmn = grmn(left, curr);
                if(rmn.right == null){
                    // create thread
                    rmn.right = curr;
                    curr = curr.left;
                } else {
                    // break thread
                    rmn.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}






