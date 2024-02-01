package tests.examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("example")
public class SkipedTest {

    @Test
    @Disabled
    void someTest() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void someTest1() {
        assertTrue(false);
    }

}