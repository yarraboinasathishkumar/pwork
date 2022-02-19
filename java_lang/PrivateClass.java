package com.experiment;

class PrivateExampleClass {
    void privateClassWithDifferentFileName() {
        System.out.println("Private class with different file name from class name");
    }
}

class PrivateExample2Class {
    void privateClassWithDifferentFileName() {
        System.out.println("Private2 class with different file name from class name");
    }
}

public class PrivateClass {
    void onePublcClassAndOtherPrivateClassPossibleInFile() {
     System.out.println("onePublcClassAndOtherPrivateClassPossibleInFile");
    }
    void twoPublicClassesInFileIsNotPossible() {
        System.out.println("twoPublicClassesInFileIsNotPossible");
    }
}

