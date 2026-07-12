class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Traversal {
    public static void preorder(Node node) {
        if(node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    public static void inorder(Node node) {
        if(node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    public static void postorder(Node node) {
        if(node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is:");
        preorder(root);
        System.out.println("\nInorder traversal of binary tree is:");
        inorder(root);
        System.out.println("\nPostorder traversal of binary tree is:");
        postorder(root);
    }
}