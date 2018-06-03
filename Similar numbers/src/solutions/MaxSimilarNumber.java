package solutions;

public class MaxSimilarNumber {

    public int solution(int N) {
        int[] digits = new int[10];
        countDigits(N, digits);
        return getMaxNumberFromDigits(digits);
    }

    /**
     * counts how many of each digit there is in the number N.
     * returns the number of digits N has.
     */
    private void countDigits(int N, int[] digits) {
        while(N != 0) {
            digits[N%10]++;
            N=N/10;
        }
    }

    private int getMaxNumberFromDigits(int[] digits) {
        int number = 0;
        for (int index = 9; index >= 0; index--) {
            int numberRepetitionOfDigit = digits[index];
            number = addToNumberDigits(number, numberRepetitionOfDigit, index);
        }
        return number;
    }

    private int addToNumberDigits(int number, int length, int digit) {
        while (length != 0) {
            number = 10 * number + digit;
            length--;
        }
        return number;
    }
}
