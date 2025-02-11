
from typing import Optional


class Node:
    def __init__(self, val=0, neighbors=None) -> None:
        self.val = val
        self.neighbors = neighbors if neighbors else []


def clone_graph(node: Optional['Node']) -> Optional['Node']:
    oldToNew = {}

    def dfs(node):
        if oldToNew[node]:
            return oldToNew[node]

        copy = Node(node.val)
        oldToNew[node] = copy
        for nei in node.neighbors:
            copy.neighbors.append(dfs(nei))

        return copy

    return dfs(node) if node else None


