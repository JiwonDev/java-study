package com._03_chess.domain.piece;

import com._03_chess.domain.Movement;
import java.util.List;

public interface AbstractPiece {

    String getName();
    List<Movement> getBoundary();
}
