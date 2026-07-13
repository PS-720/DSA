class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        int result = maxDepth(root);
        if(result == -1)
            return false;
        else
            return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int rh = maxDepth(root.right);
        int lh = maxDepth(root.left);

        if(lh == -1 || rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        BalancedTree bt = new BalancedTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Is the binary tree balanced? " + bt.isBalanced(root));
    }
}