package org.example;

import java.io.*;

//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
//        Обеспечьте поддержку сериализации для этого класса.
//        Создайте объект класса Student и инициализируйте его данными.
//        Сериализуйте этот объект в файл.
//        Десериализуйте объект обратно в программу из файла.
//        Выведите все поля объекта, включая GPA, и ответьте на вопрос,
//        почему значение GPA не было сохранено/восстановлено.

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Илья", 31, 4.8);


        try (FileOutputStream fileOut = new FileOutputStream("student.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(student);
            System.out.println("Объект сериализован и записан в файл 'student.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileInputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Объект успешно десериализован из файла:");
            System.out.println("Имя: " + deserializedStudent.getName());
            System.out.println("Возраст: " + deserializedStudent.getAge());
            System.out.println("GPA: " + deserializedStudent.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}