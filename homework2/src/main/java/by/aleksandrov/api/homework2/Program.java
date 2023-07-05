package by.aleksandrov.api.homework2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.logging.FileHandler;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;

public class Program {

            public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите задание: ");
        System.out.println("1 - Задача 1");
        System.out.println("2 - Задача 2");
//        System.out.println("3 - Задача 3");
        int userChoice = Integer.parseInt(sc.nextLine());

        switch (userChoice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
//            case 3:
//                task3();
//                break;
            default:
                System.out.println("Некорректный номер задачи!");
                break;
        }
    }

    static void task1() {
        /**
         * 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя
         * StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
         * Если значение null, то параметр не должен попадать в запрос.
         * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
         */

        System.out.println("Вывод SQL запроса");

        String data = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"}";
        data = data.replace((char)34, (char)32);
        data = data.replace(":", "=");
        data = data.substring(data.indexOf("{")+1, data.indexOf("}"));
        String[] inputArray = data.split(", ");
        String request = "select * from students where";

        StringBuilder sb = new StringBuilder(request);
        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].contains("null")) {
                sb.append(inputArray[i]);
                System.out.println(sb);
                sb = new StringBuilder(sb.delete(sb.indexOf("where ") + 6, sb.length()));
            }
        }
    }

    static void task2() {

        System.out.println("Сортировка пузырьком с записью в лог...");

        double[] numbers = new double[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random() * 10;
        }
        //System.out.println(Arrays.toString(numbers));
        String out = Arrays.toString(numbers) + '\n';

        try {
            File log = new File("log_task2.txt");
            FileWriter fw = new FileWriter(log, true);

            fw.write("Initial array: ");
            fw.write(out);

            double temp;

            fw.write("Sorting... \n");
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = numbers.length - 1; j > i; j--) {
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
        }
        catch (IOException ex) {
            System.out.println("Ошибка записи файла!");
        }
        //System.out.println(Arrays.toString(numbers));
    }

//    static void task3() {
//
//        /**
//         * 3) Дана json-строка (можно сохранить в файл и читать из файла)
//         * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//         * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//         * Пример вывода:
//         * Студент Иванов получил 5 по предмету Математика.
//         * Студент Петрова получил 4 по предмету Информатика.
//         * Студент Краснов получил 5 по предмету Физика.
//         */
//
//        Logger logger = Logger.getLogger(Program.class.getName());
//
//        try {
//            FileHandler fh = new FileHandler("task3_log.txt");
//            logger.addHandler(fh);
//            FileReader fr = new FileReader("task3.txt");
//            Scanner sc = new Scanner(fr);
//            SimpleFormatter sFormat = new SimpleFormatter();
//            fh.setFormatter(sFormat);
//
//
//            String input = sc.nextLine();
//
//            StringBuilder sb = new StringBuilder(input);
//            sb.
//
//            fr.close();
//            logger.log(Level.INFO, "task3.txt успешно загружен!");
//
//            input = input.substring(input.indexOf("[")+1, input.indexOf("]"));
//            String[] inputArr = input.;
//            for (int i = 0; i < inputArr.length; i++) {
//                System.out.println(inputArr[i]);
//            }
//
//        }
//        catch (FileNotFoundException task3NotFound) {
//            System.out.println("Ошибка чтения файла task3.txt!");
//            logger.log(Level.WARNING, "Ошибка чтения файла task3.txt!");
//        }
//        catch (SecurityException sEx) {
//            System.out.println("Ошибка прав доступа!"); // на самом деле я пока не очень понял смысл этого исключения :)
//        }
//        catch (IOException ioExc) {
//            System.out.println("Ошибка доступа к файлу task3_log.txt!");
//        }
//
//    }
}
