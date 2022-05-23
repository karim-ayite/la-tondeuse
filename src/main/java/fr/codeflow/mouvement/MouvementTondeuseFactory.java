package fr.codeflow.mouvement;

import fr.codeflow.domaine.Mouvement;
import fr.codeflow.domaine.Pelouse;
import fr.codeflow.domaine.Tondeuse;

public interface MouvementTondeuseFactory {
    MouvementTondeuse createMouvementTondeuse(Mouvement action, Tondeuse tondeuseToMove, Pelouse pelouse);
}
