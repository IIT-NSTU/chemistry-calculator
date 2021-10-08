package ChemistryCalculator.backend;

import java.util.ArrayList;
import java.util.HashMap;

public class CompoundManager {
    private final HashMap<String, Integer> elementList = new HashMap<>();
    private final ArrayList<ArrayList<Integer>> elementMatrix = new ArrayList<>();
    private final HashMap<Atom, Integer> atomList = new HashMap<>();

    public CompoundManager(String compound, int index, int side) {
        this.compoundDecipher(compound, index, side);
    }

    public CompoundManager(String compound) {
        this.compoundDecipher(compound, 0, 1);
    }

    public CompoundManager(Compound compound, int index, int side) {
        this.compoundDecipher(compound.getCompound(), index, side);
    }

    public CompoundManager(Compound compound) {
        this.compoundDecipher(compound.getCompound(), 0, 1);
    }

    public void append(String compound) {
        this.compoundDecipher(compound, 0, 1);
    }

    public void append(String compound, int index, int side) {
        this.compoundDecipher(compound, index, side);
    }

    public void append(Compound compound) {
        this.compoundDecipher(compound.getCompound(), 0, 1);
    }

    public void append(Compound compound, int index, int side) {
        this.compoundDecipher(compound.getCompound(), index, side);
    }


    //this function  breakdown the complex compounds into simple compound(segment).
    //Example = > Cu(SO4)2*5H2O  = Cu, SO4, H2O
    private void compoundDecipher(String compound, int index, int side) {
        //separating out the parenthesis, *,  from the rest of the compound
        String[] segments = compound.split("(?<=\\)([0-9]{0,100}))(?=[A-Z])|(?=\\([A-Za-z0-9]*\\)[0-9]*)|(?=\\*)");

        for (String segment : segments) {
            int multiplier;
            String eachCompound;
            if (segment.startsWith("(")) {
                String[] splitedSegment = segment.split("\\)(?=\\d*)");
                //compoend is in splitedSegment[0] . splitedSegment[1] has the value of  multiplier.
                multiplier = Integer.parseInt(splitedSegment[1]);
                //from splitedSegment[0], taking substring(1) because it startsWith "("
                eachCompound = splitedSegment[0].substring(1);
            } else {
                if (segment.startsWith("*")) {
                    String[] splitedSegment = segment.split("\\*");
                    //splitedSegment[0] is always empty. splitedSegment[1] has the value of compound with multiplier.
                    //Now separating multiplier and compound
                    //multiplier is in index 0, compound in 1
                    String[] compoundWithMultiplier = splitedSegment[1].split("(?<=^[0-9]{0,100})(?=[A-Z])");
                    multiplier = Integer.parseInt(compoundWithMultiplier[0]);
                    eachCompound = compoundWithMultiplier[1];

                } else {
                    multiplier = 1;
                    eachCompound = segment;
                }
            }
            findAtoms(eachCompound, index, multiplier, side);
            //System.out.println("before finding element");
            //System.out.println(eachCompound + "  " + index + "  " + multiplier + "  " + side);
        }
    }

    private void findAtoms(String eachCompound, int index, int multiplier, int side) {
        String[] atomsAndNumbers = eachCompound.split("(?=[A-Z])|(?<=[A-Za-z])(?=[0-9])");
        int i = 0;

        while (i < atomsAndNumbers.length) {

            if ((i + 1) < atomsAndNumbers.length && atomsAndNumbers[i + 1].matches("^[0-9]+$")) {
                int count = Integer.parseInt(atomsAndNumbers[i + 1]) * multiplier;
                addToMatrix(atomsAndNumbers[i], index, count, side);
                i++;
            } else {
                addToMatrix(atomsAndNumbers[i], index, multiplier, side);
            }
            i++;
        }
    }

    //populating elementList and elementMatrix. Example --
    //for an equation =>
    //Reactants = Ca(OH)2 + H3PO4
    //Products = Ca3(PO4)2 + H2O
    //elementList => {P=3, H=2, Ca=0, O=1}
    //elementMatrix => [[1, 2, 2, 0], [0, 4, 3, 1], [-3, -8, 0, -2], [0, -1, -2, 0]]
    //Explanation =>
    //                      Ca,  O,  H,  P
    //         Ca(OH)2    =  1,  2,  2,  0
    //         H3PO4      =  0,  4,  3,  1
    //         Ca3(PO4)2  = -3, -8,  0, -2
    //         H2O        =  0, -1, -2,  0
    //NullSpace of this matrix gives the corresponding balanced Coefficient
    private void addToMatrix(String atoms, int index, int multiplier, int side) {

        if (index == elementMatrix.size()) {
            elementMatrix.add(new ArrayList<>());
            for (int i = 0; i < elementList.size(); i++) {
                elementMatrix.get(index).add(0);
            }
        }

        if (!elementList.containsKey(atoms)) {
            int value = 0;
            if (elementList.size() > 0) {
                value = elementList.size();
            }
            elementList.put(atoms, value);
            atomList.put(Atom.getInstance(atoms), value);
            for (ArrayList<Integer> matrix : elementMatrix) {
                matrix.add(0);
            }

        }

        int column = elementList.get(atoms);
        int value = elementMatrix.get(index).get(column) + multiplier * side;
        elementMatrix.get(index).set(column, value);

    }

    public HashMap<Atom, Integer> getAtomList() {
        return atomList;
    }

    public ArrayList<ArrayList<Integer>> getElementMatrix() {
        return elementMatrix;
    }


}
