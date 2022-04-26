package com._03_chess.domain;

import lombok.Getter;

@Getter
public final class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
