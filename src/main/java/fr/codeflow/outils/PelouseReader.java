package fr.codeflow.outils;

import fr.codeflow.LaTondeuseApp;
import fr.codeflow.domaine.Pelouse;

import java.util.List;

public class PelouseReader {

    private PelouseReader() {
        throw new IllegalStateException("Classe utilitaire");
    }


    public static Pelouse read(List<String> validFileLines) {
        String pointSuperieurDroitLine = validFileLines.get(0);

        var pointSuperiorDroitCoordinate = pointSuperieurDroitLine.split(LaTondeuseApp.SEPARATOR);

        int maxPositionX = Integer.parseInt(pointSuperiorDroitCoordinate[0]);
        int maxPositionY = Integer.parseInt(pointSuperiorDroitCoordinate[1]);

        return new Pelouse(maxPositionX,maxPositionY);
    }
}
