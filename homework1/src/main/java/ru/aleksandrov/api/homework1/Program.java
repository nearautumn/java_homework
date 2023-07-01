package ru.aleksandrov.api.homework1;

import java.util.Scanner;

public class Program {

    static  Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Выберите задание: ");
        System.out.println("1 - Задача 1");
        System.out.println("2 - Задача 2");
        System.out.println("3 - Задача 3");
        System.out.println("4 - Задача 4");
        int userChoice = Integer.parseInt(sc.nextLine());

        switch (userChoice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
//            case 4:
//                task4();
//                break;
            default:
                System.out.println("Некорректный номер задачи!");
                break;
        }
    }

    static void task1()  {
        // 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        System.out.println("Задание: Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)");
        System.out.print("Введите число: ");
        int userNumber = Integer.parseInt(sc.nextLine());
        // находим треугольное число
        int triangle = 0;
        for (int i = 1; i <= userNumber; i++) {
            triangle = triangle + i;
        }
        System.out.printf("%d-ое треугольное число равняется %d\n", userNumber, triangle);
        // находим факториал
        int factorial = 1;
        for (int i = 1; i <= userNumber; i++) {
            factorial = factorial * i;
        }
        System.out.printf("Факториал числа %d равен %d", userNumber, factorial);
    }

    static void task2() {
        // 2) Вывести все простые числа от 1 до 1000
        System.out.println("Список простых чисел от 1 до 1000");
        for (int i = 2; i < 1000; i++) {
            boolean a = true;
            int q = (int) Math.sqrt(i);
            for (int j = 2; j <= q; j++) {
                if ((i % j) == 0) {
                    a = false;
                    break;
                }
            }
            if (a) {
                System.out.println(i);
            }
        }
    }
    static void task3() {
        // 3) Реализовать простой калькулятор
        System.out.println("Калькулятор");
        System.out.println("Выберите действие");
        System.out.println("1 - Сложение");
        System.out.println("2 - Вычитание");
        System.out.println("3 - Умножение");
        System.out.println("4 - Деление");
        System.out.println("5 - Возведение в степень");
        System.out.println("6 - Квадратный корень");

        int userChoice = Integer.parseInt(sc.nextLine());

        switch (userChoice) {
            case 1:
                System.out.print("Введите первое число: ");
                double a = Double.parseDouble(sc.nextLine());
                System.out.print("Введите второе число: ");
                double b = Double.parseDouble(sc.nextLine());
                System.out.printf("%f + %f = %f", a, b, (a + b));
            case 2:
                System.out.print("Введите первое число: ");
                double c = Double.parseDouble(sc.nextLine());
                System.out.print("Введите второе число: ");
                double d = Double.parseDouble(sc.nextLine());
                System.out.printf("%f -  %f = %f", c, d, (c - d));
            case 3:
                System.out.print("Введите первое число: ");
                double e = Double.parseDouble(sc.nextLine());
                System.out.print("Введите второе число: ");
                double f  = Double.parseDouble(sc.nextLine());
                System.out.printf("%f * %f = %f", e, f, (e * f));
            case 4:
                System.out.print("Введите первое число: ");
                double g = Double.parseDouble(sc.nextLine());
                System.out.print("Введите второе число: ");
                double h = Double.parseDouble(sc.nextLine());
                System.out.printf("%f / %f = %f", g, h, (g / h));
            case 5:
                System.out.print("Введите число: ");
                double i = Double.parseDouble(sc.nextLine());
                System.out.print("Введите степень: ");
                double j = Double.parseDouble(sc.nextLine());
                System.out.printf("%f в степени %f = %f", i, j, (Math.pow(i, j)));
            case 6:
                System.out.print("Введите число: ");
                double k  = Double.parseDouble(sc.nextLine());
                System.out.printf("Квадратный корень числа %f = %f", k, (Math.sqrt(k)));
            default:
                System.out.println("Некорректный ввод!");
                break;
        }

    }

}
