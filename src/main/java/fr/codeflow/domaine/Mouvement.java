package fr.codeflow.domaine;

import java.text.MessageFormat;
import java.util.Arrays;

public enum Mouvement {

    AVANCER('A'),
    ROTATION_GAUCHE('G'),
    ROTATION_DROITE('D');

    private final char code;

    Mouvement(char code) {
        this.code = code;
    }

    public static Mouvement valueOfCode(char code) {
        return Arrays.stream(Mouvement.values())
                .filter(direction -> direction.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("Mouvement {0} inconnue ", code)));

    }

    public char getCode() {
        return code;
    }
}
