package ChemistryCalculator.backend;

import java.util.Arrays;

public class Titration {

    private final String[] acidProperties = new String[3];
    private final String[] baseProperties = new String[3];
    private boolean unknownValue_in_Acid = false;

    //Here one and only one property can be empty, which is the unknown value
    public Titration(String molarityOfAcid,
                     String molarityOfBase,
                     String volumeOfAcid,
                     String volumeOfBase,
                     String numOfMolesOfAcid,
                     String numOfMolesOfBase) {
        acidProperties[0] = molarityOfAcid;
        acidProperties[1] = volumeOfAcid;
        acidProperties[2] = numOfMolesOfAcid;

        baseProperties[0] = molarityOfBase;
        baseProperties[1] = volumeOfBase;
        baseProperties[2] = numOfMolesOfBase;
    }

    //Executing formula  =>  (numOfMolesOfBase*molarityOfBase*volumeOfBase) = numOfMolesOfAcid*molarityOfAcid*volumeOfAcid)
    public double getUnknownValue() {
        if (this.isValid()) {

            double numerator;
            double denominator = 1;
            if (unknownValue_in_Acid) {

                numerator = Arrays.stream(baseProperties).mapToDouble(Double::parseDouble).reduce(1, (a, b) -> a * b);
                for (String property : acidProperties) {
                    if (!property.isEmpty()) {
                        denominator *= Double.parseDouble(property);
                    }
                }
                return numerator / denominator;
            } else {
                numerator = Arrays.stream(acidProperties).mapToDouble(Double::parseDouble).reduce(1, (a, b) -> a * b);
                for (String property : baseProperties) {
                    if (!property.isEmpty()) {
                        denominator *= Double.parseDouble(property);
                    }
                }

                return numerator / denominator;

            }
        } else {
            throw new InsufficientDataException("\"Fill up any 5 fields to get unknown value\"");
        }


    }


    // if there is only one index value contain empty string  in both String[] acidProperties and String[] baseProperties, then its return true. False otherwise
    private boolean isValid() {
        int count = 0;
        for (String property : acidProperties) {
            if (property.isEmpty()) {
                unknownValue_in_Acid = true;
                count++;
            }
        }
        count += Arrays.stream(baseProperties).filter(String::isEmpty).count();
        return count < 2;
    }

}
