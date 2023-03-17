package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String secCode = getSecretCode();
        startGame(secCode);
    }

    // Рандом из макс 10 уникальных чисел!
    public static String getSecretCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        final int numOfDigits = scanner.nextInt(); // 4

        if (numOfDigits <= 10) {
            StringBuilder secCode = new StringBuilder(numOfDigits);
            if (numOfDigits > 0) {
                StringBuilder numForSecCode = new StringBuilder
                        (Integer.toString((int) (Math.random() * Math.pow(10, numOfDigits))));
                secCode.append(numForSecCode.charAt(0));
                while (secCode.length() != numOfDigits) {
                    for (int i = 1; i < numForSecCode.length() && secCode.length() != numOfDigits; i++) {
                        for (int j = 0; j < secCode.length(); j++) {
                            if (secCode.charAt(j) == numForSecCode.charAt(i)) {
                                break;
                            }
                            if (j + 1 == secCode.length()) {
                                secCode.append(numForSecCode.charAt(i));
                            }
                        }
                    }
                    numForSecCode = new StringBuilder
                            (Integer.toString((int) (Math.random() * Math.pow(10, numOfDigits))));
                }
            }
            // System.out.println(secCode);
            return secCode.toString();
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", numOfDigits);
            return "Error";
        }

/*
        if (numOfDigits <= 10) {
            StringBuilder secCode = new StringBuilder(numOfDigits);
            if (numOfDigits > 0) {
                StringBuilder numForSecCode = new StringBuilder(Long.toString(System.nanoTime()));
                numForSecCode.reverse();
                secCode.append(numForSecCode.charAt(0));
                while (secCode.length() != numOfDigits) {
                    for (int i = 1; i < numForSecCode.length() && secCode.length() != numOfDigits; i++) {
                        for (int j = 0; j < secCode.length(); j++) {
                            if (secCode.charAt(j) == numForSecCode.charAt(i)) {
                                break;
                            }
                            if (j + 1 == secCode.length()) {
                                secCode.append(numForSecCode.charAt(i));
                            }
                        }
                    }
                    numForSecCode = new StringBuilder(Long.toString(System.nanoTime()));
                    numForSecCode.reverse();
                }
            }
            System.out.println(secCode);
            return secCode.toString();
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", numOfDigits);
            return "Error";
        }*/
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


/*

    public static String getSecretCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        final int numOfDigits = scanner.nextInt();
        StringBuilder secCode = new StringBuilder(Long.toString(System.nanoTime()));
        secCode.reverse().delete(8, secCode.length());
        int count = 1;
        while (numOfDigits > secCode.length()) {
            count++;
            secCode.append(new StringBuilder(Long.toString(System.nanoTime())).reverse());
            secCode.delete(8 * count, secCode.length());
        }
        secCode.delete(numOfDigits, secCode.length());

        return secCode.toString();
    }

*/

    /*
    Рандом из макс 10 уникальных чисел!
    public static String getSecretCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        final int numOfDigits = scanner.nextInt(); // 4

        if (numOfDigits <= 10) {
            StringBuilder secCode = new StringBuilder(numOfDigits);
            if (numOfDigits > 0) {
                StringBuilder numForSecCode = new StringBuilder(Long.toString(System.nanoTime()));
                numForSecCode.reverse();
                secCode.append(numForSecCode.charAt(0));
                while (secCode.length() != numOfDigits) {
                    for (int i = 1; i < numForSecCode.length() && secCode.length() != numOfDigits; i++) {
                        for (int j = 0; j < secCode.length(); j++) {
                            if (secCode.charAt(j) == numForSecCode.charAt(i)) {
                                break;
                            }
                            if (j + 1 == secCode.length()) {
                                secCode.append(numForSecCode.charAt(i));
                            }
                        }
                    }
                    numForSecCode = new StringBuilder(Long.toString(System.nanoTime()));
                    numForSecCode.reverse();
                }
            }
            System.out.println(secCode);
            return secCode.toString();
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", numOfDigits);
            return "Error";
        }
    }
    */



        /*if (numOfDigits > 0) {
            StringBuilder numForSecCode = new StringBuilder(Long.toString(System.nanoTime()));
            numForSecCode.reverse();
            secCode.append(numForSecCode.charAt(0));
            while (secCode.length() < numOfDigits) {
                for (int i = 1; i < numForSecCode.length() || secCode.length() != numOfDigits; i++) {
                    for (int j = 0; j < secCode.length(); j++) {
                        if (numForSecCode.charAt(i) == secCode.charAt(j)) {
                            break;
                        } else if (j == secCode.length() - 1) {
                            secCode.append(numForSecCode.charAt(i));
                        }
                    }
                }
                    numForSecCode =  new StringBuilder(Long.toString(System.nanoTime()));
            }
            System.out.println(secCode);
            return secCode.toString();
        } else {
            return "";
        }*/


        /*boolean isNumbersRepeat = false;
        boolean isNumberShorter;
        boolean isZeroFirst;
        if (numOfDigits <= 10) {
            String pseudoRandomNumber;
            do {
                pseudoRandomNumber = Long.toString(System.nanoTime());
                isNumberShorter = pseudoRandomNumber.length() < numOfDigits;
                isZeroFirst = pseudoRandomNumber.charAt(0) == '0';
                for (int i = 0; !isNumbersRepeat && (i < (numOfDigits - 1)); i++) {
                    for (int j = i + 1; j < numOfDigits; j++) {
                        if (pseudoRandomNumber.charAt(i) == pseudoRandomNumber.charAt(j)) {
                            isNumbersRepeat = true;
                            break;
                        }
                    }
                }
            } while (isNumberShorter || isZeroFirst || !isNumbersRepeat);
            for (int i = 0; i < numOfDigits; i++) {
                secCode.append(pseudoRandomNumber.charAt(i));
            }
            return secCode.toString();
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", numOfDigits);
            return "Error";
        }*/
//  }
