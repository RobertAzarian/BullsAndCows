package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String secCode = getSecretCode();
        startGame(secCode);
    }


    public static String getSecretCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int numOfDigits = scanner.nextInt();

        StringBuilder secCode = new StringBuilder();

        if (numOfDigits <= 10) {
            String pseudoRandomNumber;
            do {
                pseudoRandomNumber = Long.toString(System.nanoTime());
            } while (pseudoRandomNumber.length() < numOfDigits || pseudoRandomNumber.charAt(0) == '0');
            for (int i = 0; i < numOfDigits; i++) {
                secCode.append(pseudoRandomNumber.charAt(i));
            }
            return secCode.toString();
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", numOfDigits);
            return "Error";
        }
    }

    public static void startGame(String secCode) {
        Scanner scanner = new Scanner(System.in);
        char[] secCodeArr = secCode.toCharArray();
        char[] numberArr;
        String inNumber;
        int bulls = 0;
        int cows = 0;

        boolean isRunning = true;
        int round = 0;
        System.out.println("Okay, let's start a game!");

        while (isRunning) {
            round++;

            // Input
            System.out.printf("Turn %d:\n", round);
            inNumber = scanner.nextLine();
            numberArr = inNumber.toCharArray();

            for (int i = 0; i < numberArr.length; i++) {
                for (int j = 0; j < secCode.length(); j++) {
                    if (numberArr[i] == secCodeArr[i]) {
                        bulls++;
                        break;
                    } else if (numberArr[i] == secCodeArr[j]) {
                        cows++;
                        break;
                    }
                }
            }

            // Output
            System.out.print("Grade: ");
            if (bulls != 0) {
                System.out.printf("%d bull" + (bulls == 1 ? "" : "s"), bulls);
                if (bulls == secCode.length()) {
                    System.out.print("\nCongratulations! You guessed the secret code.");
                    isRunning = false;
                }
                if (cows != 0) {
                    System.out.printf(" and %d cow" + (cows == 1 ? "" : "s"), cows);
                }
            } else if (cows != 0) {
                System.out.printf("%d cow" + (cows == 1 ? "" : "s"), cows);
            } else {
                System.out.print("None");
            }
            System.out.println();
            bulls = 0;
            cows = 0;
        }
    }
}