package fr.codeflow;

import fr.codeflow.domaine.Direction;
import fr.codeflow.outils.IntructionsMouvementReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.codeflow.TondeuseFileValidatorTest.VALID_FILE_CONTENT;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntructionsMouvementReaderTest {

    @Test
    @DisplayName("Should create a list of InstructionsMouvement")
    void shouldCreateAListOfTondeuseExpeditions() {
        var instructionMouvements = IntructionsMouvementReader.read(VALID_FILE_CONTENT);
        assertEquals(2, instructionMouvements.size());

        var instructionMouvement = instructionMouvements.get(0);

        assertAll(
                () -> assertEquals(1, instructionMouvement.tondeuse().positionX()),
                () -> assertEquals(2, instructionMouvement.tondeuse().positionY()),
                () -> assertEquals(Direction.NORD, instructionMouvement.tondeuse().direction()),
                () -> assertEquals("GAGAGAGAA", instructionMouvement.instructions())
        );

        var instructionMouvement2  = instructionMouvements.get(1);

        assertAll(
                () -> assertEquals(3, instructionMouvement2.tondeuse().positionX()),
                () -> assertEquals(3, instructionMouvement2.tondeuse().positionY()),
                () -> assertEquals(Direction.EST, instructionMouvement2.tondeuse().direction()),
                () -> assertEquals("AADAADADDA", instructionMouvement2.instructions())
        );


    }

}