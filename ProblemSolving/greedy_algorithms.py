from collections import deque

def greedy_coin_changing_impl(M, k):
    """

    """
    n = len(M)
    result = []
    for i in range(n-1, -1, -1):
        result += [(M[i], k // M[i])]
        k %= M[i]
    return result



def greedy_coin_change():
    """
    """
    M = [1,3,4]
    k = 6
    output = greedy_coin_changing_impl(M, k)
    print(output)

def greedyCanoeistA(W, k):
    """
    Inputs:
    W: wieghts of canoeists
    k: maximum load 
    Outputs:
    canoes: minimum number of double canoes with maximum load k

    """
    N = len(W)
    light = deque()
    heavy = deque()
    for i in range(N-1):
        if W[i] + W[-1] <= k:
            light.append(W[i])
        else:
            heavy.append(W[i])
    heavy.append(W[-1])
    canoes = 0
    while( light or heavy):
        if len(light) > 0:
            light.pop()
        heavy.pop()
        canoes += 1
        if (not heavy and light):
            heavy.append(light.pop())
        while(len(heavy) > 1 and heavy[-1] + heavy[0] <= k):
            light.append(heavy.popleft())
    return canoes

def greedyCanoeistB(W,k):
    """
    """
    canoes = 0
    j = 0
    i = len(W) - 1
    while (i >= j):
        if W[i] + W[j] <= k:
            j += 1
        canoes += 1
        i -= 1
    return canoes

def greedyCanoeist():
    W = [1,3,4,5]
    k = 6
    canoesA = greedyCanoeistA(W,k)
    print("result with A:", canoesA)
    canoesB = greedyCanoeistB(W,k)
    print("result with B:", canoesB)

def greedyMaxNonOverlappingSegmentsImpl(A,B):
    """
    Inputs:
    A: Array containing starting point of line segment
    B: Array containing ending point of line segment
    Output: Maximum nov overlapping segments
    """
    n = len(A)
    maxNonOverlapSegs = 0
    
    for i in range(n):
        curNonOverlapSegs = 0
        curOveralpSegs = 0
        for j in range(i+1, n):
            if (A[i] <= A[j] <= B[i]) or (A[j] <= A[i] <= B[j]):
                curOveralpSegs += 1
            else:
                curNonOverlapSegs += 1
        maxNonOverlapSegs = max(maxNonOverlapSegs, curNonOverlapSegs)
    return maxNonOverlapSegs




def greedyMaxNonOverlappingSegments():
    """

    """
    A = [1,3,7,9,9]
    B = [5,6,8,9,10]
    maxNonOverlapSegs = greedyMaxNonOverlappingSegmentsImpl(A, B)
    print("maxNonOverlapping Segments", maxNonOverlapSegs)

def greedyTieRopesImpl(A, K):
    """
    """
    n = len(A)
    maxRopes = 0
    i = 0
    while i < n:
        if A[i] >= K:
            maxRopes += 1
            i += 1
        else:
            tieRopes = A[i]
            next = i+1
            for j in range(i+1, n):
                if A[j] >= K:
                    next = j
                    break
                else:
                    if tieRopes + A[j] >= K:
                        next = j+1
                        maxRopes += 1
                        break
                    else:
                        tieRopes += A[j]
            i = next
    return maxRopes            


def greedyTieRopes():
    """
    """
    A = [1,2,3,4,1,1,3]
    K = 4
    maxRopes = greedyTieRopesImpl(A,K)
    print("Max number of tied ropes with greater than equal:",K,"are:", maxRopes)

def main():
    """
    Greedy algorithms
    """
    print("greedy algorithms")
    greedy_coin_change()
    greedyCanoeist()
    greedyMaxNonOverlappingSegments()
    greedyTieRopes()

if __name__ == "__main__":
    main()
