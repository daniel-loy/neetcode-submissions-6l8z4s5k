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
                List<List<Integer>> list = new ArrayList<>();

        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            int currentnumber = queue.size();
            while(currentnumber!=0){
                  TreeNode popedroot = queue.poll();
                  if(popedroot != null){
                  sublist.add(popedroot.val);

                    if(popedroot.left != null){
                        queue.add(popedroot.left);
                    }
                    if(popedroot.right != null){
                        queue.add(popedroot.right);
                    }
                    currentnumber--;
            }
            }
            if(sublist.size()!=0){
                list.add(sublist);
            }
        }
        return list;
    }
}
