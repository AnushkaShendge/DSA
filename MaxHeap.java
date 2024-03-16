
public class MaxHeap {

    public static void heapify(int[] arr, int i, int heapSize) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, heapSize);
        }
    }

    public static int[] insert(int[] arr, int val) {
        int n = arr.length;
        int[] newArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = val;
        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void decKey(int[] arr, int val, int key) {
        int i = 0;
        while (arr[i] != val) {
            i++;
        }
        int temp = arr[i];
        arr[i] = key;
        key = temp;
        heapify(arr, 0, arr.length);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 24, 12, 11, 25 };
        System.out.println("Original array:");
        printArray(arr);

        arr = insert(arr, 35);
        System.out.println("Array after inserting 35:");
        printArray(arr);

        arr = insert(arr, 8);
        System.out.println("Array after inserting 8:");
        printArray(arr);
        heapify(arr, 0, arr.length);
        System.out.println("Heapify :");
        printArray(arr);
        System.out.println("Dec Key  (5):");
        decKey(arr, 11, 5);
        printArray(arr);
        System.out.println("After sorting / deletion :");
        heapSort(arr);
        printArray(arr);

    }
}
