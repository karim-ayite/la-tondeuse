package fr.codeflow;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LaTondeuseAppTest {

    @BeforeEach
    void setup() {
        ListAppender<ILoggingEvent> logWatcher = new ListAppender<>();
        logWatcher.start();
        ((Logger) LoggerFactory.getLogger(LaTondeuseApp.class)).addAppender(logWatcher);
    }

    @Test
    @DisplayName("Should log tondeuse final positions")
    void shouldLogTondeuseFinalPositions() throws IOException {
        // get Logback Logger
        Logger fooLogger = (Logger) LoggerFactory.getLogger(LaTondeuseApp.class);

        // create and start a ListAppender
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        // add the appender to the logger
        fooLogger.addAppender(listAppender);

        String path = "src/test/resources";

        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        LaTondeuseApp.main(new String[]{absolutePath+"/parcoursTondeusesValid.txt"});

        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("1 3 N 5 1 E", logsList.get(0)
                .getMessage());
    }

    @Test
    @DisplayName("Should throw a IllegalArgumentException when args are empty")
    void shouldThrowAIllegalArgumentExceptionWhenArgsAreEmpty() {
        assertThrows(IllegalArgumentException.class,() -> LaTondeuseApp.main(new String[]{}));
    }
}