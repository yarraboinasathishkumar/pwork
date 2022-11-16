"""
The Caterpillar method is a likeable name for a popular means of solving algorithmic tasks.
The idea is to check elements in a way that’s reminiscent of movements of a caterpillar.
The caterpillar crawls through the array. We remember the front and back positions of the
caterpillar, and at every step either of them is moved forward.
"""
def caterpillarSubSequenceSumImpl(A,s):
    """
    Let’s estimate the time complexity of the  algorithm. At the first glance we have two
nested loops, what suggest quadratic time. However, notice that at every step we move the
front or the back of the caterpillar, and their positions will never exceed n. Thus we actually
get an O(n) solution.

The above estimation of time complexity is based on amortized cost, which will be ex-
plained more precisely in future lessons.  
    """
    n=len(A)
    front, total = 0, 0 
    for back in range(n):
        while (front < n and total + A[front] <= s ):
            total += A[front]
            front += 1
        if total == s:
            return True
        total -= A[back]
    return False

def caterpillarSubSequenceSum():
    """
    Let’s check whether a sequence a0, a1, . . . , an−1 (1 <= ai <= 10^9) contains a contiguous subse-
    quence whose sum of elements equals s. For example, in the following sequence we are looking
    for a subsequence whose total equals s = 12.

    Each position of the caterpillar will represent a different contiguous subsequence in which
the total of the elements is not greater than s. Let's initially set the caterpillar on the first
element. Next we will perform the following steps:
• if we can, we move the right end (front) forward and increase the size of the caterpillar;
• otherwise, we move the left end (back) forward and decrease the size of the caterpillar.
In this way, for every position of the left end we know the longest caterpillar that covers
elements whose total is not greater than s. If there is a subsequence whose total of elements
equals s, then there certainly is a moment when the caterpillar covers all its elements.
    """
    A = [6, 2, 7, 4, 1, 3, 6]
    s = 12
    result = caterpillarSubSequenceSumImpl(A, s)
    print("Sub  sequence with sum ",s, " is : ", result)

def caterpillarTrianglesWithSticksImpl(A):
    """
    O(n^2): For every pair x, y we can find the largest stick z that can be used to
construct the triangle. Every stick k, such that y < k <= z, can also be used, because the
condition ax + ay > ak will still be true. We can add up all these triangles at once.
If the value z is found every time from the beginning then we get a O(n3) time complexity
solution. However, we can instead use the caterpillar method. When increasing the value of
y, we can increase (as far as possible) the value of z.
    """
    n = len(A)
    result = 0
    for x in range(n):
        z = x + 2
        for y in range(x + 1, n):
            while ( z < n and A[x] + A[y] > A[z]):
                z += 1
            result += z - y - 1
    return result


def caterpillarTrianglesWithSticks():
    """
    You are given n sticks (of lengths 1 <= a0 <= a1 <= . . . <= an−1 <= 10^9). The goal is
to count the number of triangles that can be constructed using these sticks. More precisely,
we have to count the number of triplets at indices x < y < z, such that ax + ay > az.
    """
    A = [1,2,3,4,5]
    result = caterpillarTrianglesWithSticksImpl(A)
    print("Number of possible triangles: ", result, " with sequence:", A)




def main():
    """
    """
    caterpillarSubSequenceSum()
    caterpillarTrianglesWithSticks()

if __name__ == "__main__":
    main()