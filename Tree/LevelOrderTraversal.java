import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wraplist = new LinkedList<List<Integer>>();
        if(root == null)
            return wraplist;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for(int i = 0; i < levelNum; i++) {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            wraplist.add(sublist);
        }
        return wraplist;
    }
    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}