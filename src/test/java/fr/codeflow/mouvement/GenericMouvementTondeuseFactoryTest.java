package fr.codeflow.mouvement;

import fr.codeflow.domaine.Mouvement;
import fr.codeflow.domaine.Direction;
import fr.codeflow.domaine.Pelouse;
import fr.codeflow.domaine.Tondeuse;
import fr.codeflow.outils.TondeuseFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericMouvementTondeuseFactoryTest {

    private final MouvementTondeuseFactory mouvementTondeuseFactory = new GenericMouvementTondeuseFactory();

    private Tondeuse tondeuseToGuide;

    @BeforeEach
    void setUp() {
        tondeuseToGuide = TondeuseFactory.createTondeuse(6, 5, Direction.EST, "AADAADADA");

    }

    @Test
    @DisplayName("Should create a AvancerAction")
    void shouldCreateAAvancerAction() {

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.AVANCER, tondeuseToGuide, new Pelouse(10, 10));
        assertTrue(guidanceAction instanceof AvancerMouvementTondeuse);
    }

    @ParameterizedTest
    @DisplayName("Should create a RotationAction")
    @ValueSource(chars = {
          'D','G'
    })
    void shouldCreateARotationAction(char action) {

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode(action), tondeuseToGuide, new Pelouse(10, 10));
        assertTrue(guidanceAction instanceof RotationMouvementTondeuse);
    }

}