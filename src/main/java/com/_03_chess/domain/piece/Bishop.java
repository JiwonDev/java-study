package com._03_chess.domain.piece;

import com._03_chess.domain.Movement;
import java.util.List;

public final class Bishop implements AbstractPiece {

    private final List<Movement> boundary = List.of(Movement.INFINITE_DIAGONAL);
    private static final String NAME = "Bishop";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public List<Movement> getBoundary() {
        return boundary;
    }

}
