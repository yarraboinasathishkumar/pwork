def permutations(r, c=''):
    if len(r) == 0:
        print(c)
    for i in range(len(r)):
        nC = c+r[i]
        nR = r[0:i] + r[i+1:]
        permutations(nR, nC)
    

if __name__ == "__main__":
    s= 'ABCD'
    permutations(s)
    