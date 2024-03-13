// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int area = 0;
        boolean found = false;
        int a = 99;
        int b = 0;
        int c = 99;
        int d = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ch) {
                    a = Math.min(a, i);
                    c = Math.min(c, j);
                    b = Math.max(b, i);
                    d = Math.max(d, j);
                }
            }
        }
        area += (b - a + 1) * (d - c + 1);
        if (area != 0) {
            found = true;
        }
        return found ? area : 0;
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                char c = grid[i][j];
                char n = grid[i - 1][j];
                char s = grid[i + 1][j];
                char w = grid[i][j - 1];
                char e = grid[i][j + 1];
                if (c == n && c == s && c == w && c == e) {
                    count++;
                }
            }
        }

        return count;
    }


}
