package com._Jiwon_stringCalculator.view;

public final class RequestView {

    private final UserInterface userInterface;

    public RequestView(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public String getRequest() {
        userInterface.print("연산식을 입력하세요:");
        return userInterface.getString();
    }
}
