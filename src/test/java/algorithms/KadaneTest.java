package algorithms;

import algorithms.kadane.KadaneAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KadaneTest {
    private Kadane kadane;

    @BeforeEach
    void setUp() {
        kadane = new KadaneAlgorithm();
    }

    @Test
    void testFindMaxSubarraySum_PositiveAndNegative() {
        kadane.setArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        assertEquals(6, kadane.findMaxSubarraySum());
    }

    @Test
    void testGetMaxSubarray_PositiveAndNegative() {
        kadane.setArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        List<Integer> expected = Arrays.asList(4, -1, 2, 1);
        assertEquals(expected, kadane.getMaxSubarray());
    }

    @Test
    void testFindMaxSubarraySum_AllNegative() {
        kadane.setArray(Arrays.asList(-8, -3, -6, -2, -5, -4));
        assertEquals(-2, kadane.findMaxSubarraySum());
    }

    @Test
    void testGetMaxSubarray_AllNegative() {
        kadane.setArray(Arrays.asList(-8, -3, -6, -2, -5, -4));
        assertEquals(Collections.singletonList(-2), kadane.getMaxSubarray());
    }

    @Test
    void testFindMaxSubarraySum_AllPositive() {
        kadane.setArray(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(15, kadane.findMaxSubarraySum());
    }

    @Test
    void testGetMaxSubarray_AllPositive() {
        kadane.setArray(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), kadane.getMaxSubarray());
    }

    @Test
    void testEmptyArrayThrowsException() {
        assertThrows(IllegalStateException.class, () -> kadane.findMaxSubarraySum());
        assertThrows(IllegalStateException.class, () -> kadane.getMaxSubarray());
    }

    @Test
    void testClearArray() {
        kadane.setArray(Arrays.asList(1, 2, 3));
        kadane.clear();
        assertTrue(kadane.getArray().isEmpty());
    }
}
