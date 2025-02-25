import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Node {
    int val;
    List<Node> adjacencyList;

    public Node(int val) {
        this.val = val;
        this.adjacencyList = new ArrayList<>();
    }

    public Node() {
        this.val = 0;
        this.adjacencyList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return toStringHelper(new HashSet<>());
    }

    private String toStringHelper(Set<Integer> visited) {
        if (visited.contains(val)) {
            return val + " --> [cycle detected]";
        }
        visited.add(val);
        StringBuilder builder = new StringBuilder();
        builder.append(val).append(" -->");
        for (Node edge : adjacencyList) {
            builder.append(" ").append(edge.val);
        }
        return builder.toString();
    }

    public boolean addConnection(Node node) {
        boolean alreadyExists = this.adjacencyList.stream().anyMatch(n -> n.val == node.val);
        if (!alreadyExists) {
            this.adjacencyList.add(node);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.addConnection(n2);
        n2.addConnection(n1);

        n2.addConnection(n3);
        n3.addConnection(n2);

        n3.addConnection(n4);
        n4.addConnection(n3);

        System.out.println("Original Graph:");
        printGraph(n1, new HashSet<>());

        Node clonedGraph = cloneGraphBfs(n1);

        System.out.println("\nCloned Graph:");
        printGraph(clonedGraph, new HashSet<>());
    }

    public static void printGraph(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) {
            return;
        }
        visited.add(node.val);
        System.out.println(node.toStringHelper(new HashSet<>()));
        for (Node neighbor : node.adjacencyList) {
            printGraph(neighbor, visited);
        }
    }

    public static Node cloneGraphBfs(Node node) {
        Map<Integer, Node> oldToNewMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node clone = new Node(node.val);
        oldToNewMap.put(node.val, clone);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node nei : curr.adjacencyList) {
                if (!oldToNewMap.containsKey(nei.val)) {
                    oldToNewMap.put(nei.val, new Node(nei.val));
                    queue.add(nei);
                }
                oldToNewMap.get(curr.val).adjacencyList.add(oldToNewMap.get(nei.val));
            }
        }
        return clone;
    }

    public static Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (node == null)
            return null;

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        for (Node edge : node.adjacencyList) {
            newNode.adjacencyList.add(cloneGraph(edge, map));
        }
        return newNode;
    }
}
