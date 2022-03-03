package com.experiment;


import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

public class ArraysExplore {
    Integer[] array =  {1,2,3,4,5,6,7,8,9,10};

    public ArraysExplore(Integer[] array) {
        this.array = array;
    }

    public ArraysExplore() {
            out.println("Array declaration and initialization are possible together");
            out.println("Array initialization without iteration is not possible if declaration and initialization " +
                    "are separated");
            enhancedForLoop();
        enhancedForEachLoop();
    }

    private void enhancedForLoop() {
        out.println("Enhanced For loop with Array: ");
        for (int x: array) {
            out.print(x);
            out.print(", ");
        }
    }
    private void enhancedForEachLoop() {
        out.println("\nEnhanced ForEach loop on Integer Array as Collection won't work on primitive data types ");
        List<Integer> arrayColl = (List<Integer>) Arrays.asList(array);
        arrayColl.forEach(out::print);
    }

}
