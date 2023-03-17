package bullscows;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String secCode = getSecretCode();
        if (!"Error".equals(secCode)) {
            startGame(secCode);
        }
    }

    public static String getSecretCode() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Input the length of the secret code:");
        int numOfDigits = scanner.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int posSymb = scanner.nextInt();

        if (numOfDigits < 0 || numOfDigits > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", numOfDigits);
            return "Error";
        } else if (posSymb < numOfDigits) {
            System.out.println("Error");
            return "Error";
        }

        StringBuilder secCode = new StringBuilder(numOfDigits);
        StringBuilder numStr = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
        String info = "*".repeat(numOfDigits) + " (0-" +
                (posSymb <= 9 ? numStr.charAt(posSymb - 1) + ")." : "9, a-" + numStr.charAt(posSymb - 1) + ").");

        while (numOfDigits != 0) {
            int point = random.nextInt(0, posSymb);
            secCode.append(numStr.charAt(point));
            numStr.deleteCharAt(point);
            numOfDigits--;
            posSymb--;
        }
        System.out.println("The secret is prepared: " + info);
        return secCode.toString();
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