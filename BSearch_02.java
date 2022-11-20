package 박지인.BinarySearch;

import java.util.Scanner;

//고정점 찾기
// 그 값이 인덱스와 동일한 원소
public class BSearch_02 {
    static int[] arr;

    public static int binary_search( int low, int high) {
        int answer = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > mid) {
                high = mid - 1;
            } else if (arr[mid] < mid) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(binary_search(0,N-1));
    }
}
