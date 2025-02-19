package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
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

        try (Scanner scanner1 = new Scanner(circle)) {
            centerX = scanner1.nextDouble();
            centerY = scanner1.nextDouble();
            radius = scanner1.nextDouble();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл с данными окружности не найден: " + e.getMessage());
            return;
        }

        try (Scanner scanner2 = new Scanner(dote)) {
            while (scanner2.hasNextLine()) {
                String[] array1 = scanner2.nextLine().split(" ");
                double x = Double.parseDouble(array1[0]);
                double y = Double.parseDouble(array1[1]);

                int с = calculatePointPosition(x, y, centerX, centerY, radius);
                if (с == 0) {
                    System.out.println("0");
                } else if (с == 1) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл с точками не найден: " + e.getMessage());
        }
    }

    public static int calculatePointPosition(double x, double y, double centerX, double centerY, double radius) {
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        if (distance == radius) {
            return 0;
        } else if (distance < radius) {
            return 1;
        } else {
            return 2;
        }
    }

}

