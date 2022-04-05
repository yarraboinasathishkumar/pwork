package com.experiment;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    private static int staticVar;

    private void exploreSimpleTasks() {
        SimpleTasks s = new SimpleTasks();
//        s.printPrimeNumbersTill(20);
        int n = 529;
        System.out.println("Binary gap:" +  s.binaryGap(n) + " for " + n);
        int[] array = {1,2,3,4,5,6};
        int k = 4;
        int[] destArray = s.cyclicArrayRotation(array,k);
    }

    private void exploreJVMProperties() {
        JVMExplore jvmExplore = new JVMExplore();
        jvmExplore.exploreJVMProperties(jvmExplore);

    }

    private void exploreStaticInstanceVariables() {
        int instanceVar = 10;
        System.out.println(instanceVar);
        System.out.println(staticVar);
    }

    private void exploreMultipleClassesInOneJavaFile() {
        PrivateExampleClass exampleClass = new PrivateExampleClass();
        exampleClass.privateClassWithDifferentFileName();
        PrivateExample2Class example2Class = new PrivateExample2Class();
        example2Class.privateClassWithDifferentFileName();
    }

    private void helloWorld() {
        System.out.println("Hello World");
    }
    private void exploreArrays() {
        ArraysExplore arraysExplore = new ArraysExplore();

    }
    private void exploreAll() {
        helloWorld();
        exploreSimpleTasks();
        exploreJVMProperties();
        exploreMultipleClassesInOneJavaFile();
        exploreStaticInstanceVariables();
        exploreArrays();
        exploreStrings();
    }

    private void exploreStrings() {
        StringsExplore stringsExplore = new StringsExplore();

    }
    public void exploreNumbers() {
        BigDecimal bd= BigDecimal.valueOf(1.0);
        if (bd.intValue() >= 0.0 && bd.intValue() < 1.0) {
            System.out.println("In between 0.0 and 0.1");
        }
    }

    private void exploreCollections() {
        CollectionsExplore collectionsExplore = new CollectionsExplore();
        collectionsExplore.exploreCollections();
    }
    private void exploreInputExperiment() throws IOException {
        InputExperiment inputExperiment = new InputExperiment();
        inputExperiment.min();
    }
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.exploreCollections();
        m.exploreInputExperiment();

    }
}
