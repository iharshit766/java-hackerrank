import java.util.*;

class Node1 {
    int data;
    Node1 left;
    Node1 right;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class que2 {

    public static Node1 insert(Node1 root, int data) {
        if (root == null) {
            return new Node1(data);
        }

        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void inOrder(Node1 root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        Node1 root = null;

        while (t-- > 0) {
            int data = scanner.nextInt();
            root = insert(root, data);
        }

        inOrder(root);
        scanner.close();
    }
}
