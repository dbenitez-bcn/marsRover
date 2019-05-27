import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void getxCoodRetunsCorrectValue() {
        Rover r = new Rover(1, 1, 'N');
        int expected = 1;
        int actual;

        actual = r.getxCood();

        assertEquals(expected, actual);
    }

    @Test
    void getyCoodRetunsCorrectValue() {
        Rover r = new Rover(1, 1, 'N');
        int expected = 1;
        int actual;

        actual = r.getyCood();

        assertEquals(expected, actual);
    }

    @Test
    void getOrientationRetunsCorrectValue() {
        Rover r = new Rover(1, 1, 'N');
        char expected = 'N';
        char actual;

        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void executeCommandWorksFine() {
        Rover r = new Rover(1, 2, 'N');
        Plateaur p = new Plateaur(5, 5);
        String expected = "1 3 N";
        String actual;

        r.executeCommand("LMLMLMLMM", p);
        actual = r.toString();

        assertEquals(expected, actual);
    }


    @Test
    void roverCanNotMoveOutTheXLinePlateur() {
        Rover r = new Rover(0, 0, 'E');
        Plateaur p = new Plateaur(2, 2);
        int expected = 2;
        int actual;

        r.executeCommand("MMMMMMMMM", p);
        actual = r.getxCood();

        assertEquals(expected, actual);
    }

    @Test
    void roverCanNotMoveOutTheYLinePlateur() {
        Rover r = new Rover(0, 0, 'N');
        Plateaur p = new Plateaur(2, 2);
        int expected = 2;
        int actual;

        r.executeCommand("MMMMMMMMM", p);
        actual = r.getyCood();

        assertEquals(expected, actual);
    }

    @Test
    void turnLeftTurnsWestWhenIsOnNorth(){
        Rover r= new Rover (1,1,'N');
        char expected = 'W';
        char actual;

        r.turnLeft();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void turnLeftTurnsSouthWhenIsOnWest(){
        Rover r= new Rover (1,1,'W');
        char expected = 'S';
        char actual;

        r.turnLeft();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void turnLeftTurnsEstWhenIsOnSouth(){
        Rover r= new Rover (1,1,'S');
        char expected = 'E';
        char actual;

        r.turnLeft();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void turnLeftTurnsNorthWhenIsOnEst(){
        Rover r= new Rover (1,1,'E');
        char expected = 'N';
        char actual;

        r.turnLeft();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void turnRightTurnsEstWhenIsOnNorth(){
        Rover r= new Rover (1,1,'N');
        char expected = 'E';
        char actual;

        r.turnRight();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void turnRightTurnsSouthWhenIsOnEst(){
        Rover r= new Rover (1,1,'E');
        char expected = 'S';
        char actual;

        r.turnRight();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void turnRightTurnsWestWhenIsOnSouth(){
        Rover r= new Rover (1,1,'S');
        char expected = 'W';
        char actual;

        r.turnRight();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }

    @Test
    void turnRightTurnsNorthWhenIsOnWest(){
        Rover r= new Rover (1,1,'W');
        char expected = 'N';
        char actual;

        r.turnRight();
        actual = r.getOrientation();

        assertEquals(expected, actual);
    }


}