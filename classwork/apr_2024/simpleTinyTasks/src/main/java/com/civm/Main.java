package com.civm;

public class Main {

    static int binaryAddition(String a, String b) {
        return decimalToBinary(binaryToDecimal(a) + binaryToDecimal(b));
    }

    static int binaryToDecimal(String numberTxt){
        int number = stringToInt(numberTxt);
        int sum = 0;
        int count = 0;
        do {
            int digit = number % 10;
            int value = digit * (int) Math.pow(2, count);
            number = number / 10;
            sum += value;
            count++;

        } while (number != 0);
        return sum;
    }

    static int stringToInt(String numberTxt){
        return Integer.parseInt(numberTxt);
    }

    static int decimalToBinary(int decimal){

        String numberTxt = "";
        while (decimal != 0){

            if (decimal % 2 == 1) numberTxt = numberTxt + "1";
            else numberTxt = numberTxt + "0";
            decimal = decimal / 2;
        }
        return Integer.parseInt(numberTxt);
    }
}