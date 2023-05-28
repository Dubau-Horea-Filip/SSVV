package org.example;

import examen.HappyFeelings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeHappyTest {

    @Test
    void testBeHappy_NoSadFeelings() {
        int[] array = {1, 0, 1};

        int[] expected = {1, 0, 1};

        int[] result = HappyFeelings.BeHappy(array);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testBeHappy_SingleSadFeeling() {
        int[] array = {1, -1, 0, 1};

        int[] expected = {1, 1, -1, 1, 0, 1};

        int[] result = HappyFeelings.BeHappy(array);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testBeHappy_MultipleSadFeelings() {
        int[] array = {1, -1, 0, -1, 1};

        int[] expected = {1, 1, -1, 1, 0, 1, -1, 1, 1};

        int[] result = HappyFeelings.BeHappy(array);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testBeHappy_SadFeelingsWithHappyNeighbours() {
        int[] array = {1, 0, 1, -1, 1, 0,1, -1, 1};

        int[] expected = {1, 0, 1, -1, 1, 0, 1, -1,  1};

        int[] result = HappyFeelings.BeHappy(array);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testBeHappy_EmptyArray() {
        int[] emptyArray = {};

        int[] expected = {};

        int[] result = HappyFeelings.BeHappy(emptyArray);

        Assertions.assertArrayEquals(expected, result);
    }
}
