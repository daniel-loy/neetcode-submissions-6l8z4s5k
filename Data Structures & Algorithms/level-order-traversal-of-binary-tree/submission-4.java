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
        Deque<TreeNode> stk = new ArrayDeque<>();

        if(root == null){
            return list;
        }
        stk.offer(root);
        int count = 1;

        while(!stk.isEmpty()){
            int nextcount = 0;
            List<Integer> innerlist = new ArrayList<>();

            while(count!=0){
                TreeNode left = stk.peekFirst().left;
                TreeNode right = stk.peekFirst().right;

                innerlist.add(stk.removeFirst().val);
                if(left != null){
                    stk.offer(left);
                    nextcount++;
                }

                if(right != null){
                    stk.offer(right);
                    nextcount++;
                }

                count--;
            }
            count = nextcount;
            list.add(innerlist);
        }
        return list;
    }
}
