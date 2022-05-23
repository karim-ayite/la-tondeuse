package fr.codeflow.mouvement;

import fr.codeflow.domaine.Mouvement;
import fr.codeflow.domaine.Direction;
import fr.codeflow.domaine.Pelouse;
import fr.codeflow.outils.TondeuseFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotationMouvementTondeuseTest {

    private final MouvementTondeuseFactory mouvementTondeuseFactory = new GenericMouvementTondeuseFactory();


    @ParameterizedTest
    @MethodSource("provideCharsForRotationMouvement")
    @DisplayName("Should rotate tondeuse depending of the current direction and rotation mouvement")
    void shouldRotateTondeuseDependingOfTheCurrentDirectionAndMouvementTondeuse(char currentDirection,char rotationMouvement,char expectedDirection) {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(0, 0, Direction.valueOfCode(currentDirection), "AADAADADA");

        var mouvementTondeuse = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode(rotationMouvement), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = mouvementTondeuse.execute();

        assertEquals(Direction.valueOfCode(expectedDirection),movedTondeuse.direction());
    }

    private static Stream<Arguments> provideCharsForRotationMouvement() {
        return Stream.of(
                Arguments.of('N', 'G','W'),
                Arguments.of('N', 'D','E'),
                Arguments.of('E', 'G','N'),
                Arguments.of('E', 'D','S'),
                Arguments.of('S', 'G','E'),
                Arguments.of('S', 'D','W'),
                Arguments.of('W', 'G','S'),
                Arguments.of('W', 'D','N')
        );
    }






}