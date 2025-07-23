package com.symphony.p1;

import java.io.*;

public class SerialBreak {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singleton = Singleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.ser"));
        objectOutputStream.writeObject(singleton);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.ser"));
        Singleton singleton1 = (Singleton) objectInputStream.readObject();
        System.out.println(singleton1);
        System.out.println(singleton);
    }
}
