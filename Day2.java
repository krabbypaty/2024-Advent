import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    public static boolean isAscending(String[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (Integer.parseInt(values[i]) > Integer.parseInt(values[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDescending(String[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (Integer.parseInt(values[i]) < Integer.parseInt(values[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean differ(String[] values) {
        int counter = 0;
        for (int i = 0; i < values.length - 1; i++) {
            if (!(Math.abs(Integer.parseInt(values[i]) - Integer.parseInt(values[i + 1])) >= 1 &&
                    Math.abs(Integer.parseInt(values[i]) - Integer.parseInt(values[i + 1])) <= 3)) {
                counter++;
            }
        }
        return counter == 0;
    }

    public static int safe(String filename) {
        int counter = 0;
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = "";
                line += input.nextLine();
                String[] values = line.split(" ");
                if ((isAscending(values) || isDescending(values)) && differ(values)) {
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(safe("Tester.txt"));
    }
}