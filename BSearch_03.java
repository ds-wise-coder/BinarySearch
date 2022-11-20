package 박지인.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

//공유기 설치
//N개의 좌표에 C개의 공유기 설치
//공유기가 설치되는 집 간의 거리가 최대가 되도록
public class BSearch_03 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //이진 탐색 전 정렬은 필수
        Arrays.sort(arr);

        int low = 1;
        int high = arr[N - 1] - arr[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;
            /*
             * mid 거리에 대해 설치 가능한 공유기 개수가 C에 못미치면
             * 거리를 좁혀야 하기 때문에 high를 줄인다
             */
            if (canInstall(mid) < C) {
                high = mid;
            } else {
                /*
                 * 설치 가능한 공유기 개수가 C보다 크거나 같으면
                 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를 찾아낸다.
                 */
                low = mid + 1;
            }
        }
        System.out.println(low - 1);
    }
    
    //거리에 대해 설치 가능한 공유기 개수 리턴
    public static int canInstall(int distance) {
        int count = 1;
        int lastLocate=arr[0];
        for (int i = 1; i < arr.length; i++) {
            int locate = arr[i];
            /*
             * 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
             * 최소 거리보다 크거나 같을 때 공유기 설치 개수를 늘려주고
             * 마지막 설치 위치를 갱신해준다.
             */
            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
    
}
