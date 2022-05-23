package fr.codeflow.mouvement;

import fr.codeflow.domaine.Direction;
import fr.codeflow.domaine.Tondeuse;
import fr.codeflow.outils.TondeuseFactory;

import java.util.Map;

public class RotationMouvementTondeuse implements MouvementTondeuse {


    private final Map<Direction, Direction> rotationMap;
    private final Tondeuse tondeuseToRotate;

    public RotationMouvementTondeuse(Tondeuse tondeuseToRotate, Map<Direction, Direction> rotationMap) {
        this.rotationMap = rotationMap;
        this.tondeuseToRotate = tondeuseToRotate;
    }

    @Override
    public Tondeuse execute() {
        Direction directionAfterRotation = rotationMap.get(tondeuseToRotate.direction());
        return TondeuseFactory.createTondeuseWithUpdatedDirection(tondeuseToRotate, directionAfterRotation);
    }
}
