package fr.codeflow.mouvement;

import fr.codeflow.domaine.Tondeuse;
import fr.codeflow.outils.TondeuseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AvancerMouvementTondeuse implements MouvementTondeuse {

    private static final Logger logger = LoggerFactory.getLogger(AvancerMouvementTondeuse.class);

    private static final int STEP = 1;
    private final Tondeuse tondeuseToMove;
    private final int maxPositionX;
    private final int maxPositionY;

    public AvancerMouvementTondeuse(Tondeuse tondeuseToMove, int maxPositionX, int maxPositionY) {
        this.tondeuseToMove = tondeuseToMove;
        this.maxPositionX = maxPositionX;
        this.maxPositionY = maxPositionY;
    }

    @Override
    public Tondeuse execute() {
        return switch (tondeuseToMove.direction()) {
            case NORD -> moveNordIfPossible();
            case SUD -> moveSudIfPossible();
            case EST -> moveEstIfPossible();
            case OUEST -> moveOuestIfPossible();
        };
    }

    private Tondeuse moveOuestIfPossible() {
        int westPositionX = tondeuseToMove.positionX() - STEP;

        if (westPositionX >= 0) {
            return TondeuseFactory.createTondeuseWithUpdatedPositionX(tondeuseToMove, westPositionX);
        } else {
            logger.warn("Impossible de faire avancer la tondeuse à l'Ouest, limite Ouest de la pelouse atteinte, position actuelle : ({},{}), position cible : ({},{})", tondeuseToMove.positionX(), tondeuseToMove.positionY(),westPositionX, tondeuseToMove.positionY());
            return tondeuseToMove;
        }
    }

    private Tondeuse moveEstIfPossible() {
        int eastPositionX = tondeuseToMove.positionX() + STEP;

        if (eastPositionX <= maxPositionX) {
            return TondeuseFactory.createTondeuseWithUpdatedPositionX(tondeuseToMove, eastPositionX);
        } else {
            logger.warn("Impossible de faire avancer la tondeuse à l'Est, limite Est de la pelouse atteinte, position actuelle : ({},{}), position cible : ({},{})", tondeuseToMove.positionX(), tondeuseToMove.positionY(),eastPositionX, tondeuseToMove.positionY());
            return tondeuseToMove;
        }
    }

    private Tondeuse moveSudIfPossible() {
        int southPositionY = tondeuseToMove.positionY() - STEP;

        if (tondeuseToMove.positionY() - STEP >= 0) {
            return TondeuseFactory.createTondeuseWithUpdatedPositionY(tondeuseToMove, southPositionY);
        } else {
            logger.warn("Impossible de faire avancer la tondeuse au Sud, limite Sud de la pelouse atteinte, position actuelle : ({},{}), position cible : ({},{})", tondeuseToMove.positionX(), tondeuseToMove.positionY(), tondeuseToMove.positionX(),southPositionY);
            return tondeuseToMove;
        }
    }

    private Tondeuse moveNordIfPossible() {
        int northPositionY = tondeuseToMove.positionY() + STEP;

        if (northPositionY <= maxPositionY) {
            return TondeuseFactory.createTondeuseWithUpdatedPositionY(tondeuseToMove, northPositionY);
        } else {
            logger.warn("Impossible de faire avancer la tondeuse au Nord, limite Nord de la pelouse atteinte, position actuelle : ({},{}), position cible : ({},{})", tondeuseToMove.positionX(), tondeuseToMove.positionY(), tondeuseToMove.positionX(),northPositionY);
            return tondeuseToMove;
        }
    }
}
