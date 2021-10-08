package ChemistryCalculator.backend;

public class InsufficientDataException extends RuntimeException{
    public InsufficientDataException(String s) {
        super(s);
    }
}
