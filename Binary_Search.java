package 박지인.BinarySearch;

public class Binary_Search {
    static int[] arr = { 1, 3, 5, 7, 8, 10};
    
    //재귀적
    public static int binary_search1(int key, int low, int high) {
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                return binary_search1(key, low, mid - 1);
            } else {
                return binary_search1(key, mid + 1, high);
            }
        }
        return -1;
    }

    //반복적
    public static int binary_search2(int key, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binary_search1(2, 0, 5));//-1
        System.out.println(binary_search2(3, 0, 5));//1
   
    }
}
