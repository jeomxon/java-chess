package chess.piece;

import chess.board.File;
import chess.board.Position;
import chess.board.Rank;

public class King extends Piece {

    public King(final Team team) {
        super(team);
    }

    @Override
    public boolean isMovable(final Position from, final Position to, final Piece toPiece) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("제자리로는 움직일 수 없습니다.");
        }
        if (this.team == toPiece.team) {
            throw new IllegalArgumentException("목적지에 같은 색의 말이 존재하여 이동할 수 없습니다.");
        }

        boolean isFileIntervalOne = File.calculateInterval(from.getFile(), to.getFile()) <= 1;
        boolean isRankIntervalOne = Rank.calculateInterval(from.getRank(), to.getRank()) <= 1;

        if (isFileIntervalOne && isRankIntervalOne) {
            return true;
        }
        throw new IllegalArgumentException("King이 이동할 수 없는 경로입니다.");
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
