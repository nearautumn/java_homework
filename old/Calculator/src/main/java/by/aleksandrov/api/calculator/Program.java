package by.aleksandrov.api.calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Program {


    private static ArrayDeque<String> history = new ArrayDeque<>();


    public static void main(String[] args)  {

        calc();

    }

    private static void calc() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите операцию (+ - * /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();
        int res;
        String message;
        switch (op) {
            case '+':
                res = add(a, b);

                message = a + " + " + b + " = " + res;
                System.out.println(message);
                history.addFirst(message);
                break;
            case '-':
                res = minus(a, b);

                message = a + " - " + b + " = " + res;
                System.out.println(message);
                history.addFirst(message);
                break;
            case '*':
                res = multi(a, b);

                message = a + " * " + b + " = " + res;
                System.out.println(message);
                history.addFirst(message);
                break;
            case '/':
                res = divide(a, b);

                message = a + " / " + b + " = " + res;
                System.out.println(message);
                history.addFirst(message);
                break;
            default:

                System.out.println("Wrong operation!");
                break;
        }
        System.out.println("Введите любое слово чтобы продолжить, n для выхода, h для просмотра истории");
        switch (scanner.next()) {
            case ("n"): break;
            case ("h"):
                history.forEach(e -> System.out.println(e));
            default: calc();
        }
    }

    private static int divide(int a, int b) {
        if (b != 0) return a / b;
        return -1;
    }

    private static int multi(int a, int b) {
        return a * b;
    }

    private static int minus(int a, int b) {
        return a - b;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    public static void logStep(FileWriter fw, String note) throws IOException {
        fw.write(new Timestamp(System.currentTimeMillis()) + " " + note + "\n");
    }

}

