import java.util.*;

public class que1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n + 1];

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        heights[n] = 0;


        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        System.out.println(maxArea);
    }
}