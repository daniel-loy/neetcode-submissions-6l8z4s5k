class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
     getlevelroot(root,0);
     return list;
    }

    public void getlevelroot(TreeNode root,int Level){
        if(root == null){
            return ;
        }
        if (list.size() <= Level) {
            list.add(new ArrayList<>());
        }
        list.get(Level).add(root.val);
        getlevelroot(root.left,Level+1);
        getlevelroot(root.right,Level+1);
    }
}
