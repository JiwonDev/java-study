package com._03_chess.domain.piece;

import com._03_chess.domain.Movement;
import java.util.List;

public final class King implements AbstractPiece {

    private final List<Movement> boundary = List.of(
        Movement.CARDINAL,
        Movement.DIAGONAL);

    private final static String NAME = "King";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public List<Movement> getBoundary() {
        return boundary;
    }
}
