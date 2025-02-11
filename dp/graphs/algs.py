from collections import deque


def bfs(graph, start, search_value):
    visited = set()
    queue = deque([start])

    while queue:
        top = queue.popleft()

        if top == search_value:
            return True

        visited.add(top)

        for neighbor in graph[top]:
            if neighbor not in visited:
                queue.append(neighbor)
                visited.add(neighbor)

    return False


def dfs(graph, start, search_value, visited = None):
  if visited is None:
    visited = set()
    
  if start == search_value:
    return True
  
  visited.add(start)
  
  for neighbor in graph[start]:
    if neighbor not in visited:
      found = dfs(graph, neighbor, search_value, visited)
      if found:
        return True
      
  return False    

graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

start = "F"
search_value = "B"
res = bfs(graph, start, search_value)
print(f"element {search_value} : {res}")


graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

start = "F"
search_value = "E"
res = dfs(graph, start, search_value)
print(f"element {search_value} : {res}")
