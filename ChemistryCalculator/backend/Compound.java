package ChemistryCalculator.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Compound {
    private final String compound;
    private final CompoundManager compoundManager;
    private ArrayList<HashMap<String, String>> percentageOfCompletion;
    private Double molarMass;

    public Compound(String compound) {
        this.compound = compound;
        this.compoundManager = new CompoundManager(compound);
    }

    // total mass of a compound.Example => H2O
    // MolarMass = (1.00794*2)+ 15.9994
    private void calculateMolarMass() {
        double sum = 0;
        for (Map.Entry<Atom, Integer> entry : compoundManager.getAtomList().entrySet()) {
            Atom atom = entry.getKey();
            Integer v = entry.getValue();
            int totalAtoms = compoundManager.getElementMatrix().get(0).get(v);
            double atomicMass = (double) totalAtoms * atom.getAtomicMass();
            sum += atomicMass;

        }
        this.molarMass = sum;

    }

    //percentage of every atom present in the compound. Based on - mass
    //Example => H2O
    //mass of H => (1.00794*2)
    //mass of O => (15.9994)
    //percentage of H in H2O => (1.00794*2)/molar mass of H2O *100
    //percentage of O in H2O => (15.9994)/molar mass of H2O *100

    private void calculatePercentageOfCompletion() {
        int totalElements = compoundManager.getAtomList().entrySet().size();
        percentageOfCompletion = new ArrayList<>(totalElements);
        for (Map.Entry<Atom, Integer> entry : compoundManager.getAtomList().entrySet()) {
            HashMap<String, String> elementDetails = new HashMap<>();

            Atom atom = entry.getKey();
            Integer v = entry.getValue();
            int totalAtoms = compoundManager.getElementMatrix().get(0).get(v);
            double atomicMass = (double) totalAtoms * atom.getAtomicMass();
            elementDetails.put("symbol", atom.getSymbol());
            elementDetails.put("name", atom.getName());
            elementDetails.put("atomicMass", String.valueOf(atomicMass));
            elementDetails.put("totalAtoms", String.valueOf(totalAtoms));

            percentageOfCompletion.add(elementDetails);

        }
        for (HashMap<String, String> element : percentageOfCompletion) {
            double massPercent = (Double.parseDouble(element.get("atomicMass")) / this.getMolarMass()) * 100;
            element.put("massPercent", String.valueOf(massPercent));
        }

    }


    public ArrayList<HashMap<String, String>> getPercentageOfCompletion() {
        if (percentageOfCompletion == null) {
            this.calculatePercentageOfCompletion();
        }
        return percentageOfCompletion;
    }

    public String getCompound() {
        return compound;
    }

    public double getMolarMass() {
        if (molarMass == null) {
            this.calculateMolarMass();
        }
        return molarMass;
    }
    public Atom[] getAtomList(){
        return compoundManager.getAtomList().keySet().toArray(new Atom[0]);
    }

}
