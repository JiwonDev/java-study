package com.samsung;

import java.util.ArrayList;
import java.util.List;

public final class StringCal {

    public int add(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        if (str.contains("+")) {
            String[] nums = str.split("\\+");
            return sum(nums);
        } else {
            return 0;
        }
    }

    public int sum(String[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Integer.parseInt(nums[i]);
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////

    /*
    // split
    public String[] split (String str) {
        return str.split("");
    }

    // String -> int
    public int toInt (String str) {
        return Integer.parseInt(str);
    }

    public int calString (String[] str) {
        int result = toInt(str[0]);
        for (int i = 0; i < str.length - 2; i+=2) {
            result = cal(result, toInt(str[i + 2]), str[i + 1].charAt(0));
        }
        return result;
    }

    // calculate
    public int cal (int a, int b, char oper) {
        if (oper == '+')
            return add(a, b);
        else if (oper == '-')
            return sub(a, b);
        else if (oper == '*')
            return mul(a, b);
        else if (oper == '/')
            return div(a, b);
        else System.out.println("잘못된 값");
        return 0;
    }


    // arithmetic
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println("0으로 나눌 수 없음");
        }
        return 0;
    }
*/
    /////////////////////////////////////////////////////////

    public int calculate (String strFormula) {
        String[] splitArr = splitFormula(strFormula);
        List<String> formula = makeFormula(splitArr);
        int result =  arithmetic(formula);
        return result;
    }


    public String[] splitFormula (String strFormula) {
        strFormula.replace(" ", "");
        String[] splitArr = strFormula.split("");
        return splitArr;
    }

    public List<String> makeFormula (String[] splitArr) {
        List<String> formula = new ArrayList<>();
        String num = "";

        for (int i = 0; i < splitArr.length; i++) {
            int exceptionCnt = 0;
            try {
                if (Integer.parseInt(splitArr[i]) >= 0) {
                    num += splitArr[i];
                    exceptionCnt = 0;

                }
            } catch (Exception e) {
                formula.add(num);
                num = "";
                exceptionCnt++;
                formula.add((splitArr[i]));
            }

            if (exceptionCnt > 1) { // operator 연속
                formula.clear();
                break;
            }
        }
        formula.add(num);
        return formula;
    }

    public int arithmetic (List<String> formula) {
        int result = 0,
            i = 1;
        do {
            try {
                int num1 = Integer.parseInt(formula.get(i-1)),
                    num2 = Integer.parseInt(formula.get(i+1));
                String operator = formula.get(i);

                switch (operator) {
                    case "+" :
                        result = num1 + num2;
                        break;

                    case "-" :
                        result = num1 - num2;
                        break;

                    case "*" :
                        result = num1 * num2;
                        break;

                    case "/" :
                        result = num1 / num2;
                        break;
                }

                formula.set(i-1, String.valueOf(result));
                formula.remove(i);
                formula.remove(i);

            } catch (Exception e) {
                if (e instanceof ArithmeticException) {
                    System.out.println("0으로 나눔");
                } else {
                    result = 0;
                    System.out.println("처리할 수 없음" + e.getMessage());
                }
                break;
            }
        } while (i < formula.size());
        return result;
    }
}
