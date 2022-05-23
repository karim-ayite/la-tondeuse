package fr.codeflow.outils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TondeuseFileValidator {

    private static final String POINT_SUPERIEUR_DROIT_PELOUSE_REGEX = "^[1-9]\\s[1-9]";
    static final String TONDEUSE_INTIAL_POSITION_REGEX = "^(\\d\\s\\d\\s[NSEW])";
    static final String TONDEUSE_SEQUENCE_MOUVEMENTS_REGEX = "[^GAD]";

    private TondeuseFileValidator() {
        throw new IllegalStateException("Classe utilitaire");
    }

    public static final String ERROR_MESSAGE_EMPTY_FILE = "Le fichier de parcours des tondeuses est vide";

    public static final String ERROR_MESSAGE_INVALID_FILE_CONTENT = "Le contenu du fichier en entrée est invalide";

    public static boolean validate(List<String> lines) {

        if (!lines.isEmpty()) {
            checkPointSuperieurDroitPelouse(lines);
            checkTondeuseLines(lines);
        } else {
            throw new IllegalStateException(ERROR_MESSAGE_EMPTY_FILE);
        }

        return true;
    }

    private static void checkTondeuseLines(List<String> lines) {

        for (int lineNumber = 1; lineNumber < lines.size(); lineNumber = lineNumber + 2) {
            checkTondeuseInitialPosition(lines, lineNumber);
            checkTondeuseInstructions(lines, lineNumber + 1);
        }

    }

    private static void checkTondeuseInstructions(List<String> lines, int lineNumber) {

        Pattern pattern = Pattern.compile(TONDEUSE_SEQUENCE_MOUVEMENTS_REGEX);
        Matcher matcher = pattern.matcher(lines.get(lineNumber));

        if (matcher.find()) {
            throw new IllegalStateException(ERROR_MESSAGE_INVALID_FILE_CONTENT+ " : "+matcher.group()+" n'est pas une mouvement valide");
        }
    }

    private static void checkTondeuseInitialPosition(List<String> lines, int lineNumber) {

        var pattern = Pattern.compile(TondeuseFileValidator.TONDEUSE_INTIAL_POSITION_REGEX);
        var matcher = pattern.matcher(lines.get(lineNumber));

        if (!matcher.find()) {
            throw new IllegalStateException(ERROR_MESSAGE_INVALID_FILE_CONTENT);
        }
    }

    private static void checkPointSuperieurDroitPelouse(List<String> lines) {

        Pattern pattern = Pattern.compile(POINT_SUPERIEUR_DROIT_PELOUSE_REGEX);

        String pointSuperieurDroitPelouse = lines.get(0);
        Matcher matcher = pattern.matcher(pointSuperieurDroitPelouse);

        if (!matcher.find()) {
            throw new IllegalStateException(ERROR_MESSAGE_INVALID_FILE_CONTENT);
        }
    }


}
