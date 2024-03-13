//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		// kích thước hàng
		int kthang = grid.length;
		int ktcot = grid[0].length;
		boolean[] fullkthang = new boolean[kthang];
		for(int i=0;i<kthang;i++){
			boolean a = true;
			for(int j=0;j<ktcot;j++){
				if(!grid[i][j]){
                   a =false;
				   break;
				}
			}
			fullkthang[i]= a;
		}
		int z =0;
		for (int i=kthang-1;i>=0;i--){
			if(fullkthang[i]){
				z++; // tăng số lần dịch
			} else if (z>0) {
				for(int j=0;j<ktcot;j++){
					grid[i+z][j]=grid[i][j];
				}
			}
		}
		for(int i=0;i<z;i++){
			for(int j=0;j<ktcot;j++){
				grid[i][j]=false;
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
