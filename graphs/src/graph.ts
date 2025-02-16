class Graph {
  constructor(private connections: Map<number, number[]>) {}

  addNode(node: number) {
    if (!this.connections.has(node)) {
      this.connections.set(node, []);
    }
  }

  addEdge(nodeOne: number, nodeTwo: number) {
    this.connections.get(nodeOne)?.push(nodeTwo);
    this.connections.get(nodeTwo)?.push(nodeOne);
  }

  printGraph() {
    for (const entry of this.connections.entries()) {
      console.log(entry[0], "-->", entry[1]);
    }
  }
}

const graph = new Graph(new Map());
graph.addNode(1);
graph.addNode(2);
graph.addNode(3);
graph.addNode(4);
graph.addNode(5);

graph.addEdge(1, 2);
graph.addEdge(3, 4);
graph.addEdge(3, 5);
graph.addEdge(4, 5);
graph.addEdge(5, 1);

graph.printGraph();
