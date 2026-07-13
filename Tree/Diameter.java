class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }
    public int height(TreeNode root, int[] diameter) {
        if(root == null)
            return 0;

        int rh = height(root.right, diameter);
        int lh = height(root.left, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        Diameter d = new Diameter();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of the binary tree: " + d.diameterOfBinaryTree(root));
    }
}