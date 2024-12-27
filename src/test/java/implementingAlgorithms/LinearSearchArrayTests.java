package implementingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinearSearchArrayTests {

    private final int[] numbers1 = new int[] {1, 2, 3, 4, 5}; //4
    private final int[] numbers2 = new int[] {-5, 0, -9, 16, 1}; //3
    private final int[] numbers3 = new int[] {13}; //0
    private final int[] numbers4 = new int[] {1, -2, 3, 3}; //2
    private final int[] numbers5 = new int[] {}; //-1

    @Test
    void runFindValues() {
        Assertions.assertEquals(0, findIndexOfValue(numbers1, 1));
        Assertions.assertEquals(4, findIndexOfValue(numbers2, 1));
        Assertions.assertEquals(-1, findIndexOfValue(numbers3, 1));
        Assertions.assertEquals(2, findIndexOfValue(numbers4, 3));
        Assertions.assertEquals(-1, findIndexOfValue(numbers5, 1));
    }

    @Test
    void runFindValuesWithSort() {
        Assertions.assertEquals(2, findIndexOfValueWithSorted(numbers1, 3));
        Assertions.assertEquals(-1, findIndexOfValueWithSorted(numbers1, 0));
        Assertions.assertEquals(-1, findIndexOfValueWithSorted(numbers1, 6));
    }

    private static int findIndexOfValue(int[] numbers, int value) {
        int index = -1;
        if (numbers.length == 0) {
            return index;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findIndexOfValueWithSorted(int[] numbers, int value) {
        int index = -1;
        if (numbers.length == 0) {
            return index;
        }

        if ((numbers[0] > value) || (numbers[numbers.length - 1] < value)) {
            return index;
        }

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    //Homework
    public static int findIndexInRange(int[] numbers, int value, int left, int rightNonInclusive) {
        if (numbers == null || left < 0 || rightNonInclusive > numbers.length || left >= rightNonInclusive) {
            return -1;
        }

        for (int i = left; i < rightNonInclusive; i++) {
            if (numbers[i] == value) {
                return i;
            }
        }

        return -1;
    }

    @Test
    void findIndexInRangeTest() {
        Assertions.assertEquals(0, findIndexInRange(numbers1, 1, 0, 1));
        Assertions.assertEquals(-1, findIndexInRange(numbers2, 1, 0, 2));
        Assertions.assertEquals(-1, findIndexInRange(numbers3, 13, 0, 3));
        Assertions.assertEquals(-1, findIndexInRange(numbers4, 2, 0, 3));
        Assertions.assertEquals(-1, findIndexInRange(numbers5, 1, 0, 1));
    }

    @Test
    void emptyArrayTest() {
        int[] array = {};
        int a = 0, b = 0, target = 1;
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> findIndexInRange2(array, a, b, target));
        System.out.print("Exception message: " + thrown.getMessage());
        assertTrue(thrown.getMessage().contains("Start index 'a' must be less than end index 'b'"));
    }

    public static int findIndexInRange2(int[] array, int a, int b, int target) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        if (a < 0) {
            throw new IllegalArgumentException("Start index 'a' cannot be negative.");
        }

        if (b > array.length) {
            throw new IllegalArgumentException("End index 'b' cannot exceed array length.");
        }

        if (a >= b) {
            throw new IllegalArgumentException("Start index 'a' must be less than end index 'b'.");
        }

        for (int i = a; i < b; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
