package com._03_chess.domain.piece;

import com._03_chess.domain.Movement;
import java.util.List;

public final class Rook implements AbstractPiece {

    private final List<Movement> boundary = List.of(
        Movement.INFINITE_CARDINAL
    );
    private static final String NAME = "Rook";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public List<Movement> getBoundary() {
        return boundary;
    }
}
