package fr.codeflow.domaine;

import java.text.MessageFormat;
import java.util.Arrays;

public enum Direction {

    NORD('N'),
    SUD('S'),
    EST('E'),
    OUEST('W');

    private final char code;

    Direction(char code) {
        this.code = code;
    }

    public static Direction valueOfCode(char code) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("Action {0} inconnue ", code)));
    }

    public char getCode() {
        return code;
    }
}
