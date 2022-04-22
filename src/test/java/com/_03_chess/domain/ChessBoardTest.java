package com._03_chess.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessBoardTest {
    
    @Test
    @DisplayName("초기의 모든 말의 위치를 표시한다.")
    void ChessBoardTest() throws Exception {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.init();
        List<Piece> pieces = chessBoard.printAllLocation();
        int totalPieces = 32;
        assertThat(pieces.size()).isEqualTo(totalPieces);
    }

}
