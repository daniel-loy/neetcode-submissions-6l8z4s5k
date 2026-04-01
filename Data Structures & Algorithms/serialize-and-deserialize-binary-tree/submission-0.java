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

    String str="";

    int index =0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        bfs(root);
        return str;
    }

    public void bfs(TreeNode root){
        if(root == null){
            str = str + "N" + ",";
            return;
        }
        str = str + root.val + ",";
        bfs(root.left);
        bfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return ConstructTree(arr);
    }

    public TreeNode ConstructTree(String[] arr){
        if(arr.length<index || arr[index].equals("N")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        root.left = ConstructTree(arr);
        root.right = ConstructTree(arr);
        return root;
    }
}
