package chess.piece;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import chess.board.Position;
import chess.fixture.EmptyBoardFixture;
import chess.fixture.PositionFixture;

class BishopTest {

    private Map<Position, Piece> board;

    @BeforeEach
    void setUp() {
        board = new EmptyBoardFixture().getBoard();
    }

    @Nested
    class 비숍이_움직일_때_이동방향은_ {
        @Test
        void 대각선이다() {
            //given
            Bishop bishop = new Bishop(Team.WHITE);

            Position from = PositionFixture.A1;
            Position to = PositionFixture.H8;

            //when & then
            assertDoesNotThrow(() -> bishop.validateMove(from, to, board));
        }

        @Test
        void 대각선이_아니면_예외() {
            //given
            Bishop bishop = new Bishop(Team.WHITE);

            Position from = PositionFixture.A1;
            Position to = PositionFixture.B8;

            //when & then
            assertThatThrownBy(() -> bishop.validateMove(from, to, board))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Bishop이 이동할 수 없는 경로입니다.");
        }
    }
}
