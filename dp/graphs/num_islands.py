from typing import List


def numIslands(grid: List[List[str]]) -> int:
    islands_count = 0
    rows, cols = len(grid), len(grid[0])

    def cover_island(row: int, col: int) -> None:
        if row >= rows or row < 0 or col >= cols or col < 0 or grid[row][col] == "0":
            return

        grid[row][col] = "0"
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for dr, dc in dirs:
            cover_island(row + dr, col + dc)

    for i in range(rows):
        for j in range(cols):
            if grid[i][j] == "1":
                cover_island(i, j)
                islands_count += 1
    return islands_count


grid = [
    ["1", "1", "0", "0", "1"],
    ["1", "1", "0", "0", "1"],
    ["0", "0", "1", "0", "0"],
    ["0", "0", "0", "1", "1"]
]

print(f'No of Islands {numIslands(grid)}')
