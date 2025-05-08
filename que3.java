import java.util.*;

public class que3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleQueue q = new SimpleQueue();
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] query = line.split(" ");
            int type = Integer.parseInt(query[0]);

            if (type == 1) {
                int value = Integer.parseInt(query[1]);
                q.enqueue(value);
            } else if (type == 2) {
                q.dequeue();
            } else if (type == 3) {
                q.peek();
            }
        }

        sc.close();
    }

    public static class SimpleQueue{
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        public void enqueue(int x) {
            stack1.push(x);
        }


        public void dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()) {
                stack2.pop();
            }
        }


        public void peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()) {
                System.out.println(stack2.peek());
            }
        }
    }
}