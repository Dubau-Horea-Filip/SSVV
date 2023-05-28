package org.example;

import examen.HappyFeelings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckNeighboursTest {

    // false means we have to put 1
    // true  means  we don't have to put 1

    @Test
    void testCheckNeighbours_SadPositionWithNoHaappyNeighbours() {
        int[] array = {0, -1, 0};

        int position = 1;
        boolean expected = false;

        boolean result = HappyFeelings.CheckNeighbours(array, position);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckNeighbours_SadPositionWithHappyNeighbours() {
        int[] array = {1, -1, 1};

        int position = 1;
        boolean expected = true;

        boolean result = HappyFeelings.CheckNeighbours(array, position);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckNeighbours_SadPositionWithOnlyOneNeighbour() {
        int[] array = {-1, 0};

        int position = 0;
        boolean expected = false;

        boolean result = HappyFeelings.CheckNeighbours(array, position);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckNeighbours_PositivePosition() {
        int[] array = {1, 0, -1};

        int position = 0;
        boolean expected = true;

        boolean result = HappyFeelings.CheckNeighbours(array, position);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckNeighbours_FirstPosition() {
        int[] array = {-1, 0, 1};

        int position = 0;
        boolean expected = false;

        boolean result = HappyFeelings.CheckNeighbours(array, position);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckNeighbours_LastPosition() {
        int[] array = {1, 0, -1};

        int position = 2;
        boolean expected = false;

        boolean result = HappyFeelings.CheckNeighbours(array, position);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckNeighbours_EmptyArray() {
        int[] emptyArray = {};
        int position = 0;
        boolean expected = true;

        boolean result = HappyFeelings.CheckNeighbours(emptyArray, position);

        Assertions.assertEquals(expected, result);
    }
}
