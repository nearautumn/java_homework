package by.aleksandrov.api.homework2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите задание: ");
        System.out.println("1 - Задача 1");
        System.out.println("2 - Задача 2");
        System.out.println("3 - Задача 3");
        int userChoice = Integer.parseInt(sc.nextLine());

        switch (userChoice) {
            case 1:
//                task1();
//                break;
            case 2:
                task2();
                break;
            case 3:
//                task3();
//                break;
            default:
                System.out.println("Некорректный номер задачи!");
                break;
        }
    }

    static void task2() throws IOException {

        System.out.println("Сортировка пузырьком с записью в лог...");

        double[] numbers = new double[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random() * 10;
        }
        //System.out.println(Arrays.toString(numbers));
        String out = Arrays.toString(numbers) + '\n';

        File log = new File("log_task2.txt");
        FileWriter fw = new FileWriter(log, true);
        fw.write("Initial array: ");
        fw.write(out);


        double temp;

        fw.write("Sorting... \n");
        for (int i = 0; i < numbers.length-1; i++ ) {
            for (int j = numbers.length - 1; j > i;  j--) {
                if (numbers[j - 1] > numbers[j]) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                    out = Arrays.toString(numbers) + '\n';
                    fw.write(out);
                }
            }
        }
        fw.close();
        System.out.println("Файл записан!");
        //System.out.println(Arrays.toString(numbers));




    }
}
