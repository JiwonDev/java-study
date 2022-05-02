package com._Changhan_stringCalculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public final class Calculator {
    String REGEX = "[X/+*%]";

    public void calculate() throws ScriptException, NumberFormatException {
        System.out.println("식을 입력하세요");
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        if (formula.startsWith(REGEX)){
            throw new ScriptException("잘못된 식입니다");
        }



        var manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JS");
        Object result;
        switch(scriptEngine.eval(formula).getClass().getSimpleName()){
            case "Integer":
                result = (Integer) scriptEngine.eval(formula);
                System.out.println(result);
                break;
            case "Double":
                result = (Double) scriptEngine.eval(formula);
                System.out.println(result);
        }
    }
}
