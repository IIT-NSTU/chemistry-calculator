package ChemistryCalculator.backend;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Fraction(int numr) {
        numerator = numr;
        denominator = 1;
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //computing the greatest common divisor.Example => (3 , 6)  == 3
    public int getGCD(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        while (b != 0) {
            a %= b;
            if (a == 0) {
                return b;
            }
            b %= a;
        }
        return a;
    }

    //Example => 3/6  == 1/3
    private void reduce() {
        int gcd = getGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public Fraction add(Fraction fractionTwo) {
        int newNumerator = (numerator * fractionTwo.getDenominator())
                + (fractionTwo.getNumerator() * denominator);
        int newDenominator = denominator * fractionTwo.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction fractionTwo) {
        int newNumerator = (numerator * fractionTwo.denominator)
                - (fractionTwo.numerator * denominator);
        int newDenominator = denominator * fractionTwo.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.numerator;
        int newDenominator = denominator * fractionTwo.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.getDenominator();
        int newDenominator = denominator * fractionTwo.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public boolean isAbsGreaterThan(Fraction fractionTwo) {

        double first = Math.abs((double)this.getNumerator() / (double)this.getDenominator());
        double second = Math.abs((double)fractionTwo.getNumerator() / (double)fractionTwo.getDenominator());
        return first > second;

    }

    public boolean isZero() {
        return this.getNumerator() == 0;
    }


    public boolean equals(Fraction fractionTwo) {
        return (this.numerator == fractionTwo.numerator && this.denominator == fractionTwo.denominator) ||
                (this.numerator == -fractionTwo.numerator && this.denominator == -fractionTwo.denominator);

    }

    //computing the lowest common multiple. Example => (3, 4, 1, 2) == 12
    public static long getLCM(long[] a) {
        long lcm = 0, max;
        boolean found;
        if (a.length != 0) {

            max = a[0];
            for (long l : a) {
                if (l > max) {
                    max = l;
                }
            }
            for (long i = max;; i += max) {
                found = true;
                for (long l : a) {
                    if (i % l != 0) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    lcm = i;
                    break;
                }
            }
        }
        return lcm;
    }

    //Example => (1/3, 1/4, 1, 3) == (4, 3, 12, 36)
    public static long[] normalize(Fraction[] fraction) {
        long[] result = new long[fraction.length];

        long[] denominator = new long[fraction.length];
        for (int i = 0; i < fraction.length; i++) {

            denominator[i] = fraction[i].getDenominator();

        }
        long lcm = getLCM(denominator);
        for (int i = 0; i < result.length; i++) {
            if (fraction[i].getDenominator() != 0) {
                result[i] = (lcm / fraction[i].getDenominator()) * fraction[i].getNumerator();
            }

        }

        return result;

    }

    @Override
    public String toString() {

        return this.denominator == 1 ? Integer.toString(this.numerator) : this.numerator + "/" + this.denominator;
    }

}
