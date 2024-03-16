public class HashingLP {
    static int size = 9;
    public static int[] arr = new int[size];

    public static void initalize(int[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = -1;
        }
    }

    public static void insert(int val) {
        int pos = val % size;
        if (arr[pos] == -1) {
            arr[pos] = val;
        } else {
            while (pos < size && arr[pos] != -1) {
                pos++;
            }
            if (pos < size) {
                arr[pos] = val;
            }
        }
    }

    public static void delete(int val) {

        int key = val % size;
        if (arr[key] == val) {
            arr[key] = -2;
        }
        int i = key++;
        while (i != key || arr[i % size] != val) {
            i++;
        }
        if (arr[i] == val) {
            arr[i] = -2;
        }
    }

    public static void printArr() {
        for (int i = 0; i < size; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void main(String args[]) {
        initalize(arr);
        insert(24);
        insert(65);
        insert(21);
        insert(32);
        insert(49);
        insert(36);
        insert(90);
        insert(27);
        insert(37);
        printArr();
        System.out.println("After deletion :");
        delete(90);
        delete(24);
        printArr();
    }

}
