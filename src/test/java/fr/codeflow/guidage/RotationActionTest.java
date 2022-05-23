package fr.codeflow.guidage;

import fr.codeflow.domaine.Mouvement;
import fr.codeflow.domaine.Direction;
import fr.codeflow.domaine.Pelouse;
import fr.codeflow.mouvement.GenericMouvementTondeuseFactory;
import fr.codeflow.mouvement.MouvementTondeuseFactory;
import fr.codeflow.outils.TondeuseFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotationActionTest {

    private final MouvementTondeuseFactory mouvementTondeuseFactory = new GenericMouvementTondeuseFactory();


    @ParameterizedTest
    @MethodSource("provideCharsForRotationAction")
    @DisplayName("Should rotate tondeuse depending of the current direction and rotation action")
    void shouldRotateTondeuseDependingOfTheCurrentDirectionAndRotationAction(char currentDirection,char rotationAction,char expectedDirection) {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(0, 0, Direction.valueOfCode(currentDirection), "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode(rotationAction), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(Direction.valueOfCode(expectedDirection),movedTondeuse.direction());
    }

    private static Stream<Arguments> provideCharsForRotationAction() {
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