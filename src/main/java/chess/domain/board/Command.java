package chess.domain.board;

import chess.controller.ChessController;
import chess.domain.ChessGame;

import java.util.Arrays;
import java.util.function.BiConsumer;

public enum Command {
    START("start", ChessController::start),
    END("end", ChessController::end),
    MOVE("move", ChessController::move),
    STATUS("status", ChessController::status);

    private final String command;
    BiConsumer<ChessGame, Commands> function;

    Command(String command, BiConsumer<ChessGame, Commands> function) {
        this.command = command;
        this.function = function;
    }

    public static Command of(String input) {
        return Arrays.stream(values())
                .filter(value -> input.equals(value.command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 명령어 입니다."));
    }

    public void apply(ChessGame chessGame, Commands command) {
        function.accept(chessGame, command);
    }
}
