package com._03_chess;

public final class GameRequest {

    private final boolean status;

    public GameRequest(boolean start) {
        this.status = start;
    }

    public boolean isStatus() {
        return status;
    }
}
