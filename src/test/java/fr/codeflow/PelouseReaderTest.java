package fr.codeflow;

import fr.codeflow.outils.PelouseReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PelouseReaderTest {


    @Test
    @DisplayName("Should create a lawn matrix from input string")
    void shouldCreateAPelouseMatrixFromInputString() {
        var lawn = PelouseReader.read(TondeuseFileValidatorTest.VALID_FILE_CONTENT);
        int expectedRowNumber = 5;
        int expectedColumnNumber = 5;

        assertAll(
                () -> assertEquals(lawn.maxPositionX(), expectedRowNumber),
                () -> {
                    for (int i=0;i<expectedRowNumber;i++){
                        assertEquals(lawn.maxPositionY(), expectedColumnNumber);
                    }
                }
        );
    }

}