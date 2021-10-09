package ChemistryCalculator.backend;

public class InvalidEquationException extends RuntimeException{
    public InvalidEquationException(String s) {
        super(s);
    }
}
