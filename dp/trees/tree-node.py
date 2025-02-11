from collections import deque


class TreeNode:
    def __init__(self, data) -> None:
        self.data = data
        self.left = None
        self.right = None


root = TreeNode('A')
nodeB = TreeNode('B')
nodeC = TreeNode('C')
nodeD = TreeNode('D')
nodeE = TreeNode('E')


root.left = nodeB
root.right = nodeC

nodeB.left = nodeD
nodeB.right = nodeE


# print(root.left.right.data)

def dfs_pre_order(root: TreeNode):
    if root is None:
        return

    print(root.data, end=" ")
    dfs_pre_order(root.left)
    dfs_pre_order(root.right)


def dfs_in_order(root: TreeNode):
    if root is None:
        return

    dfs_in_order(root.left)
    print(root.data, end=" ")
    dfs_in_order(root.right)


def dfs_post_order(root: TreeNode):
    if root is None:
        return

    dfs_post_order(root.left)
    dfs_post_order(root.right)
    print(root.data, end=" ")


def bfs(root: TreeNode):
    visited = deque()

    visited.append(root)
    while len(visited) > 0:
        top = visited.popleft()
        print(top.data, end=' ')

        if top.left:
            visited.append(top.left)

        if top.right:
            visited.append(top.right)


dfs_pre_order(root)
print()
dfs_in_order(root)
print()
dfs_post_order(root)
print()
bfs(root)
print()
