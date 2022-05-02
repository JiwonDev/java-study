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

    private int sum(String[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Integer.parseInt(nums[i]);
        }
        return result;
    }


    public int calculate (String strFormula) {
        String[] splitArr = splitFormula(strFormula);
        List<String> formula = makeFormula(splitArr);
        int result =  doArithmetic(formula);
        return result;
    }


    private String[] splitFormula (String strFormula) {
        strFormula.replace(" ", "");
        String[] splitArr = strFormula.split("");
        return splitArr;
    }

    private List<String> makeFormula (String[] splitArr) {
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

            if (exceptionCnt > 1) {
                formula.clear();
                break;
            }
        }
        formula.add(num);
        return formula;
    }


    private int doArithmetic (List<String> formula) {
        int result = 0;
        int i = 1;
        do {
            try {
                int num1 = Integer.parseInt(formula.get(i-1));
                int num2 = Integer.parseInt(formula.get(i+1));
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
