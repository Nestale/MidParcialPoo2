package Back;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class CSVUtils {
    public static ArrayList<String[]> readCSV() {
        ArrayList<String[]> Huertas = new ArrayList<>();
        try (Scanner scFile = new Scanner(new File("././src/Huertas.cvs"))) {
            while (scFile.hasNextLine()) {
                String[] linea = scFile.nextLine().split(",");
                Huertas.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Huertas;

    }
}
