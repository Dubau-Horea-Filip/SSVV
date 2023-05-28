package org.example;


import examen.HappyFeelings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindSadFeelingTest {

    @Test
    void testFindSadFeeling_PositionWithSadFeeling() {
        // Test array with sad (-1), neutral (0), and happy (1) feelings
        int[] array = { 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1};

        int start = 0;
        int expected = 4;

        int result = HappyFeelings.FindSadFeeling(array, start);

        Assertions.assertEquals(expected, result);
    }



    @Test
    void testFindSadFeeling_PositionBeyondArrayLength() {
        // Test array with sad (-1), neutral (0), and happy (1) feelings
        int[] array = {-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1};

        int start = array.length;
        int expected = -1;

        int result = HappyFeelings.FindSadFeeling(array, start);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindSadFeeling_PositionAtBeginningOfArray() {
        // Test array with sad (-1), neutral (0), and happy (1) feelings
        int[] array = {-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1};

        int start = 0;
        int expected = 0;

        int result = HappyFeelings.FindSadFeeling(array, start);

        Assertions.assertEquals(expected, result);
    }


    @Test
    void testFindSadFeeling_EmptyArray() {
        int[] emptyArray = {};
        int start = 0;
        int expected = -1;

        int result = HappyFeelings.FindSadFeeling(emptyArray, start);

        Assertions.assertEquals(expected, result);
    }
}
