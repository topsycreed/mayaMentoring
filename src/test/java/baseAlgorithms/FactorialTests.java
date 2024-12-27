package baseAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTests {

    @Test
    void factorialWithRecursion() {
        Assertions.assertEquals(factorialUsingRecursion(0), factorialUsingForLoop(0));
        Assertions.assertEquals(factorialUsingRecursion(1), factorialUsingForLoop(1));
        Assertions.assertEquals(factorialUsingRecursion(2), factorialUsingForLoop(2));
        Assertions.assertEquals(factorialUsingRecursion(5), factorialUsingForLoop(5));
        Assertions.assertEquals(factorialUsingRecursion(20), factorialUsingForLoop(20));
    }

    private static long factorialUsingRecursion(int n) {
        if (n < 0) {
            throw new RuntimeException("Use positive numbers!");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorialUsingRecursion(n - 1);
    }
    private static long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
