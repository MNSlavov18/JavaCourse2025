package Homework;

import java.util.Scanner;

public class DigitRotation {
    public static int countValidNumbers(int bottom, int top, int difference) {
        int count = 0;
        for (int num = bottom; num <= top; num++) {
            int rotated = rotateFirstDigit(num);
            if (rotated - num > difference) {
                count++;
            }
        }
        return count;
    }

    private static int rotateFirstDigit(int num) {
        String strNum = String.valueOf(num);
        if (strNum.length() < 2) {
            return num;
        }
        String rotatedStr = strNum.substring(1) + strNum.charAt(0);
        return Integer.parseInt(rotatedStr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottom = scanner.nextInt();
        int top = scanner.nextInt();
        int difference = scanner.nextInt();
        scanner.close();

        if (bottom < 0 || top < 0) {
            System.out.println(0);
        } else {
            System.out.println(countValidNumbers(bottom, top, difference));
        }
    }
}