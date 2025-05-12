import java.util.*;

class Node2 {
    int data;
    Node left;
    Node right;

    Node2(int data) {
        this.data = data;
        left = right = null;
    }
}

public class que3 {

    public static void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        Node root = null;

        while (t-- > 0) {
            int data = scanner.nextInt();
            root = insert(root, data);
        }

        levelOrder(root);
        scanner.close();
    }
}
