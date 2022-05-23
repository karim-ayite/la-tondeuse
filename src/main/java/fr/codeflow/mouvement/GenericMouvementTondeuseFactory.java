package fr.codeflow.mouvement;

import fr.codeflow.domaine.Mouvement;
import fr.codeflow.domaine.Direction;
import fr.codeflow.domaine.Pelouse;
import fr.codeflow.domaine.Tondeuse;

import java.util.Map;

import static fr.codeflow.domaine.Direction.*;


public class GenericMouvementTondeuseFactory implements MouvementTondeuseFactory {

    private final Map<Direction, Direction> rotationDroiteMap = Map.of(
            NORD, EST,
            SUD, OUEST,
            OUEST, NORD,
            EST, SUD
    );

    private final Map<Direction, Direction> rotationGaucheMap = Map.of(
            NORD, OUEST,
            SUD, EST,
            OUEST, SUD,
            EST, NORD
    );

    public MouvementTondeuse createMouvementTondeuse(Mouvement mouvement, Tondeuse tondeuseToMove, Pelouse pelouse) {
        return switch (mouvement) {

            case ROTATION_GAUCHE -> new RotationMouvementTondeuse(tondeuseToMove, rotationGaucheMap);

            case ROTATION_DROITE -> new RotationMouvementTondeuse(tondeuseToMove, rotationDroiteMap);

            case AVANCER -> new AvancerMouvementTondeuse(tondeuseToMove, pelouse.maxPositionX(), pelouse.maxPositionY());

        };
    }
}
