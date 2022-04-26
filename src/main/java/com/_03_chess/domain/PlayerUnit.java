package com._03_chess.domain;

import com._03_chess.domain.piece.AbstractPiece;
import java.util.Date;
import lombok.Getter;

@Getter
public final class PlayerUnit {

    private Position position;
    private AbstractPiece piece;

    public PlayerUnit(Position position) {
        this.position = position;
    }

}
