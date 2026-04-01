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

public class Codec {
    StringBuilder serializeresult = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);

        return serializeresult.substring(0,serializeresult.length()-1);

    }

    public void dfs(TreeNode root){
        if(root == null){
            serializeresult.append("n");
            serializeresult.append("#");
            return;
        }
        serializeresult.append(root.val);
        serializeresult.append("#");
        dfs(root.left);
        dfs(root.right);
    }

    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);

        String[] arr = data.split("#");

        return dfsconstructtree(new TreeNode(),arr);
    }
    
    public TreeNode dfsconstructtree(TreeNode newroot,String[] data){
        if(index<data.length){

            if(data[index].equals("n")){
                return null;
            }
            newroot.val = Integer.parseInt(data[index]);
            index++;
            newroot.left =  dfsconstructtree(new TreeNode(),data);
            index++;
            newroot.right = dfsconstructtree(new TreeNode(),data);
            return newroot;
        }
        else{
            return null;
        }
    }
}
