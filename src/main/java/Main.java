import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Plateaur plateaur;
        Rover rover;

        plateaur = createPlateur();

        rover = createRover();
        String command = askCommand();
        rover.executeCommand(command, plateaur);
        System.out.println(rover.toString());

        rover = createRover();
        command = askCommand();
        rover.executeCommand(command, plateaur);
        System.out.println(rover.toString());
    }

    public static Plateaur createPlateur() {
        String userInput = askPlateurSize();
        int[] sizesValues = getBothValuesFrom(userInput);

        return new Plateaur(sizesValues[0], sizesValues[1]);
    }

    public static Rover createRover() {
        String userInput = askRoverDeploymentInformation();
        int[] coords = getBothValuesFrom(userInput);
        char orientation = getOrientationFrom(userInput);

        return new Rover(coords[0], coords[1], orientation);
    }

    public static char getOrientationFrom(String userInput) {
        String[] inputSplited = userInput.split(" ");
        char corientation = getOrientationValueFrom(inputSplited[2]);

        return corientation;
    }

    public static char getOrientationValueFrom(String stringGiven) {
        char value = stringGiven.toUpperCase().charAt(0);
        if (isValidOrientation(value)) return value;
        else return 'N';
    }

    private static boolean isValidOrientation(char value) {
        if (value == 'N' || value == 'E' || value == 'W' || value == 'S') return true;
        else return false;
    }

    public static String askRoverDeploymentInformation() {
        String deploymentInformation;
        Scanner s = new Scanner(System.in);

        System.out.println("Entry the Rover's position and orientation (example: 1 2 N): ");
        deploymentInformation = s.nextLine();
        while (!isDeploymentInformationCorrect(deploymentInformation)) {
            System.out.println("Entry a valid position and orientation:");
            deploymentInformation = s.nextLine();
        }

        return deploymentInformation.toUpperCase();
    }

    public static boolean isDeploymentInformationCorrect(String deploymentInformation) {
        return deploymentInformation.matches("[\\d]*[\\s][\\d]*[\\s][NESW]");
    }

    public static String askPlateurSize() {
        String plateurSize;
        Scanner scanner = new Scanner(System.in);


        System.out.println("Entry the Plateur's size (example: 5 5): ");
        plateurSize = scanner.nextLine();
        while (!isPlateurSizeFormatCorrect(plateurSize)) {
            System.out.println("Entry a valid size");
            plateurSize = scanner.nextLine();
        }

        return plateurSize;
    }

    public static boolean isPlateurSizeFormatCorrect(String plateurSizeFormat) {
        return plateurSizeFormat.matches("[\\d]*[\\s][\\d]*");

    }

    public static String askCommand() {
        String command;
        Scanner s = new Scanner(System.in);

        System.out.println("Entry a movement command (example: LMLMLMLMM):");
        command = s.nextLine();
        while (!isCommandFormatCorrect(command)) {
            System.out.println("Entry a valid command:");
            command = s.nextLine();
        }

        return command.toUpperCase();
    }

    public static boolean isCommandFormatCorrect(String command) {
        return command.toUpperCase().matches("[MLR]*");
    }

    public static int[] getBothValuesFrom(String userInput) {
        String[] inputSplited = userInput.split(" ");
        int firstValue;
        int secondValue;

        firstValue = getIntegerFrom(inputSplited[0]);
        secondValue = getIntegerFrom(inputSplited[1]);

        return new int[]{firstValue, secondValue};
    }

    public static int getIntegerFrom(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException ex) {
            return 1;
        }
    }
}
