package by.aleksandrov.api.homework3;

import java.util.*;

public class Program {

    /**
     * Пусть дан произвольный список целых чисел.
     * 1) Нужно удалить из него чётные числа
     * 2) Найти минимальное значение
     * 3) Найти максимальное значение
     * 4) Найти среднее значение
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = newRandomArrayList();
        System.out.println("Текущий список: " + numbers);

        System.out.println("Выберите действие:");
        System.out.println("1 - Показать массив без четных чисел");
        System.out.println("2 - Показать минимальное число");
        System.out.println("3 - Показать максимальное число");
        System.out.println("4 - Показать среднее значение");

        try {
            int userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    deleteEvens(numbers);
                    break;
                case 2:
                    printMin(numbers);
                    break;
                case 3:
                    printMax(numbers);
                    break;
                case 4:
                    printAverage(numbers);
                    break;
                default:
                    System.out.println("Некорректный ввод!");
            }

        }
        catch (InputMismatchException inpExc) {
            System.out.println("Некорректный ввод!");
        }
    }

    static ArrayList<Integer> newRandomArrayList() {

        Random rand = new Random();

        int size = rand.nextInt(5, 11);
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultList.add(rand.nextInt(-10, 11));
        }
        return resultList;
    }

    static void deleteEvens(ArrayList<Integer> arrayList) {

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }
        System.out.println(arrayList);
    }

    static void printMin(ArrayList<Integer> arrayList) {

        arrayList.sort(null);
        System.out.println(arrayList.get(0));
    }

    static void printMax(ArrayList<Integer> arrayList) {

        arrayList.sort(null);
        Collections.reverse(arrayList);
        System.out.println(arrayList.get(0));
    }

    static void printAverage(ArrayList<Integer> arrayList) {

        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        double average = (double) sum / (double) arrayList.size();
        System.out.println(average);
    }
}
