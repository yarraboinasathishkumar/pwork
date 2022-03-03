package com.experiment;

public class SimpleTasks {
    private boolean isPrime(Integer n) {
        if ( n < 2) return false;
        for (Integer i=2; n/i >= i; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public void printPrimeNumbersTill(Integer n) {
        for (Integer i=1; i < n; i++) {
            String s1 = isPrime(i) ? "prime" : "not prime";
            System.out.println(i + " is " + s1);
        }
    }

    public int binaryGap(int n)
    /**Finding longest 0's in binary representation of the number
    For example: number is 32  : binary form: 100000 binary gap: 0
                 number is  5  : binary form: 101 binary gap: 1
                 number is 529: binary form: 1000010001 binary gap: 4*/
    {
        int binGap = 0, tBinGap = 0;
        int state = 0;
        for (int i=0; i < 32; i++) {
            int movingOne = 1;
            movingOne = movingOne << i;
            int value = n & movingOne;
            switch (state) {
                case 0 : // Initial state
                    if(value != 0) {
                       state = 1; // State changed when received '1'

                    }
                    break;
                case 1: // Looking for 0's as already received '1'
                    if(value == 0) {
                        state = 2;
                        tBinGap = 1;
                    }
                    break;
                case 2: // Looking for more no of 0's as one 0 already matched in state 1
                    if(value != 0) {
                        if(tBinGap > binGap) {
                            binGap = tBinGap;
                        }
                        state = 1;
                        tBinGap = 0;
                    } else {
                        tBinGap+=1;
                    }
            }
        }
        return binGap;
    }
    private void printArray(int[] array) {
        for(int x: array) {
            System.out.print(x);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
    public int[] cyclicArrayRotation(int[] array, int k)
    /**
     * cyclicArrayRotation: shifting of the elements in array by k times in right direction
     * example: input array: 1,2,3,4,5;   k = 1 ; output array: 2,3,4,5,1
     *          input array: 5,6,7,8,9;   k = 2 ; output array: 8,9,5,6,7
     */
    {
        int temp = 0;
        if(k >= array.length) {
            k = k % array.length;
        }
        System.out.print("\nInput Array:");
        printArray(array);
        for(int i=0; i<k; i++) {
            int initial = array[0];
            for(int j=1;j<array.length; j++) {
                temp = array[j];
                array[j] = initial;
                initial = temp;
            }
            array[0] = temp;
        }
        System.out.print("\nOutput Array:");
        printArray(array);
        return array;
    }
}
