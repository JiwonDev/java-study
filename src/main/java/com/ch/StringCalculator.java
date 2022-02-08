package com.ch;

public class StringCalculator {

    String CalCulate(String formula) {
        String result;
        int value = 0;
        char firstChar = formula.charAt(0);
        char lastChar = formula.charAt(formula.length() - 1);

        String[] strArr = formula.split("\\+");
        if (!Character.isDigit(firstChar) || !Character.isDigit(lastChar)) {
            return "0";
        }
        for (String strno : strArr) {
            int no = Integer.parseInt(strno);
            value += no;
        }
        result = String.valueOf(value);
        return result;
    }
}
