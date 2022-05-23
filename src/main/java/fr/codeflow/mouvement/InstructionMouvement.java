package fr.codeflow.mouvement;

import fr.codeflow.domaine.Tondeuse;

public record InstructionMouvement(Tondeuse tondeuse, String instructions) {
}
