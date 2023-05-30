package org.example;

import examen.HappyFeelings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigBang_BeHappy_Test {

    @Test
    void testBeHappy_NoSadFeelings() {
        int[] array = {1, 0, 1};

        int[] expected = {1, 0, 1};

        int[] result = HappyFeelings.BeHappy(array);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testBeHappy_SingleSadFeeling() {
        int[] array = {-1, 0, 1};

        int[] expected = {1, -1, 1, 0, 1};
        int[] result = HappyFeelings.BeHappy(array);

        Assertions.assertEquals(HappyFeelings.FindSadFeeling(array, 0), 0);
        Assertions.assertFalse(HappyFeelings.CheckNeighbours(array, 0));
        HappyFeelings.InsertHappyFeelings(array, 0);


        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testBeHappy_MultipleSadFeelings() {
        int[] array = {-1, 0, 1, 0, -1};

        int[] expected = {1, -1, 1, 0, 1, 0, 1, -1, 1};

        Assertions.assertEquals(HappyFeelings.FindSadFeeling(array, 0), 0);
        Assertions.assertFalse(HappyFeelings.CheckNeighbours(array, 0));
        HappyFeelings.InsertHappyFeelings(array, 0);

        Assertions.assertEquals(HappyFeelings.FindSadFeeling(array, 2), 4);
        Assertions.assertFalse(HappyFeelings.CheckNeighbours(array, 4));
        HappyFeelings.InsertHappyFeelings(array, 4);

        int[] result = HappyFeelings.BeHappy(array);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testBeHappy_SadFeelingsWithHappyNeighbours() {
        int[] array =    {1, 0, 1, -1, 1, 0, 1, -1, 1};

        int[] expected = {1, 0, 1, -1, 1, 0, 1, -1, 1};


        Assertions.assertEquals(HappyFeelings.FindSadFeeling(array, 0), 3);
        Assertions.assertTrue(HappyFeelings.CheckNeighbours(array, 0));
        if(!HappyFeelings.CheckNeighbours(array, 3)) HappyFeelings.InsertHappyFeelings(array, 3);

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
