package by.aleksandrov.api.homework6;

import java.io.IOException;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) throws IOException {
        Cat cat1 = new Cat("Барсик", "Рыжий", "Зеленый", 6.2, "Беспородный");
        System.out.println(cat1);

        Cat cat2 = new Cat("Барсик", "Рыжий", "Зеленый", 6.2, "Беспородный");

        System.out.println(cat1.equals(cat2)); // сравнение двух объектов

        HashSet<Cat> hashCat = new HashSet<>();
        Cat cat3 = new Cat("Мурзик", "Черный", "Голубой", 4.7, "Беспородный");
        Cat cat4 = new Cat("Марсик", "Пятнистый", "Серый", 10.4, "Сибирский");

        hashCat.add(cat1);
        hashCat.add(cat2);
        hashCat.add(cat3);
        hashCat.add(cat4);

        System.out.println(hashCat);
    }
}