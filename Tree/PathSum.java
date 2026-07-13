class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class PathSum {
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    public int maxPathDown(TreeNode root, int[] maxValue) {
        if(root == null)
            return 0;

        int ls = Math.max(0, maxPathDown(root.left, maxValue));
        int rs = Math.max(0, maxPathDown(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], ls + rs + root.val);
        return root.val + Math.max(ls, rs);
    }
    public static void main(String[] args) {
        PathSum p = new PathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum path sum in the binary tree: " + p.maxPathSum(root));
    }
}