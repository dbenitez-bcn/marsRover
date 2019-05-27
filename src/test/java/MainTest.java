import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void isCommandFormatCorrectReturnsFalseWhenACommandHasBadFormat() {
        Main m = new Main();
        String incorrectCommand = "INCORRECT";
        boolean actual;

        actual = m.isCommandFormatCorrect(incorrectCommand);

        assertFalse(actual);
    }

    @Test
    void isCommandFormatCorrectReturnsTrueWhenACommandHasCorrectFormat() {
        Main m = new Main();
        String correctCommand = "LMLMLMLMM";
        boolean actual;

        actual = m.isCommandFormatCorrect(correctCommand);

        assertTrue(actual);
    }

    @Test
    void sCommandFormatCorrectIsNotCaseSensitive() {
        Main m = new Main();
        String correctCommand = "lMlMrMlMmR";
        boolean actual;

        actual = m.isCommandFormatCorrect(correctCommand);

        assertTrue(actual);
    }

    @Test
    void createPlateurReturnsExpectedPlateur() {
        Main m = new Main();
        Plateaur expected = new Plateaur(2, 2);
        Plateaur actual;
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = m.createPlateur();

        assertTrue(expected.equals(actual));
    }

    @Test
    void askPlateurSizeReturnsTheGivenString() {
        Main m = new Main();
        String expected = "5 5";
        String actual;
        String input = "5 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = m.askPlateurSize();

        assertEquals(expected, actual);
    }

    @Test
    void askPlateurSizeAskAgainTheSizeIfIsInvalid() {
        Main m = new Main();
        String expected = "5 5";
        String actual;
        String input = "5 A\n"
                    +"5 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = m.askPlateurSize();

        assertEquals(expected, actual);
    }

    @Test
    void getBothValuesFromReturnsBothValues() {
        Main m = new Main();
        int[] expected = {5, 5};
        int[] actual;

        actual = m.getBothValuesFrom("5 5");

        assertArrayEquals(expected, actual);
    }

    @Test
    void getBothValuesFromReturnsJustTwoValues() {
        Main m = new Main();
        int expected = 2;
        int actual;

        actual = m.getBothValuesFrom("1 1 1 1").length;

        assertEquals(expected, actual);
    }

    @Test
    void getIntegerFromReturnsOneIfStringIsNotANumber() {
        Main m = new Main();
        int expected = 1;
        int actual;

        actual = m.getIntegerFrom("A");

        assertEquals(expected, actual);
    }

    @Test
    void getIntegerFromCanReturnMoreThantwoDigitsNumber() {
        Main m = new Main();
        int expected = 23;
        int actual;

        actual = m.getIntegerFrom("23");

        assertEquals(expected, actual);
    }


    @Test
    void getIntegerFromReturnsStringAsANumber() {
        Main m = new Main();
        int expected = 7;
        int actual;

        actual = m.getIntegerFrom("7");

        assertEquals(expected, actual);
    }

    @Test
    void createRoverReturnsExpectedRover() {
        Main m = new Main();
        Rover expected = new Rover(1, 2, 'N');
        Rover actual;
        String input = "1 2 N";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = m.createRover();

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void askRoverDeploymentInformationReturnsTheGivenString() {
        Main m = new Main();
        String expected = "1 2 N";
        String actual;
        String input = "1 2 N";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = m.askRoverDeploymentInformation();

        assertEquals(expected, actual);
    }

    @Test
    void getOrientationFromReturnsCorrectOrientation() {
        Main m = new Main();
        char expected = 'W';
        char acutal;

        acutal = m.getOrientationFrom("1 1 W");

        assertEquals(expected, acutal);
    }

    @Test
    void getOrientationValueFromReturnsCorrectValue() {
        Main m = new Main();
        char expected = 'S';
        char actual;

        actual = m.getOrientationValueFrom("S");

        assertEquals(expected, actual);
    }

    @Test
    void getOrientationValueFromIsNotCaseSensitive() {
        Main m = new Main();
        char expected = 'N';
        char actual;

        actual = m.getOrientationValueFrom("n");

        assertEquals(expected, actual);
    }

    @Test
    void getOrientationValueReturnsNWhenInvalidValue() {
        Main m = new Main();
        char expected = 'N';
        char actual;

        actual = m.getOrientationValueFrom("q");

        assertEquals(expected, actual);
    }

    @Test
    void aksCommandReturnsTheGivenCommand() {
        Main m = new Main();
        String expected = "LMLMLMLMM";
        String actual;
        String input = "LMLMLMLMM";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = Main.askCommand();

        assertEquals(expected, actual);
    }

    @Test
    void ifCommandIsInvalidUserShouldEntryTheCommandAgain() {
        Main m = new Main();
        String expected = "LMLMLMLMM";
        String actual;
        String input = "QWERAAS\n" +
                        "LMLMLMLMM";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = Main.askCommand();

        assertEquals(expected, actual);
    }


    @Test
    void aksCommandIsNotCaseSensitive() {
        Main m = new Main();
        String expected = "LMLMLMLMM";
        String actual;
        String input = "lmlmlmLMM";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        actual = Main.askCommand();

        assertEquals(expected, actual);
    }
}