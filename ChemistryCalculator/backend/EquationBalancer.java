package ChemistryCalculator.backend;


public class EquationBalancer {
    private final String reactants;
    private final String products;

    public EquationBalancer(String reactants, String products) {
        this.reactants = reactants;
        this.products = products;
    }

    public String balance() {
        String balancedEquation;
        //removing all whitespace
        String[] reactants = this.reactants.replaceAll("\\s+", "").split("\\+");
        String[] products = this.products.replaceAll("\\s+", "").split("\\+");

        CompoundManager manager = new CompoundManager(reactants[0]);
        for (int i = 1; i < reactants.length; i++) {
            manager.append(reactants[i], i, 1);
        }

        //products should be inputted as negative numbers into our matrix.
        for (int i = 0; i < products.length; i++) {
            manager.append(products[i], i + reactants.length, -1);
        }


        //mapping  ArrayList<ArrayList<Integer>> to int[][] as Matrix class takes int[][].
        int[][] elementsMatrix = manager.getElementMatrix().stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);

        Matrix matrix = new Matrix(elementsMatrix);
        Fraction[] nullSpace = matrix.transpose().nullSpace();
        if (nullSpace != null) {
            long[] balancedCoefficient = Fraction.normalize(nullSpace);

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < reactants.length; i++) {
                if (i == reactants.length - 1) {
                    if (balancedCoefficient[i] == 1) {
                        result.append(reactants[i]).append(" ");
                    } else {
                        result.append(balancedCoefficient[i]).append(reactants[i]).append(" ");
                    }
                } else {
                    if (balancedCoefficient[i] == 1) {
                        result.append(reactants[i]).append(" + ");
                    } else {
                        result.append(balancedCoefficient[i]).append(reactants[i]).append(" + ");
                    }
                }

            }

            result.append("= ");


            for (int i = 0; i < products.length; i++) {
                if (i == products.length - 1) {
                    if (balancedCoefficient[i + reactants.length] == 1) {
                        result.append(products[i]).append(" ");
                    } else {
                        result.append(balancedCoefficient[i + reactants.length]).append(products[i]).append(" ");
                    }
                } else {
                    if (balancedCoefficient[i + reactants.length] == 1) {
                        result.append(products[i]).append(" + ");
                    } else {
                        result.append(balancedCoefficient[i + reactants.length]).append(products[i]).append(" + ");
                    }
                }

            }
            balancedEquation = result.toString();


        } else {
            throw new InvalidEquationException("Error ! given equation is not vaild");
        }

        return balancedEquation;
    }
}
