function maxAreaOfIsland(grid: Array<Array<number>>) {
  let maxArea = 0;
  let [rows, cols] = [grid.length, grid[0].length];
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      maxArea = Math.max(maxArea, markVisitAndReturnArea(grid, i, j));
    }
  }
  return maxArea;
}

function markVisitAndReturnArea(
  grid: Array<Array<number>>,
  row: number,
  col: number
) {
  const [rows, cols] = [grid.length, grid[0].length];

  if (
    row < 0 ||
    row >= rows ||
    col < 0 ||
    col >= cols ||
    grid[row][col] === 0
  ) {
    return 0;
  }
  let count = 1;
  grid[row][col] = 0;
  count += markVisitAndReturnArea(grid, row - 1, col);
  count += markVisitAndReturnArea(grid, row + 1, col);
  count += markVisitAndReturnArea(grid, row, col - 1);
  count += markVisitAndReturnArea(grid, row, col + 1);
  return count;
}

const grid2 = [
  [0, 1, 1, 0, 1],
  [1, 0, 1, 0, 1],
  [0, 1, 1, 0, 1],
  [0, 1, 0, 0, 1],
];

const result2 = maxAreaOfIsland(grid2);
console.log(result2);
