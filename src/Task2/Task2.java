package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class Task2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Необходимо передать два аргумента: путь к файлу с точками и путь к файлу с данными окружности.");
            return;
        }

        String circlePath = args[0];
        String dotePath = args[1];

        File circle = new File(circlePath);
        File dote = new File(dotePath);

        double centerX = 0;
        double centerY = 0;
        double radius = 0;

        try (Scanner scanner1 = new Scanner(circle).useLocale(Locale.US)) {
            if (!scanner1.hasNextDouble()) {
                System.err.println("Ошибка: файл с окружностью содержит некорректные данные.");
                return;
            }
            centerX = scanner1.nextDouble();

            if (!scanner1.hasNextDouble()) {
                System.err.println("Ошибка: файл с окружностью содержит некорректные данные.");
                return;
            }
            centerY = scanner1.nextDouble();

            if (!scanner1.hasNextDouble()) {
                System.err.println("Ошибка: файл с окружностью содержит некорректные данные.");
                return;
            }
            radius = scanner1.nextDouble();
            if (radius < 0) {
                System.err.println("Ошибка: радиус не может быть отрицательным.");
                return;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл с данными окружности не найден: " + e.getMessage());
            return;
        }

        try (Scanner scanner2 = new Scanner(dote).useLocale(Locale.US)) {
            while (scanner2.hasNextLine()) {
                String line = scanner2.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] array1 = line.split(" ");
                if (array1.length !=2) {
                    System.out.println("Ошибка: строка с точкой содержит некорректные данные " + line);
                    continue;
                }

                try {
                    double x = Double.parseDouble(array1[0]);
                    double y = Double.parseDouble(array1[1]);

                int d = calculatePointPosition(x, y, centerX, centerY, radius);
                    System.out.println(d);
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: строка с точкой содержит некорректные данные " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл с точками не найден: " + e.getMessage());
        }
    }

    public static int calculatePointPosition(double x, double y, double centerX, double centerY, double radius) {
        double distance2 = Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2);
        double radius2 = Math.pow(radius, 2);

        if (distance2 == radius2) {
            return 0;
        } else if (distance2 < radius2) {
            return 1;
        } else {
            return 2;
        }
    }

}

