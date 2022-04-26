package com._03_chess.domain;

import static org.assertj.core.api.Assertions.*;

import com._03_chess.domain.piece.AbstractPiece;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessBoardTest {

    @Test
    @DisplayName("초기 체스판은 32개의 말을 가진다.")
    void checkPiecesCount() throws Exception {
        ChessBoard chessBoard = new ChessBoard();
        List<AbstractPiece> pieces = chessBoard.getCurrentPieces();
        int totalPieces = 32;

        assertThat(pieces.size()).isEqualTo(totalPieces);
    }

    @Test
    @DisplayName("해당 플레이어가 선택할 수 있는 체스말들을 제공한다.")
    void getActiveUnit() throws Exception {
        var chessBoard = new ChessBoard();
        final var initChessActiveCount = 16;
        var player = Player.of();

        List<AbstractPiece> activeUnit = chessBoard.getActiveUnit(player.getId());

        assertThat(activeUnit.size()).isEqualTo(initChessActiveCount);
    }

    @Test
    @DisplayName("해당 체스말이 선택할 수 있는 행동들을 제공한다.")
    void getActions() throws Exception {

    }

    @Test
    @DisplayName("체스말을 움직인다.")
    void playChessUnit() throws Exception {

    }




}
