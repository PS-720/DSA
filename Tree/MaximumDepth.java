class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int rh = maxDepth(root.right);
        int lh = maxDepth(root.left);

        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        MaximumDepth md = new MaximumDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Maximum depth of binary tree is: " + md.maxDepth(root));
    }
}