public class NoOfIsland {
    public static int island(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int r, int c, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(r - 1, c, grid);
        dfs(r + 1, c, grid);
        dfs(r, c - 1, grid);
        dfs(r, c + 1, grid);
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '0', '1' },
                { '1', '1', '0' },
                { '1', '0', '0' }
        };
        System.out.println(island(grid));
    }
}
