package by.aleksandrov.api.homework4;

import java.util.*;

public class Program {

    /**
     * 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     * 2 *. Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите задание: ");
        System.out.println("1 - Задача 1");
        System.out.println("2 - Задача 2");

        int userChoice = Integer.parseInt(sc.nextLine());

        switch (userChoice) {
            case 1:
                task1();
                break;
            case 2:
//                task2();
//                break;
            default:
                System.out.println("Некорректный номер задачи!");
                break;
        }
    }

    static void task1() {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i < 11; i++) {
            linkedList.add(i);
        }
        System.out.println("Исходный список: " + linkedList);

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < linkedList.size(); i++) {
            deque.push(linkedList.get(i));
        }

        System.out.println("Конечный список: " + deque);
    }

    static void task2() {

    }
}
