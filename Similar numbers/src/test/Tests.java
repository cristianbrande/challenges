package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import solutions.MaxSimilarNumber;
import solutions.SimilarNumbers;

class Tests {

    @Test
    void testMaxSimilarNumber() {
        MaxSimilarNumber maxSimilarNumber = new MaxSimilarNumber();

        // assert statements
        Assertions.assertEquals(321, maxSimilarNumber.solution(123));
        Assertions.assertEquals(111, maxSimilarNumber.solution(111));

    }


    @Test
    void testSimilarNumber() {
        SimilarNumbers similarNumbers = new SimilarNumbers();

        // assert statements
        Assertions.assertEquals(1, similarNumbers.solution(100));
        Assertions.assertEquals(12, similarNumbers.solution(1214));
        Assertions.assertEquals(6, similarNumbers.solution(123));
        Assertions.assertEquals(1, similarNumbers.solution(0));
    }
}
