package ChemistryCalculator.backend;

import java.util.Arrays;

public class Matrix {

    private final Fraction[][] matrix;
    private Fraction[] nullSpaces = null;

    public Matrix(Fraction[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(int[][] matrix) {
        this.matrix = intToFraction(matrix);
    }

    int getHeight() {
        return matrix.length;
    }

    int getWidth() {
        return matrix[0].length;
    }

    private Fraction[][] intToFraction(int[][] matrix) {
        Fraction[][] newMatrix = new Fraction[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = new Fraction(matrix[i][j]);
            }

        }
        return newMatrix;
    }


    //Transforming a matrix into Row Echelon Form using Gaussian elimination method
    //A rectangular matrix is in row echelon form if it has the following three properties:
    //All nonzero rows are above any rows of all zeros
    //Each leading entry of a row is in a column to the right of the leading entry of the row above it
    //All entries of a column below a leading entry are zeros

    //This matrix is in row echelon form:
    //    1   0   3   3
    //    0   1   0   4
    //    0   0   0   1

    //more info => https://en.wikipedia.org/wiki/Gaussian_elimination#Echelon_form

    public Matrix gaussianElimination() {
        int i = 0;
        int j = 0;

        while (i < matrix.length && j < matrix[0].length) {

            int pivot = i;
            for (int k = i + 1; k < matrix.length; k++) {
                if (matrix[k][j].isAbsGreaterThan(matrix[pivot][j])) {
                    pivot = k;
                }
            }

            if (!matrix[pivot][j].isZero()) {
                Fraction[] temp = matrix[i];
                matrix[i] = matrix[pivot];
                matrix[pivot] = temp;

                Fraction div = matrix[i][j];

                for (int idx = 0; idx < matrix[0].length; idx++) {
                    matrix[i][idx] = matrix[i][idx].divide(div);

                }

                for (int u = i + 1; u < matrix.length; u++) {
                    Fraction mult = matrix[u][j];
                    if (!mult.isZero()) {
                        for (int l = 0; l < matrix[0].length; l++) {
                            matrix[u][l] = matrix[u][l].subtract(mult.multiply(matrix[i][l]));

                        }
                    }
                }
            }
            j++;
            i++;
        }

        return new Matrix(matrix);
    }

    //back Substitution is the process of solving a linear system of equations that has been transformed into row-echelon form or reduced row-echelon form
    //The last equation is solved first, then the next-to-last, etc.

    private void backSubstitute(int n, Matrix echelonForm) {

        for (int i = n - 1; i >= 0; i--) {
            Fraction sum = new Fraction(0);
            for (int j = i + 1; j < echelonForm.getWidth(); j++) {
                sum = sum.add(echelonForm.matrix[i][j].multiply(echelonForm.nullSpaces[j]));
            }
            echelonForm.nullSpaces[i] = sum.multiply(new Fraction(-1));

        }
    }

    //In mathematics, more specifically in linear algebra and functional analysis, the kernel of a linear mapping,
    //also known as the null space or nullspace, is the set of vectors in the domain of the mapping which are mapped to the zero vector.

    //But this function returns only one set of vector which is enough for Chemical Equation Balancing.
    //Invalid Chemical Equation has no nullSpace

    public Fraction[] nullSpace() {
        Matrix echelonFormed = gaussianElimination();

        if (echelonFormed.getHeight() > echelonFormed.getWidth()) {
            for (int k = 0; k < echelonFormed.getWidth(); k++) {
                if (k == echelonFormed.getWidth() - 1 && echelonFormed.matrix[k][k].equals(new Fraction(1))) {
                  // "Has No Null Space"
                    break;
                }

                if (echelonFormed.matrix[k][k].isZero()) {
                    echelonFormed.nullSpaces = new Fraction[echelonFormed.getWidth()];
                    Arrays.fill(echelonFormed.nullSpaces, k, echelonFormed.getWidth(), new Fraction(1));
                    backSubstitute(k, echelonFormed);
                    break;
                }

            }

        } else if (echelonFormed.getHeight() < echelonFormed.getWidth()) {
            for (int k = 0; k < echelonFormed.getHeight(); k++) {
                if (k == echelonFormed.getHeight() - 1 && echelonFormed.matrix[k][k].equals(new Fraction(1))) {
                    echelonFormed.nullSpaces = new Fraction[echelonFormed.getWidth()];
                    Arrays.fill(echelonFormed.nullSpaces, k + 1, echelonFormed.getWidth(), new Fraction(1));
                    backSubstitute(k + 1, echelonFormed);
                    break;
                }

                if (echelonFormed.matrix[k][k].isZero()) {
                    echelonFormed.nullSpaces = new Fraction[echelonFormed.getWidth()];
                    Arrays.fill(echelonFormed.nullSpaces, k, echelonFormed.getWidth(), new Fraction(1));
                    backSubstitute(k, echelonFormed);
                    break;
                }
            }

        } else {
            for (int k = 0; k < echelonFormed.getHeight(); k++) {
                if (echelonFormed.matrix[k][k].isZero()) {
                    echelonFormed.nullSpaces = new Fraction[echelonFormed.getWidth()];
                    Arrays.fill(echelonFormed.nullSpaces, k, echelonFormed.getWidth(), new Fraction(1));
                    backSubstitute(k, echelonFormed);
                    break;
                } else if (k == echelonFormed.getHeight() - 1 && echelonFormed.matrix[k][k].equals(new Fraction(1))) {
                   //"Has No NullSpace"
                    break;
                }
            }

        }
        return echelonFormed.nullSpaces;

    }

    public Matrix transpose() {
        Fraction[][] transposedMatrix = new Fraction[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return new Matrix(transposedMatrix);
    }

    @Override
    public String toString() {
        return "Matrix{" + "matrix=" + Arrays.deepToString(matrix) + '}';
    }

}
