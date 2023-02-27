package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfDigits = scanner.nextInt();

        StringBuilder secCode = new StringBuilder();

        if (numOfDigits <= 10) {
            String pseudoRandomNumber;
            do {
                pseudoRandomNumber = Long.toString(System.nanoTime());
            } while (pseudoRandomNumber.length() < numOfDigits && pseudoRandomNumber.charAt(0) != '0');
            for (int i = 0; i < numOfDigits; i++) {
                secCode.append(pseudoRandomNumber.charAt(i));
            }
            System.out.printf("The random secret number is %s.", secCode);
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", numOfDigits);
        }
    }
}