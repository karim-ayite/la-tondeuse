package fr.codeflow.outils;

import fr.codeflow.LaTondeuseApp;
import fr.codeflow.domaine.Direction;
import fr.codeflow.mouvement.InstructionMouvement;

import java.util.ArrayList;
import java.util.List;

public class IntructionsMouvementReader {

    private IntructionsMouvementReader() {
        throw new IllegalStateException("Classe utilitaire");
    }


    public static List<InstructionMouvement> read(List<String> validFileLines) {
        List<InstructionMouvement> instructionMouvements = new ArrayList<>();

        for (int lineNumber = 1; lineNumber < validFileLines.size(); lineNumber = lineNumber + 2) {

            var tondeuseInitialPositionLine = validFileLines.get(lineNumber).split(LaTondeuseApp.SEPARATOR);

            var positionX = Integer.parseInt(tondeuseInitialPositionLine[0]);
            var positionY = Integer.parseInt(tondeuseInitialPositionLine[1]);
            var direction = Direction.valueOfCode(tondeuseInitialPositionLine[2].charAt(0));
            var instructionsLine = validFileLines.get(lineNumber + 1);

            var tondeuse = TondeuseFactory.createTondeuse(positionX, positionY, direction, instructionsLine);

            InstructionMouvement instructionMouvement = new InstructionMouvement(tondeuse,instructionsLine);
            instructionMouvements.add(instructionMouvement);
        }

        return instructionMouvements;
    }

}
