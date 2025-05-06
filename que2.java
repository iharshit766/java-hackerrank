import java.util.*;

public class que2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Enter the no. of left rotations: ");
        int k = sc.nextInt();

        rotatemethod(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }

    public static void rotatemethod(int arr[], int k) {
        k = k % arr.length;

        reverse(0, k - 1, arr);
        reverse(k, arr.length - 1, arr);
        reverse(0, arr.length - 1, arr);
    }

    public static void reverse(int sp, int ep, int arr[]) {
        while (sp < ep) {
            int temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;
            sp++;
            ep--;
        }
    }
}
