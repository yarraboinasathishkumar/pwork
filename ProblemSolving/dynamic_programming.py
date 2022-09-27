import sys
import datetime
"""
    For a given set of denominations, 
    you are asked to find the minimum number of coins with
    which a given amount of money can be paid.

    Assume that you can use as many coins of
    a particular denomination as necessary.

    The greedy algorithmic approach is always to select
    the largest denomination not exceeding the 
    remaining amount of money to be paid. 
    As long as the remaining amount is greater than zero, 
    the process is repeated. 
    However, this algorithm may return a suboptimal result. 
    For instance, for an amount of 6 and 
    coins of values 1, 3, 4, we get 6 = 4 + 1 + 1, 
    but the optimal solution here is 6 = 3 + 3.

    A dynamic algorithm finds solutions to this problem 
    for all amounts not exceeding the given amount, 
    and for increasing sets of denominations. 
    For the example data, it would consider all the amounts 
    from 0 to 6, and the following sets of 
    denominations: ∅, {1}, {1, 3} and {1, 3, 4}. 
    
    Let dp[i, j] be the minimum number of coins needed to 
    pay the amount j if we use the set containing the 
    i smallest denominations.
    The number of coins needed must satisfy
    the following rules:
    • no coins are needed to pay a zero amount: dp[i, 0] = 0 
      (for all i);
    • if there are no denominations and the amount is positive, 
      there is no solution, so for convenience 
      the result can be infinite in this case: 
      dp[0, j] = ∞ (for all j > 0);
    • if the amount to be paid is smaller than the 
      highest denomination ci, this denomination can be discarded: 
      dp[i, j] = dp[i − 1, j] (for all i > 0 and all j 
      such that ci > j);
    • otherwise, we should consider two options and choose 
      the one requiring fewer coins: either we use a coin of the 
      highest denomination, and a smaller amount to be paid 
      remains, or we don’t use coins of the highest denomination 
      (and the denomination can thus be discarded): 
      dp[i, j] = min(dp[i, j − ci] + 1, dp[i − 1, j]) 
      (for all i > 0 and all j such that ci <= j).

      The following table shows all the solutions to 
      sub-problems considered for the example data.

    dp[i, j] 0 1 2 3 4 5 6
           ∅ 0 ∞ ∞ ∞ ∞ ∞ ∞
         {1} 0 1 2 3 4 5 6
      {1, 3} 0 1 2 1 2 3 2
   {1, 3, 4} 0 1 2 1 1 2 2
"""
def dynamic_coin_changing_unoptimized_memory(C, k):
    """
    Consider n denominations, 0 < c0 <= c1 <= . . . <= cn−1. 
    The algorithm processes the respective denominations 
    and calculates the minimum number of coins needed to pay 
    every amount from 0 to k. 
    When considering each successive denomination, 
    we use the previously calculated results for 
    the smaller amounts.

    Inputs:
    C : n denominations 0 < c1 <= c2, ..., cn-1 For e.g [1,3,4]
    k : amount to be paid k For e.g. 6
    output: minimum number of coins needed to pay every amount 
        from 0 to k.


    Both the time complexity and the space complexity of 
    this algorithm is O(n · k). 
    In this implementation, memory usage can be optimized.
    """
    # number of denominations n
    n = len(C)
    #create two dimensional array with all zeros
    dp = [[0] * (k+1) for i in range(n+1)]
    #Here sys.maxsize taken as infinity
    dp[0] = [0] + [sys.maxsize] * k
    for i in range(1, n+1):
        for j in range(C[i-1]):
            dp[i][j] = dp[i-1][j]
        for j in range(C[i-1],k+1):
            dp[i][j] = min(dp[i][j-C[i-1]]+1, dp[i-1][j])
    return dp[n]

    

def dynamic_coin_changing_optimized_memory(C, k):
  """
  Notice that, during the calculation of dp, 
  we only use the previous row, so we don’t need 
  to remember all of the rows.
  The time complexity is O(n · k) and the space complexity is O(k).
  """
  n = len(C)
  #create single dimensional array 
  #Here sys.maxsize taken as infinity
  dp = [0] + [sys.maxsize] * k 
  for i in range(1, n+1):
    for j in range(C[i-1], k+1):
      dp[j] = min(dp[j-C[i-1]]+1,dp[j])
  return dp

