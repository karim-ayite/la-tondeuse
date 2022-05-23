package fr.codeflow.mouvement;

import fr.codeflow.domaine.Pelouse;
import fr.codeflow.domaine.Tondeuse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static fr.codeflow.domaine.Direction.EST;
import static fr.codeflow.domaine.Direction.NORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GuidageServiceTest {

    private final MouvementTondeuseFactory mouvementTondeuseFactory = new GenericMouvementTondeuseFactory();

    @Test
    @DisplayName("Should success when file content is valid")
    void shouldSuccessWhenFileContentIsValid() {

        var guidanceService = new TondeuseMouvementService(mouvementTondeuseFactory);

        List<InstructionMouvement> instructionsTondeuse = new ArrayList<>();


        var tondeuse1 = new Tondeuse(1,2, NORD,"GAGAGAGAA");

        InstructionMouvement instructionMouvement1 = new InstructionMouvement(tondeuse1,"GAGAGAGAA");
        instructionsTondeuse.add(instructionMouvement1);

        var tondeuse2 = new Tondeuse(3,3, EST,"AADAADADDA");

        InstructionMouvement instructionMouvement2 = new InstructionMouvement(tondeuse2,"AADAADADDA");
        instructionsTondeuse.add(instructionMouvement2);

        var pelouse = new Pelouse(5,5);

        var finalPositions = guidanceService.executeInstructionsMouvement(instructionsTondeuse,pelouse);

        assertEquals("1 3 N 5 1 E",finalPositions);
    }
}