class Solution {
    int k = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start == end) return null;

        // Find root in inorder
        int mid = start;
        while (inorder[mid] != preorder[k]) {
            mid++;
        }

        // Create root node
        TreeNode root = new TreeNode(preorder[k]);
        k++;

        // Build left and right subtrees
        root.left = build(preorder, inorder, start, mid);
        root.right = build(preorder, inorder, mid + 1, end);

        return root;
    }
}
