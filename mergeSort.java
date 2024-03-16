public class mergeSort {
    public static void merge(int l, int h, int m, int arr[]) {
        int n1 = m - l + 1;
        int n2 = h - m;
        int r1[] = new int[n1];
        int r2[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            r1[i] = arr[i + l];
        }
        for (int j = 0; j < n2; j++) {
            r2[j] = arr[j + m + 1];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (r1[i] <= r2[j]) {
                arr[k] = r1[i];
                i++;
            } else {
                arr[k] = r2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = r1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = r2[j];
            j++;
            k++;
        }
    }

    public static void sort(int arr[], int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, h);
            merge(l, h, m, arr);
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        mergeSort ob = new mergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
