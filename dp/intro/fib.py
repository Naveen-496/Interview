
def fib_nom(n: int):
  if n <= 2:
    return 1
  
  l1 = 1
  l2 = 1
  l3 = 0
  for i in range(2, n):
    l3 = ( l1 + l2 )
    l1 = l2
    l2 = l3
  return l3  


def fib(n: int):
  if n <= 1:
    return n
  return fib(n -1 ) + fib(n - 2)

def fib_memo(n: int, memo = {}):
  if n in memo:
    return memo[n]
  
  if n <= 1:
    return n
  memo[n] = fib_memo(n - 1, memo) + fib_memo(n - 2, memo)
  return memo[n]

def fib_tab(n: int):
  if n <= 1:
    return 1
  
  table = [0] * ( n + 1)
  table[1] = 1
  for i in range(2, n + 1):
    table[i] = table[i - 1] + table[i - 2]
    
  return table[n]  

print(fib_nom(7))