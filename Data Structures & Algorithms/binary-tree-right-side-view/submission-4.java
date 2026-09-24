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
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stk = new ArrayDeque<>();

        if(root == null){
            return list;
        }
        stk.offer(root);
        list.add(stk.peekLast().val);

        while(!stk.isEmpty()){
            int count = stk.size();
            while(count !=0){
                TreeNode left = stk.peekFirst().left;
                TreeNode right = stk.peekFirst().right;
                //System.out.println("left : "+left.val+" right : "+right.val);
                stk.removeFirst();
                if(left!=null){
                    stk.offer(left);
                }

                if(right != null){
                    stk.offer(right);
                }

                count--;
            }

            if(!stk.isEmpty()){
                list.add(stk.peekLast().val);
            }
        }
        return list;
    }
}
