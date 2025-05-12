import java.util.*;

class Node3 {
    int data;
    Node left;
    Node right;

    Node3(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class que4 {

    public static void topView(Node root) {
        if (root == null) return;

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int data : topViewMap.values()) {
            System.out.print(data + " ");
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data <= root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

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

        topView(root);
        scanner.close();
    }
}
