import java.util.*;

public class que4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        for (int k = 1; k <= n; k++) {
            int maxOfMins = Integer.MIN_VALUE;


            for (int i = 0; i <= n - k; i++) {
                int min = arr[i];


                for (int j = i; j < i + k; j++) {
                    if (arr[j] < min) {
                        min = arr[j];
                    }
                }


                if (min > maxOfMins) {
                    maxOfMins = min;
                }
            }


            System.out.print(maxOfMins + " ");
        }

        sc.close();
    }
}
