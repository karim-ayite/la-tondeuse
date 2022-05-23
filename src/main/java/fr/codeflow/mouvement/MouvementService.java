package fr.codeflow.mouvement;

import fr.codeflow.domaine.Pelouse;

import java.util.List;

public interface MouvementService {
    String executeInstructionsMouvement(List<InstructionMouvement> instructionMouvement, Pelouse pelouse);
}
