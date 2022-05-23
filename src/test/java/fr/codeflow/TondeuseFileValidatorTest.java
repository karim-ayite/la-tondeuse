package fr.codeflow;

import fr.codeflow.outils.TondeuseFileValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseFileValidatorTest {

    public static final List<String> VALID_FILE_CONTENT = List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");

    public static final List<String> INVALID_PELOUSE_POINT_SUPERIEUR_DROIT = List.of("0 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");

    public static final List<String> INVALID_TONDEUSE_INITIAL_POSITION = List.of("5 5", "1 2 X", "GAGAGAGAA", "3 3 E", "AADAADADDA");

    public static final List<String> INVALID_TONDEUSE_SEQUENCE_MOUVEMENTS = List.of("5 5", "1 2 N", "GAGXXXAA", "3 3 E", "AATTTAADADDA");

    @Test
    @DisplayName("Should throw a IllegalStateException when file is empty")
    void shouldTrowAIllegalStateWhenFileIsEmpty() {
        ArrayList<String> emptyLines = new ArrayList<>();
        Exception exception = assertThrows(IllegalStateException.class, () -> TondeuseFileValidator.validate(emptyLines));

        assertEquals(TondeuseFileValidator.ERROR_MESSAGE_EMPTY_FILE, exception.getMessage());
    }


    @Test
    @DisplayName("Should throw a IllegalStateException when tondeuse initial position is invalid")
    void shouldThrowAIllegalStateExceptionWhenTondeuseInitialPositionIsInvalid() {
        Exception exception = assertThrows(IllegalStateException.class, () -> TondeuseFileValidator.validate(INVALID_TONDEUSE_INITIAL_POSITION));
        assertEquals(TondeuseFileValidator.ERROR_MESSAGE_INVALID_FILE_CONTENT, exception.getMessage());
    }

    @Test
    @DisplayName("Should throw a IllegalStateException when tondeuse sequence mouvement is invalid")
    void shouldThrowAIllegalStateExceptionWhenTondeuseSequenceMouvementIsInvalid() {
        Exception exception = assertThrows(IllegalStateException.class, () -> TondeuseFileValidator.validate(INVALID_TONDEUSE_SEQUENCE_MOUVEMENTS));
        assertEquals(TondeuseFileValidator.ERROR_MESSAGE_INVALID_FILE_CONTENT + " : X n'est pas une mouvement valide", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw a IllegalStateException when pelouse point superieur droit is invalid")
    void shouldThrowAIllegalStateExceptionWhenPelousePointSuperieurDroitIsInvalid() {
        Exception exception = assertThrows(IllegalStateException.class, () -> TondeuseFileValidator.validate(INVALID_PELOUSE_POINT_SUPERIEUR_DROIT));
        assertEquals(TondeuseFileValidator.ERROR_MESSAGE_INVALID_FILE_CONTENT, exception.getMessage());
    }

    @Test
    @DisplayName("Should success when file content is valid")
    void shouldSuccessWhenFileContentIsValid() {
        assertTrue(TondeuseFileValidator.validate(VALID_FILE_CONTENT));
    }
}