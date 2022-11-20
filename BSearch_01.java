package 박지인.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

//특정 수의 개수 구하기
public class BSearch_01 {
    static int[] arr;
    //같은 값 개수 count
    static int count = 0;
    
    public static void binary_search(int key, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return;
        }

        if (key == arr[mid]) {
            count++;
             //양 옆에 같은 값이 있을 수 있기 때문에
            binary_search(key, low, mid - 1);
            binary_search(key, mid + 1, high);
        } else if (key < arr[mid]) {
            binary_search(key, low, mid - 1);
        } else {
            binary_search(key, mid + 1, high);
        }
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        binary_search(x, 0, N - 1);
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }

    }
}
