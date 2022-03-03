package com.experiment;

public class StringsExplore {
    String s1;
    String s2;
    String s3;
    String s4;
    public StringsExplore() {
        System.out.println("Creating string with Literal and with new keyword");
        s1 = "Welcome";
        s2 = new String("Welcome");
        if (s1 != s2) {
            System.out.println("String s1 created using literal and s2 created using new keyword and both are not " +
                    "referencing the same object even though the string value is same");
            System.out.println("s1:" + s1 + " and s2:" + s2);
        }
        s3 = "Welcome";
        if(s1 == s3) {
            System.out.println("s1 and s3 are referencing to same object from string constant pool");
            System.out.print("s1 and s3 String objects are created using literal method");
            System.out.println(" s1: "+s1+" and s3:"+s3);
        }
    }
}
