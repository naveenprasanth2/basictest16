package com.symphony.p1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimesTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Employee employee = new Employee();
        Class<?> empClass = employee.getClass();
        Method[] methods = empClass.getDeclaredMethods();
        for(Method method : methods){
            if (method.isAnnotationPresent(Times.class)){
                int times = method.getAnnotation(Times.class).times();
                while (times > 0){
                    method.invoke(employee);
                    times--;
                }
            }
        }
    }
}
