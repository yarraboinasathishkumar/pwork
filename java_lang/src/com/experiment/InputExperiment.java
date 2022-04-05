package com.experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class InputExperiment {
    public void min() throws IOException {
        System.out.println("Program to print minimum number from the input numbers");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int min = 0;
        int num1 = 0;
        boolean first = true;
        String s = br.readLine();
        List<String> stringList = Arrays.asList(s.split(" "));
        for(String s1: stringList) {
            num1 = Integer.parseInt(s1);
            if(first) {
                min = num1;
            } else {
                min = min > num1? num1: min;
            }
            first = false;
        }
        System.out.println(min);

    }
}
