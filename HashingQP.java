public class HashingQP {
    static int size = 10;
    public static int[] arr = new int[size];

    public static void initalize(int[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = -1;
        }
    }

    public static void insert(int val) {
        int pos = val % size;
        int originalPos = pos;
        int i = 1;

        while (arr[pos] != -1) {
            pos = (originalPos + i * i) % size; // Quadratic probing
            i++;

            if (pos == originalPos) {
                System.out.println("Hash table is full, cannot insert " + val);
                return;
            }
        }

        arr[pos] = val;
    }

    public static void delete(int val) {
        int key = val % size;
        if (arr[key] == val) {
            arr[key] = -2;
        }
        int i = key++;
        while (i != key) {
            if (arr[i % size] != val) {
                i++;
            }
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
        insert(9);
        insert(19);
        insert(29);
        insert(39);
        insert(49);
        insert(59);
        printArr();
        System.out.println("After deletion :");
        delete(29);
        delete(59);
        printArr();
    }
}
