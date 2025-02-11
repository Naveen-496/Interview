from typing import List


def max_area_of_island(grid: List[List[str]]) -> int:
    rows, cols = len(grid), len(grid[0])
    visited = set()

    def count_cells(row: int, col: int):
        if row == rows or row < 0 or col == cols or col < 0 or grid[row][col] == 0 or (row, col) in visited:
            return 0

        visited.add((row, col))
        return (1 + count_cells(row + 1, col) + count_cells(row - 1, col) + count_cells(row, col + 1) + count_cells(row, col - 1))

    area = 0
    for i in range(rows):
        for j in range(cols):
            area = max(area, count_cells(i, j))

    return area


grid = [
    [0, 1, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [0, 1, 1, 0, 1],
    [0, 1, 0, 0, 1]
]

max_islands = max_area_of_island(grid)
print(f"Max Area: {max_islands}")
