import java.util.Arrays;

public class FirstLastPosInArray {
    public static int[] Occ(int num[], int target) {
        int ans[] = new int[2];
        ans[0] = FirstOcc(num, target);
        ans[1] = LastOcc(num, target);
        return ans;
    }

    public static int FirstOcc(int num[], int target) {
        int left = 0;
        int right = num.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int LastOcc(int num[], int target) {
        int left = 0;
        int right = num.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main(String args[]) {
        int arr[] = {17, 13, 11, 2, 3, 5, 2};
        int result[] = Occ(arr, 2);
        System.out.println("Positions of 2 in the array are: " + Arrays.toString(result));
    }
}
