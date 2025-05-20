package com.example.Test.TestingPatterns.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExercise1 {
    public static void main(String[] args){
        Class<?> stringClass = String.class;

        System.out.println("Class name: " + stringClass.getName());

        Method[] methods = stringClass.getMethods();
        for(Method method: methods){
            System.out.println("Method name:" + method.getName());
        }

        Field[] fields = stringClass.getFields();
        for(Field field:fields){
            System.out.println("Field name: " + field.getName());
        }
    }
}
