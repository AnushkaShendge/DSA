public class CountPaths {
    public static int paths(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1; // We have reached the destination.
        }
        if (i >= m || j >= n) {
            return 0; // We have gone out of bounds.
        }

        // Calculate paths by moving right and down.
        int rightPaths = paths(i, j + 1, m, n);
        int downPaths = paths(i + 1, j, m, n);

        return rightPaths + downPaths;
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println("Total paths in maze: " + paths(0, 0, m, n));
    }
}

