package Homework;

import java.util.Scanner;

public class SumTask {

    public static int SumGeneratedNumbers(int size)
    {
        int sum = 0;

        if (size < 1 || size > 9)
        {
            return 0;
        }

        for (int i = 1; i <= size; i++)
        {
            for (int j = i; j <= size; j++)
            {
                sum += (j*2);
            }
        }

        return (sum*2) - (size*2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();
        System.out.println(SumGeneratedNumbers(size));
    }
}

