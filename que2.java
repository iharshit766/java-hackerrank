import java.util.Arrays;

class que2 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int smallest = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == smallest) {
                smallest++;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};


        que2 solution = new que2();


        int result = solution.firstMissingPositive(nums);

        System.out.println("The first missing positive is: " + result);
    }
}
