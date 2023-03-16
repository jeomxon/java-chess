package chess.piece;

import chess.board.Position;
import chess.board.Rank;

public class Pawn extends Piece {

    public Pawn(final Team team) {
        super(team);
    }

    @Override
    public boolean isMovable(final Position from, final Position to, final Piece toPiece) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("제자리로는 움직일 수 없습니다.");
        }

        int fileInterval = Math.abs(from.getFile().getIndex() - to.getFile().getIndex());

        if (team == Team.BLACK) {

            int rankInterval = from.getRank().getIndex() - to.getRank().getIndex();

            if (rankInterval == 1 && fileInterval == 1 && toPiece.isWhite()) {
                return true;
            }
            if (from.getRank() == Rank.SEVEN) {
                if (from.getRank().getIndex() - to.getRank().getIndex() <= 2 && from.getFile() == to.getFile()) {
                    return true;
                }
                throw new IllegalArgumentException("Pawn이 이동할 수 없는 경로입니다.");
            }

            if (from.getRank().getIndex() - to.getRank().getIndex() == 1 && !toPiece.isEmpty()) {
                return true;
            }
        }

        if (team == Team.WHITE) {

            int rankInterval = to.getRank().getIndex() - from.getRank().getIndex();

            if (rankInterval == 1 && fileInterval == 1 && toPiece.isBlack()) {
                return true;
            }

            if (from.getRank() == Rank.TWO) {
                if (to.getRank().getIndex() - from.getRank().getIndex() <= 2 && to.getFile() == from.getFile()) {
                    return true;
                }
                throw new IllegalArgumentException("Pawn이 이동할 수 없는 경로입니다.");
            }

            if (to.getRank().getIndex() - from.getRank().getIndex() == 1 && !toPiece.isEmpty()) {
                return true;
            }
        }

        throw new IllegalArgumentException("Pawn이 이동할 수 없는 경로입니다.");
    }

    @Override
    public boolean isPawn() {
        return true;
    }
}
