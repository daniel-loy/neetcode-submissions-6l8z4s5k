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
    List<Integer> arr = new ArrayList<>();
    int max=-1;
    public List<Integer> rightSideView(TreeNode root) {
        righttraversal(root,0);
        return arr;
    }
    public void righttraversal(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level>max){
            max+=1;
            arr.add(root.val);
        }
        righttraversal(root.right,level+1);
        righttraversal(root.left,level+1);
    }
}
