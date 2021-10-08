package ChemistryCalculator.backend;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;


public class Database {
    private HashMap<String, String[]> allAtoms;

    public Database() {

        try {
            InputStream fileInputStream = getClass().getResourceAsStream("/ChemistryCalculator/database/database.ser");
            ObjectInputStream objectinputStream = new ObjectInputStream(fileInputStream);
            this.allAtoms = (HashMap<String, String[]>) objectinputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Database Error ! %s%n", e.getMessage());
        }
    }

    public HashMap<String, String[]> getAllAtoms() {
        return allAtoms;
    }
}
