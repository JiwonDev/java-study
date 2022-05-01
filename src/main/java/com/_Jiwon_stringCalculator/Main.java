package com._Jiwon_stringCalculator;

import com._Jiwon_stringCalculator.domain.Calculator;
import com._Jiwon_stringCalculator.domain.StringConverter;
import com._Jiwon_stringCalculator.infrastructure.ConsoleInterface;
import com._Jiwon_stringCalculator.view.RequestView;
import com._Jiwon_stringCalculator.view.ResponseView;
import com._Jiwon_stringCalculator.view.UserInterface;
import java.util.List;

public final class Main {

    public static void main(String[] args) {
        var calculator = new Calculator();
        var stringConverter = new StringConverter();

        UserInterface userInterface = new ConsoleInterface();
        var requestView = new RequestView(userInterface);
        var responseView = new ResponseView(userInterface);


        // TODO 도메인 진입점인 Controller 구현
        var input = requestView.getRequest();
        List<Double> tokens = stringConverter.convert(input);
        double result = calculator.calculate(tokens);
        responseView.toResponse(result);
    }

}
