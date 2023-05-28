package examen;

import java.util.Arrays;

public class HappyFeelings {
    public static void main(String[] args) {
        int[] array = {1, 0, 1, 0,1, -1, 1};
       // int[] array = {-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1,1, 0, 1, 1};
        int[] result = BeHappy(array);
        System.out.println(Arrays.toString(result));
    }

    //FindSadFeeling = finding first sad position starting at position i given.
    public static int FindSadFeeling(int[] array, int start) {
        for (int i = start; i < array.length; i++) {
            if (array[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    //2) CheckNeighbours = check neighbours of a given position i given
    // (if value on position i is -1 and has no happy feelings as neighbours)
    // false means we have to put 1
    // true  means  we dont have to put 1
    public static boolean CheckNeighbours(int[] array, int position) {
        if (array.length == 0)
            return true;
        if (array[position] == -1) {
            if (position > 0)
            {

                int prev = array[position - 1];
                if (prev != 1)  return false; // Previous element is not -1,

            } else return false; // First element, so we have to put 1



            if (position < array.length - 1) {
                int next = array[position + 1];
                if(next != 1)
                return false; // Next element is not -1, so it's a happy feeling
            } else {
                return false; // Last element, so it's a happy feeling
            }
        }

        return true; // Positive value, so it's a happy feeling
    }

//3) InsertHappyFeelings before and after a given i position (value on position i is -1)


    public static int[] InsertHappyFeelings(int[] array, int position) {
        int[] newArray = new int[array.length + 2];

        for (int i = 0; i < position; i++) {
            newArray[i] = array[i];
        }


        newArray[position] = 1;
        newArray[position + 1] = -1;

        newArray[position + 2] = 1;

        for (int i = position + 1; i < array.length; i++) {
            newArray[i + 2] = array[i];
        }

        return newArray;
    }


    public static int[] BeHappy(int[] array) {
        int start = FindSadFeeling(array, 0);

        if (start == -1 || array[start] != -1) {
            return array;
        }

        if (!CheckNeighbours(array, start)) {
            array = InsertHappyFeelings(array, start);
        }

        while (true) {
            start = FindSadFeeling(array, start + 3);

            if (start == -1) {
                break;
            }

            if (!CheckNeighbours(array, start)) {
                array = InsertHappyFeelings(array, start);
            }
        }

        return array;
    }
}


