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
    String data = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return data;
    }

    public void dfsSerialize(TreeNode root){
        if(root == null){
            data = data + "n" +Character.toString((char)257);
            return;
        }
        data = data +root.val+Character.toString((char)257);
        dfsSerialize(root.left);
        dfsSerialize(root.right);
    }
    int i=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String delimeter =  Character.toString((char)257);
        String[] nodeval =  data.split(delimeter);
        return dfs(nodeval);
    }
    public TreeNode dfs(String[] nodeval){
        if(nodeval[i].equals("n")){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodeval[i]));
        i++;
        node.left =  dfs(nodeval);
        node.right = dfs(nodeval);
        return node;
    }
}
