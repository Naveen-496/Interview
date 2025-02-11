class TreeNode:
    def __init__(self, data) -> None:
        self.data = data
        self.left = None
        self.right = None


class BinarySearchTree:
    def __init__(self) -> None:
        self.root = None

    def insert(self, data):
        if not self.root:
            self.root = TreeNode(data)
        else:
            self._insert_recursive(self.root, data)

    def _insert_recursive(self, node, data):
        if data < node.data:
            if node.left is None:
                node.left = TreeNode(data)
            else:
                self._insert_recursive(node.left, data)
        else:
            if node.right is None:
                node.right = TreeNode(data)
            else:
                self._insert_recursive(node.right, data)

    def search(self, data):
        return self._search_recursive(self.root, data)

    def _search_recursive(self, node, data):
        if node is None or node.data == data:
            return node

        if data < node.data:
            return self._search_recursive(node.left, data)
        return self._search_recursive(node.right, data)

    def delete(self, data):
        self.root = self._delete_recursive(self.root, data)

    def _delete_recursive(self, node, data):
        if node is None:
            return node

        if data < node.data:
            node.left = self._delete_recursive(node.left, data)
        elif data > node.data:
            node.right = self._delete_recursive(node.right, data)
        else:
            # Node with only one child or no child
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left

            # Node with two children
            # Get the inorder successor (smallest in the right subtree)
            temp = self._min_value_node(node.right)
            node.data = temp.data
            node.right = self._delete_recursive(node.right, temp.data)

        return node

    def _min_value_node(self, node):
        current = node
        while current.left:
            current = current.left
        return current

    def inorder_traversal(self):
        result = []
        self._inorder_recursive(self.root, result)
        return result

    def _inorder_recursive(self, node, result):
        if node:
            self._inorder_recursive(node.left, result)
            result.append(node.data)
            self._inorder_recursive(node.right, result)

    def preorder_traversal(self):
        result = []
        self._preorder_recursive(self.root, result)
        return result

    def _preorder_recursive(self, node, result):
        if node:
            result.append(node.data)
            self._preorder_recursive(node.left, result)
            self._preorder_recursive(node.right, result)

    def postorder_traversal(self):
        result = []
        self._postorder_recursive(self.root, result)
        return result

    def _postorder_recursive(self, node, result):
        if node:
            self._postorder_recursive(node.left, result)
            self._postorder_recursive(node.right, result)
            result.append(node.data)

    def get_height(self):
        return self._get_height_recursive(self.root)

    def _get_height_recursive(self, node):
        if not node:
            return 0
        left_height = self._get_height_recursive(node.left)
        right_height = self._get_height_recursive(node.right)
        return max(left_height, right_height) + 1


# Example usage:
if __name__ == "__main__":
    bst = BinarySearchTree()

    # Insert nodes
    nodes = [5, 3, 7, 1, 4, 6, 8]
    for node in nodes:
        bst.insert(node)

    # Traverse the tree
    # Should print sorted order
    print("Inorder traversal:", bst.inorder_traversal())
    print("Preorder traversal:", bst.preorder_traversal())
    print("Postorder traversal:", bst.postorder_traversal())
    print("Height: ",bst._get_height_recursive(bst.root))

    # Search for a value
    print("Searching for 4:", bst.search(
        4).data if bst.search(4) else "Not found")

    # Get tree height
    print("Tree height:", bst.get_height())

    # Delete a node
    bst.delete(3)
    print("Inorder traversal after deleting 3:", bst.inorder_traversal())
