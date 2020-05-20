public class Minesweeper {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[][] grid = new int[n][m];
        boolean[][] mine = new boolean[n][m];
        int n_ = 0;
        int m_ = 0;
        boolean check = true;
        for (int i = 0; i < k; i++) {
            check = true;
            while (check) {
                n_ = (int) (Math.random() * n);
                m_ = (int) (Math.random() * m);
                if (!mine[n_][m_]) {
                    check = false;
                }
            }
            mine[n_][m_] = true;
            for (int i_ = n_ - 1; i_ <= n_ + 1; i_++) {
                for (int j_ = m_-1; j_ <= m_ + 1; j_++) {
                    if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < m) grid[i_][j_] = grid[i_][j_] + 1;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.println();
            for (int j = 0; j < m; j++) {
                if (mine[i][j]) System.out.print("*");
                else System.out.print(grid[i][j]);
                System.out.print("  ");
            }
        }
    }
}




