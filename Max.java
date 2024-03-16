public class Max{

    static int[] findMaxMin(int[] arr, int low, int high) {
        int[] result = new int[2];
        int mid;

        // If there is only one element
        if (low == high) {
            result[0] = arr[low]; // Minimum
            result[1] = arr[low]; // Maximum
            return result;
        }

        // If there are two elements
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                result[0] = arr[high]; // Minimum
                result[1] = arr[low]; // Maximum
            } else {
                result[0] = arr[low]; // Minimum
                result[1] = arr[high]; // Maximum
            }
            return result;
        }

        // If there are more than two elements
        mid = (low + high) / 2;
        int[] leftResult = findMaxMin(arr, low, mid);
        int[] rightResult = findMaxMin(arr, mid + 1, high);

        // Compare minimums of two parts
        result[0] = Math.min(leftResult[0], rightResult[0]);

        // Compare maximums of two parts
        result[1] = Math.max(leftResult[1], rightResult[1]);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int[] result = findMaxMin(arr, 0, arr.length - 1);
        System.out.println("Minimum element: " + result[0]);
        System.out.println("Maximum element: " + result[1]);
    }
}
