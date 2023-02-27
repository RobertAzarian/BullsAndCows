package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String secCode = "9305";
        int bulls = 0;
        int cows = 0;
        char[] secCodeArr = secCode.toCharArray();

        String number = scanner.nextLine(); // 1234
        char[] numberArr = number.toCharArray();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (secCodeArr[i] == numberArr[j]) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }

        // Output
        System.out.print("Grade: ");
        if (bulls != 0) {
            System.out.printf("%d bull(s)", bulls);
            if (cows != 0) {
                System.out.printf(" and %d cow(s)", cows);
            }
        } else if (cows != 0) {
            System.out.printf("%d cow(s)", cows);
        } else {
            System.out.print("None");
        }
        System.out.printf(". The secret code is %s.", secCode);
    }
}