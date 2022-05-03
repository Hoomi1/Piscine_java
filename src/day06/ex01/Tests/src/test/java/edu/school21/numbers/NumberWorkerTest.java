package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;

public class NumberWorkerTest {

    NumberWorker numberWorker;

    @BeforeEach
    void prepareDate()
    {
        numberWorker = new NumberWorker();
    }

    //TODO: 3 проверки минимум в каждом  методе

    @ParameterizedTest
    @ValueSource(ints = {7, 11, 13, 2, 3, 19, 113})
    void isPrimeForPrimes(int arguments)
    {
        Assertions.assertTrue(numberWorker.isPrime(arguments));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 8, 9, 16, 25, 100, 169})
    void isPrimeForNotPrimes(int arguments)
    {
        Assertions.assertFalse(numberWorker.isPrime(arguments));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1, 0, -150, -1000})
    void isPrimeForIncorrectNumbers(final int arguments)
    {
        Assertions.assertThrows(IllegalNumberException.class, () -> {
            numberWorker.isPrime(arguments);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void digitsSum(int input, int expected)
    {
        Assertions.assertEquals(expected, numberWorker.digitSum(input));
    }

}