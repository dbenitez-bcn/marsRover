public class Rover {
    private int xCood;
    private int yCood;
    private char orientation;

    public Rover(int xCood, int yCood, char orientation) {
        this.xCood = xCood;
        this.yCood = yCood;
        this.orientation = orientation;
    }

    public int getxCood() {
        return xCood;
    }

    public int getyCood() {
        return yCood;
    }

    public char getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return xCood + " " + yCood + " " + orientation;
    }

    public void executeCommand(String command, Plateaur plateaur) {

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'M') moveInside(plateaur);
            else if (command.charAt(i) == 'L') turnLeft();
            else if (command.charAt(i) == 'R') turnRight();
        }
    }

    public void turnLeft() {
        if (orientation == 'N') orientation = 'W';
        else if (orientation == 'E') orientation = 'N';
        else if (orientation == 'S') orientation = 'E';
        else if (orientation == 'W') orientation = 'S';

    }

    public void turnRight() {
        if (orientation == 'N') orientation = 'E';
        else if (orientation == 'E') orientation = 'S';
        else if (orientation == 'S') orientation = 'W';
        else if (orientation == 'W') orientation = 'N';

    }

    public void moveInside(Plateaur plateaur) {
        if (orientation == 'N') {
            if (yCood < plateaur.getySize()) yCood++;
        } else if (orientation == 'E') {
            if (xCood < plateaur.getxSize()) xCood++;
        } else if (orientation == 'S') {
            if (yCood > 0) yCood--;
        } else if (orientation == 'W') {
            if (xCood > 0) xCood--;
        }
    }
}
