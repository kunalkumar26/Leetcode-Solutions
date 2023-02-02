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
    public List<TreeNode> helper(int si, int ei){
        if(si > ei){
            List<TreeNode> small = new ArrayList<>();
            small.add(null);
            return small;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i=si; i<=ei; i++){
            List<TreeNode> left = helper(si, i-1);
            List<TreeNode> right = helper(i+1, ei);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
}












