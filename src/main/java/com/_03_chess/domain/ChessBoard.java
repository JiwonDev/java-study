package com._03_chess.domain;

import java.util.ArrayList;
import java.util.List;

public final class ChessBoard {

    public void init() {
    }

    public List<Piece> printAllLocation() {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            pieces.add(new Piece());
        }
        return pieces;
    }
}
