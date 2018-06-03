package solutions;
public class SimilarNumbers {

    public int solution(int N) {
        int[] digits = new int[10];
        int nrOfDigits = countDigits(N, digits);
        return calculateSimilarNumbers(nrOfDigits, digits);
    }

    /**
     * counts how many of each digit there is in the number N.
     * returns the number of digits N has.
     */
    private int countDigits(int N, int[] digits) {
        int nrOfDigits = 0;
        while(N != 0) {
            digits[N%10]++;
            N=N/10;
            nrOfDigits++;
        }
        return nrOfDigits;
    }

    /**
     * The method receives the number of digits the similar numbers should have and the digits it should have.
     * digits is an array[10] where each index represents the appearance of that digit.
     */
    private int calculateSimilarNumbers(int size, int[] digits) {
        int nrToDivideBy = 1;
        // we calculate the repetition of each digit.
        for (int index = 1; index <= 9; index++) {
            if (digits[index] == 0) {
                continue;
            }
            nrToDivideBy *= factorial(digits[index]);
        }
        // if the number contains the 0 digit
        if (digits[0] != 0) {
            return factorial(size - digits[0])/nrToDivideBy;
        }
        // if the number does not contain the 0 digit
        return factorial(size)/nrToDivideBy;
    }

    /**
     * calculates the factorial of the given number
     */
    private int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
}
