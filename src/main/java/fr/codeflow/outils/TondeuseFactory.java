package fr.codeflow.outils;

import fr.codeflow.domaine.Direction;
import fr.codeflow.domaine.Tondeuse;

public  class TondeuseFactory {

    private TondeuseFactory() {
        throw new IllegalStateException("Classe utilitaire");
    }

    public static Tondeuse createTondeuse(int positionX, int positionY, Direction direction, String sequenceMouvements){
        return new Tondeuse( positionX, positionY, direction, sequenceMouvements);
    }
    public static Tondeuse createTondeuseWithUpdatedDirection(Tondeuse tondeuse, Direction direction) {
        return new Tondeuse( tondeuse.positionX(), tondeuse.positionY(), direction, tondeuse.sequenceMouvements());
    }
    public static Tondeuse createTondeuseWithUpdatedPositionX(Tondeuse tondeuse, int positionX) {
        return new Tondeuse( positionX, tondeuse.positionY(), tondeuse.direction(), tondeuse.sequenceMouvements());
    }
    public static Tondeuse createTondeuseWithUpdatedPositionY(Tondeuse tondeuse, int positionY) {
        return new Tondeuse( tondeuse.positionX(), positionY, tondeuse.direction(), tondeuse.sequenceMouvements());
    }

}
