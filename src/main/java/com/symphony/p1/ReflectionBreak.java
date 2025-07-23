package com.symphony.p1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreak {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton singleton = Singleton.getInstance();
        Class<?> singletonClass = singleton.getClass();
        Constructor<?> constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton1 = (Singleton) constructor.newInstance();
        System.out.println(singleton1);
        System.out.println(singleton);
    }
}
