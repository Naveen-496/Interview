import java.util.Arrays;

public class IsLandsAndTreasure {

    private final int INF = 2147483647;
    private boolean[][] visit;
    private final int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int ROWS, COLS;

    public int dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == -1 || visit[r][c]) {
            return INF;
        }

        if (grid[r][c] == 0) {
            return 0;
        }

        visit[r][c] = true;
        int res = INF;
        for (int[] dir : dirs) {
            int curr = dfs(grid, r + dir[0], c + dir[1]);

            if (curr != INF) {
                res = Math.min(res, 1 + curr);
            }
        }
        visit[r][c] = false;
        return res;
    }

    public void isLandsAndTreasures(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visit = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == INF) {
                    grid[r][c] = dfs(grid, r, c);
                }
            }
        }
    }

    public static void main(String[] args) {
        var grid = new int[][] {
                { 2147483647, -1, 0, 2147483647 },
                { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 },
                { 0, -1, 2147483647, 2147483647 }
        };

        var isL = new IsLandsAndTreasure();
        isL.isLandsAndTreasures(grid);
        for (int[] rows : grid) {
            System.out.println(Arrays.toString(rows));
        }
    }
}
