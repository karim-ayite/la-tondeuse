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
    @DisplayName("Should create a AvancerMouvementTondeuse")
    void shouldCreateAAvancerMouvementTondeuse() {

        var mouvementTondeuse = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.AVANCER, tondeuseToGuide, new Pelouse(10, 10));
        assertTrue(mouvementTondeuse instanceof AvancerMouvementTondeuse);
    }

    @ParameterizedTest
    @DisplayName("Should create a MouvementTondeuse")
    @ValueSource(chars = {
          'D','G'
    })
    void shouldCreateAMouvementTondeuse(char mouvement) {

        var mouvementTondeuse = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode(mouvement), tondeuseToGuide, new Pelouse(10, 10));
        assertTrue(mouvementTondeuse instanceof RotationMouvementTondeuse);
    }

}