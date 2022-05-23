package fr.codeflow;

import fr.codeflow.mouvement.GenericMouvementTondeuseFactory;
import fr.codeflow.mouvement.InstructionMouvement;
import fr.codeflow.mouvement.TondeuseMouvementService;
import fr.codeflow.outils.FileUtils;
import fr.codeflow.outils.PelouseReader;
import fr.codeflow.outils.TondeuseFileValidator;
import fr.codeflow.outils.IntructionsMouvementReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class LaTondeuseApp {

    public static final String SEPARATOR = " ";

    private static final Logger logger = LoggerFactory.getLogger(LaTondeuseApp.class);

    public static void main(String[] args) throws IOException {

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Nom de fichier obligatoire");
        }

        var fileLines = FileUtils.readFileLines(args[0]);

        if (TondeuseFileValidator.validate(fileLines)) {

            var pelouse = PelouseReader.read(fileLines);

            List<InstructionMouvement> instructionsMouvement = IntructionsMouvementReader.read(fileLines);

            var tondeuseMouvementService = new TondeuseMouvementService(new GenericMouvementTondeuseFactory());


            var finalPosition = tondeuseMouvementService.executeInstructionsMouvement(instructionsMouvement, pelouse);

            logger.info(finalPosition);
        }


    }
}
