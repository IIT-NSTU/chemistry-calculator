package ChemistryCalculator.backend;

import java.util.HashMap;

public class Atom {
    private static final HashMap<String, String[]> allAtoms = new Database().getAllAtoms();
    private String symbol;
    private String name;
    private  double atomicMass;
    private int atomicNumber;

    private Atom(String symbol) {
        String[] atom = allAtoms.get(symbol);
        this.symbol = symbol;
        atomicNumber = Integer.parseInt(atom[0]);
        name = atom[1];
        atomicMass = Double.parseDouble(atom[2]);

    }

    private Atom(int atomicNumber) {
        allAtoms.entrySet().stream().filter(entry -> atomicNumber == Integer.parseInt(entry.getValue()[0])).forEachOrdered(entry -> {
            this.symbol = entry.getKey();
            this.name = entry.getValue()[1];
            this.atomicMass = Double.parseDouble(entry.getValue()[2]);
        });
        this.atomicNumber = atomicNumber;
    }

    public static Atom getInstance(String symbol) {
        if (isValid(symbol)) {
            return new Atom(symbol);
        }
        throw new InvalidAtomException("'" + symbol + "'" + " is not a valid symbol !");
    }

    public static Atom getInstance(int atomicNumber) {
        if (atomicNumber >= 1 && atomicNumber <= 118){
            return new Atom(atomicNumber);
        }
        throw new InvalidAtomException("'" + atomicNumber + "'" + " is not a valid atomic number !");
    }

    private static boolean isValid(String symbol) {
        return allAtoms.containsKey(symbol);
    }


    public String getElectronConfig() {

        int counter;
        int tempAtomicNumber = this.atomicNumber;

        StringBuilder output = new StringBuilder();
        String[][] orbitals = {
                {"1s", "2"}, {"2s", "2"}, {"2p", "6"},
                {"3s", "2"}, {"3p", "6"}, {"4s", "2"},
                {"3d", "10"}, {"4p", "6"}, {"5s", "2"},
                {"4d", "10"}, {"5p", "6"}, {"6s", "2"},
                {"4f", "14"}, {"5d", "10"}, {"6p", "6"},
                {"7s", "2"}, {"5f", "14"}, {"6d", "10"},
                {"7p", "6"}, {"8s", "2"}
        };

        for (String[] innerArray : orbitals) {
            String orbitalName = innerArray[0];
            int orbitalSize = Integer.parseInt(innerArray[1]);

            counter = Math.min(orbitalSize, tempAtomicNumber);

            output.append(orbitalName).append(counter).append(" ");

            tempAtomicNumber -= counter;
            if (tempAtomicNumber <= 0) {
                break;
            }

        }

        return output.toString();
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    @Override
    public String toString() {
        return "Atom{" +
                "name='" + name + '\'' +
                '}';
    }
}