def dp_coin_changing():
  """
  Consider n denominations, 0 < c0 <= c1 <= . . . <= cn−1. 
    The algorithm processes the respective denominations 
    and calculates the minimum number of coins needed to pay 
    every amount from 0 to k. 
  """
  #inputs to test
  C = [1,3,4,5]
  k = 6
  start = datetime.datetime.now()
  output = dynamic_coin_changing_unoptimized_memory(C,k)
  lapsed = datetime.datetime.now() - start
  print("amount:", k, "\ndenominations:", C)
  print([i for i in range(0, k+1)])
  print(output)
  print(lapsed)
  start = datetime.datetime.now()
  output = dynamic_coin_changing_optimized_memory(C,k)
  lapsed = datetime.datetime.now() - start
  print([i for i in range(0, k+1)])
  print(output)
  print(lapsed)

def frog(S,k,q):
  """
  O(n · k): The task can be solved by using dynamic programming. 
  Let’s create an array dp consisting of k elements, 
  such that dp[j] will be the number of ways in which 
  the frog can jump to position j.
  
  We update consecutive cells of array dp. 
  There is exactly one way for the frog to jump to position 0,
  so dp[0] = 1. 
  Next, consider some position j > 0.
  The number of ways in which the frog can jump to position j 
  with a final jump of si is dp[j − si]. 
  Thus, the number of ways in which the frog can get to 
  position j is increased by the number of ways of 
  getting to position j − si, for every jump si.


  More precisely, dp[j] is increased 
  by the value of dp[j − si] (for all si <= j) modulo q.

  The time complexity is O(n·k) 
  (all cells of array dp are visited for every jump) and the space
  complexity is O(k).

  """
  n = len(S)
  dp = [1] + [0] * k
  for j in range(1, k+1):
    for i in range(n):
      if S[i] <= j:
        dp[j] = (dp[j] + dp[j-S[i]]) % q
  return dp[k], dp

def frog_jump():
  """
  A small frog wants to get from position 0 to k (1 <= k <= 10 000).
  The frog can jump over any one of n fixed distances 
  s0, s1, . . . , sn−1 (1 <= si <= k). 
  The goal is to count the number of different ways in which 
  the frog can jump to position k. To avoid overflow, it is 
  sufficient to return the result modulo q, where q is a given number.

  We assume that two patterns of jumps are different 
  if, in one pattern, the frog visits a position which 
  is not visited in the other pattern.
  """
  S = [1,3,4]
  k = 6
  q = 100
  output, wg = frog(S,k,q)
  print("Steps:", S)
  print("Goal:", k)
  print("Modulo of:", q)
  print("Different ways:", output)
  print("Different Goals:",[i for i in range(k+1)])
  print("Ways  for goals:", wg)
def number_solitaire_max_num(A, d):
  """
  
  """
  pass

def number_solitaire():
  """
  A game for one player is played on a board consisting of N consecutive squares, numbered from 0 to N − 1. There is a number written on each square. A non-empty array A of N integers contains the numbers written on the squares. Moreover, some squares can be marked during the game.
At the beginning of the game, there is a pebble on square number 0 and this is the only square on the board which is marked. The goal of the game is to move the pebble to square number N − 1.
During each turn we throw a six-sided die, with numbers from 1 to 6 on its faces, and consider the number K, which shows on the upper face after the die comes to rest. Then we move the pebble standing on square number I to square number I + K, providing that square number I + K exists. If square number I + K does not exist, we throw the die again until we obtain a valid move. Finally, we mark square number I + K.
After the game finishes (when the pebble is standing on square number N − 1), we calculate the result. The result of the game is the sum of the numbers written on all marked squares.
For example, given the following array:
   A[0] = 1
    A[1] = -2
    A[2] = 0
    A[3] = 9
    A[4] = -1
    A[5] = -2
one possible game could be as follows:
the pebble is on square number 0, which is marked;
we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
we throw 5; the pebble does not move, since there is no square number 8 on the board;
we throw 2; the pebble moves to square number 5; we mark this square and the game ends.
The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8. This is the maximal possible result that can be achieved on this board.
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A of N integers, returns the maximal result that can be achieved on the board represented by array A.
For example, given the array
   A[0] = 1
    A[1] = -2
    A[2] = 0
    A[3] = 9
    A[4] = -1
    A[5] = -2
the function should return 8, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].

  """
  pass

def main():
    print("Examples for dynamic programming concepts")
    print("Dynamic programming is a method by which a \
    solution is determined based on solving successively \
    similar but smaller problems. \
    This technique is used in algorithmic tasks in which \
    the solution of a bigger problem is relatively \
    easy to find, if we have solutions for its sub-problems.")
    #print('\n\n\n')
    #print("1. coin changing")
    #print("2. frog jump")
    #option = int(input("Select the option:"))
    
    #dp_coin_changing()
    frog_jump()




if __name__ == "__main__":
    main()
