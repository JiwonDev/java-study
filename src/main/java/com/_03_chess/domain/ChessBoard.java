package com._03_chess.domain;

import com._03_chess.domain.piece.AbstractPiece;
import com._03_chess.domain.piece.Queen;
import java.util.ArrayList;
import java.util.List;

public final class ChessBoard {

    List<AbstractPiece> pieces = new ArrayList<>();

    public List<AbstractPiece> getCurrentPieces() {
        List<AbstractPiece> pieces = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            pieces.add(new Queen());
        }
        return pieces;
    }

    public List<AbstractPiece> getActiveUnit(String id) {
        List<AbstractPiece> pieces = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            pieces.add(new Queen());
        }
        return pieces;

    }
}
