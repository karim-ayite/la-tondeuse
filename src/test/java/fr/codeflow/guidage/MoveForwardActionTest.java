package fr.codeflow.guidage;

import fr.codeflow.domaine.Mouvement;
import fr.codeflow.domaine.Pelouse;
import fr.codeflow.mouvement.GenericMouvementTondeuseFactory;
import fr.codeflow.mouvement.MouvementTondeuseFactory;
import fr.codeflow.outils.TondeuseFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.codeflow.domaine.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AvancerActionTest {

    private final MouvementTondeuseFactory mouvementTondeuseFactory = new GenericMouvementTondeuseFactory();


    @Test
    @DisplayName("Should move up tondeuse when direction is north")
    void shouldMoveUpTondeuseWhenDirectionIsNorth() {

        var tondeuseToGuide = TondeuseFactory.createTondeuse(6, 5, NORD, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(6,movedTondeuse.positionY());

    }

    @Test
    @DisplayName("Should move down tondeuse when direction is south")
    void shouldMoveDownTondeuseWhenDirectionIsSouth() {

        var tondeuseToGuide = TondeuseFactory.createTondeuse(6, 5, SUD, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(4,movedTondeuse.positionY());
    }

    @Test
    @DisplayName("Should move left when direction is west")
    void shouldMoveRightWhenDirectionIsWest() {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(6, 5, OUEST, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(5,movedTondeuse.positionX());
    }

    @Test
    @DisplayName("Should move right when direction is east")
    void shouldMoveLeftWhenDirectionIsEast() {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(6, 5, EST, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(7,movedTondeuse.positionX());
    }

    @Test
    @DisplayName("Should not move when direction is N and tondeuse is on upper bound")
    void shouldNotMoveWhenDirectionIsNAndTondeuseIsOnUpperBound() {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(10, 10, NORD, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(10,movedTondeuse.positionY());
        assertEquals(10,movedTondeuse.positionX());
    }

    @Test
    @DisplayName("Should not move when direction is S and tondeuse is on bottom bound")
    void shouldNotMoveWhenDirectionIsSAndTondeuseIsOnBottomBound() {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(10, 0, SUD, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(0,movedTondeuse.positionY());
        assertEquals(10,movedTondeuse.positionX());
    }


    @Test
    @DisplayName("Should not move when direction is E and tondeuse is on right bound")
    void shouldNotMoveWhenDirectionIsEAndTondeuseIsOnRightBound() {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(10, 0, EST, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(10,movedTondeuse.positionX());
        assertEquals(0,movedTondeuse.positionY());
    }

    @Test
    @DisplayName("Should not move when direction is W and tondeuse is on left bound")
    void shouldNotMoveWhenDirectionIsWAndTondeuseIsOnLeftBound() {
        var tondeuseToGuide = TondeuseFactory.createTondeuse(0, 0, OUEST, "AADAADADA");

        var guidanceAction = mouvementTondeuseFactory.createMouvementTondeuse(Mouvement.valueOfCode('A'), tondeuseToGuide, new Pelouse(10, 10));

        var movedTondeuse = guidanceAction.execute();

        assertEquals(0,movedTondeuse.positionX());
        assertEquals(0,movedTondeuse.positionY());
    }
}