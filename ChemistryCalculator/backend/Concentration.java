package ChemistryCalculator.backend;

public class Concentration {
    private final Compound compound;
    //gm unit
    private final double givenCompoundMass;
    //ml unit for molarity || gm unit for molality
    private final double volumeOfSolution;

    public Concentration(Compound compound, double givenCompoundMass, double volumeOfSolution) {
        this.compound = compound;
        this.givenCompoundMass = givenCompoundMass;
        this.volumeOfSolution = volumeOfSolution;
    }


    public double getMolarity() {
        return (1000 * givenCompoundMass) / (compound.getMolarMass() * volumeOfSolution);
    }


    public double getMolality() {
        double massOfSolvent = volumeOfSolution - givenCompoundMass;
        return (givenCompoundMass * 1000) / (compound.getMolarMass() * massOfSolvent);
    }

    public double geNormality(double equivalentNumber) {
        return getMolarity() * equivalentNumber;
    }
}
