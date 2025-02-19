package Task4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Необходимо передать один аргумент: путь к файлу с числами.");
        }

        String aPath = args[0];
        File numbers = new File(aPath);
        List<Integer> nums = new ArrayList<>();

         Scanner scanner = new Scanner(numbers);
            while (scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            }

        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int totalMoves = 0;
        for (int num : nums) {
            totalMoves += Math.abs(num - median);
        }
        System.out.println(totalMoves);
        }
    }