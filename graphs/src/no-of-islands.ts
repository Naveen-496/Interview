enum LandScape {
  LAND = "1",
  WATER = "0",
}

function noOfIslands(grid: Array<Array<string>>) {
  let count = 0;
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] == LandScape.LAND) {
        markVisited(grid, i, j);
        count++;
      }
    }
  }
  return count;
}

function markVisited(grid: Array<Array<string>>, row: number, col: number) {
  const rows = grid.length;
  const cols = grid[0].length;

  if (
    row < 0 ||
    col < 0 ||
    row >= rows ||
    col >= cols ||
    grid[row][col] == LandScape.WATER
  ) {
    return;
  }

  grid[row][col] = LandScape.WATER;
  markVisited(grid, row - 1, col);
  markVisited(grid, row + 1, col);
  markVisited(grid, row, col - 1);
  markVisited(grid, row, col + 1);
}

const grid = [
  ["0", "1", "1", "1", "0"],
  ["0", "1", "0", "1", "0"],
  ["1", "1", "0", "0", "0"],
  ["0", "0", "0", "0", "0"],
];
const result = noOfIslands(grid);
console.log(result);
