import java.util.*;


public class  que2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();


        for (char ch : input.toCharArray()) {
            stack.push(ch);
            queue.add(ch);
        }


        boolean isPalindrome = true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }


        if (isPalindrome) {
            System.out.println("The word, " + input + ", is a palindrome.");
        } else {
            System.out.println("The word, " + input + ", is not a palindrome.");
        }
    }
}
