public class Grid {
	int multiplier;
	int roadSize;
	int mapSize;
	Cell road[];//////////// roads
	Cell map[][];///////// whole map

	public Grid() {
		makeGrid();
	}

	public void makeGrid() {
		roadSize = (2 + multiplier) * (10 + 9 * multiplier);
		mapSize = 6 + (5 * multiplier);
		road = new Cell[roadSize];
		map = new Cell[mapSize][mapSize];
		int k = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if ((i % 5 == 0) || (j % 5 == 0 && i % 5 != 0)) {
					map[i][j] = new Cell(i, j);
					road[k++] = map[i][j];
				}
			}
		}
	}

	public void setMultiplier(String difficulty) {
		if (difficulty.equals("easy"))
			this.multiplier = 0;
		else if (difficulty.equals("normal"))
			this.multiplier = 1;
		else if (difficulty.equals("hard"))
			this.multiplier = 2;
		makeGrid();
	}

	public Cell[] getCells() {
		return road;
	}

	public int getRoad() {
		return roadSize;
	}

	public int getSize() {
		return mapSize;
	}

}