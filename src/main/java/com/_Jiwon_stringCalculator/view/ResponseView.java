package com._Jiwon_stringCalculator.view;

public final class ResponseView {

    private final UserInterface userInterface;

    public ResponseView(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void toResponse(double result) {
        userInterface.print("결과는 :" + result);
    }
}
