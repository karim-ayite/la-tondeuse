package fr.codeflow;

import fr.codeflow.domaine.Direction;
import fr.codeflow.domaine.Tondeuse;
import fr.codeflow.outils.TondeuseFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.codeflow.domaine.Direction.EST;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TondeuseFactoryTest {

    private Tondeuse existingTondeuse;

    @BeforeEach
    void setUp(){
        existingTondeuse = TondeuseFactory.createTondeuse(6, 5, EST, "AADAADADA");

    }

    @Test
    @DisplayName("Should create a tondeuse with input data")
    void shouldCreateATondeuseWithInputData() {

        var tondeuse = TondeuseFactory.createTondeuse(1, 1, EST, "AADAADADA");

        assertAll(
                () -> assertEquals(1, tondeuse.positionX()),
                () -> assertEquals(1, tondeuse.positionY()),
                () -> assertEquals(EST, tondeuse.direction()),
                () -> assertEquals("AADAADADA", tondeuse.sequenceMouvements())
        );
    }

    @Test
    @DisplayName("Should create a tondeuse from a existing tondeuse with updated direction")
    void shouldCreateATondeuseFromAExistingTondeuseWithUpdatedDirection() {

        var updatedTondeuse = TondeuseFactory.createTondeuseWithUpdatedDirection(existingTondeuse,Direction.valueOfCode('W'));

        assertAll(
                () -> assertEquals(6, updatedTondeuse.positionX()),
                () -> assertEquals(5, updatedTondeuse.positionY()),
                () -> assertEquals(Direction.OUEST, updatedTondeuse.direction()),
                () -> assertEquals("AADAADADA", updatedTondeuse.sequenceMouvements())
        );
    }

    @Test
    @DisplayName("Should create a tondeuse from a existing tondeuse with updated positionX")
    void shouldCreateATondeuseFromAExistingTondeuseWithUpdatedPositionX() {

        var updatedTondeuse = TondeuseFactory.createTondeuseWithUpdatedPositionX(existingTondeuse,8);

        assertAll(
                () -> assertEquals(8, updatedTondeuse.positionX()),
                () -> assertEquals(5, updatedTondeuse.positionY()),
                () -> assertEquals(EST, updatedTondeuse.direction()),
                () -> assertEquals("AADAADADA", updatedTondeuse.sequenceMouvements())
        );
    }

    @Test
    @DisplayName("Should create a tondeuse from a existing tondeuse with updated positionY")
    void shouldCreateATondeuseFromAExistingTondeuseWithUpdatedPositionY() {

        var updatedTondeuse = TondeuseFactory.createTondeuseWithUpdatedPositionY(existingTondeuse,8);

        assertAll(
                () -> assertEquals(6, updatedTondeuse.positionX()),
                () -> assertEquals(8, updatedTondeuse.positionY()),
                () -> assertEquals(EST, updatedTondeuse.direction()),
                () -> assertEquals("AADAADADA", updatedTondeuse.sequenceMouvements())
        );
    }
}