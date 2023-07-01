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
//            case 2:
//                  task2();
//                break;
//            case 3:
//                task3();
//                break;
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
        
    }
}
