package com.mycompany.creditcardvalidator;

import java.util.Scanner;

// Our main app class
public class CreditCardValidator {

    // Our main class, this is where our Java app will run first
    public static void main(String[] args) {
        
        // Creating an new scanner input object
        Scanner input = new Scanner(System.in);
        
        // We have to store the credit card as a long integer as 
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();

        if (isValid(number)) {
            System.out.println("The credit card number is valid.");
        } else {
            System.out.println("The credit card number is invalid.");
        }
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
        if (getSize(number) < 13 || getSize(number) > 19) {
            return false;
        }
        return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0 &&
               prefixMatched(number, 4);
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = String.valueOf(number);
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(String.valueOf(numStr.charAt(i))) * 2);
        }
        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = String.valueOf(number);
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        String numStr = String.valueOf(d);
        return numStr.length();
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {
        if (getSize(number) < k) {
            return number;
        } else {
            return Long.parseLong(String.valueOf(number).substring(0, k));
        }
    }  
  
}