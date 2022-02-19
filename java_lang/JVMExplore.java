package com.experiment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JVMExplore {
    public void exploreJVMProperties (Object object) {
        Class c = object.getClass();
        System.out.println("Class Name of object:" + c.getName());

        System.out.println("Methods in the class:" + c.getName());
        Method methods[] = c.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println(method.getName());
        }
        System.out.println("Fields in the class:" + c.getName());
        Field fields[] = c.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName());
        }
    }
}
