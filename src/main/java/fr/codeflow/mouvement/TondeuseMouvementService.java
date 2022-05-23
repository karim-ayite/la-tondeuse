package fr.codeflow.mouvement;

import fr.codeflow.LaTondeuseApp;
import fr.codeflow.domaine.Mouvement;
import fr.codeflow.domaine.Pelouse;
import fr.codeflow.domaine.Tondeuse;

import java.util.List;
import java.util.stream.Collectors;

public class TondeuseMouvementService implements MouvementService {

    private final MouvementTondeuseFactory mouvementTondeuseFactory;

    public TondeuseMouvementService(MouvementTondeuseFactory mouvementTondeuseFactory) {
        this.mouvementTondeuseFactory = mouvementTondeuseFactory;
    }

    @Override
    public String executeInstructionsMouvement(List<InstructionMouvement> instructionsMouvement, Pelouse pelouse) {
        return instructionsMouvement.stream()
                .map(instruction -> this.executeInstruction(instruction,pelouse))
                .collect(Collectors.joining())
                .trim();
    }

    private String executeInstruction(InstructionMouvement instructionMouvement, Pelouse pelouse) {

        Tondeuse movedTondeuse = instructionMouvement.tondeuse();

        for (int i = 0; i < instructionMouvement.instructions().length(); i++) {
            Mouvement mouvement = Mouvement.valueOfCode(instructionMouvement.instructions().charAt(i));

            MouvementTondeuse mouvementTondeuse = mouvementTondeuseFactory.createMouvementTondeuse(mouvement, movedTondeuse, pelouse);

            movedTondeuse = mouvementTondeuse.execute();
        }

        return getFinalPositionAsString(movedTondeuse);
    }

    private java.lang.String getFinalPositionAsString(Tondeuse movedTondeuse) {
        return movedTondeuse.positionX() + LaTondeuseApp.SEPARATOR +
                movedTondeuse.positionY() + LaTondeuseApp.SEPARATOR +
                movedTondeuse.direction().getCode() + LaTondeuseApp.SEPARATOR;
    }

}
