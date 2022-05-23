package fr.codeflow.domaine;


public record Tondeuse(
        int positionX,
        int positionY,
        Direction direction,
        String sequenceMouvements
) {

}
