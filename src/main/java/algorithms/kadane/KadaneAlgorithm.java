package algorithms.kadane;

import algorithms.Kadane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of Kadane’s Algorithm — the classic “maximum subarray sum” problem.
 * Basically, it finds the contiguous part of an array that has the highest total sum.
 */
public class KadaneAlgorithm implements Kadane {
    private List<Integer> array;

    // Default constructor — starts with an empty list
    public KadaneAlgorithm() {
        this.array = new ArrayList<>();
    }

    // Constructor with an initial array — makes a copy so the original list isn’t modified
    public KadaneAlgorithm(List<Integer> array) {
        this.array = new ArrayList<>(array);
    }

    @Override
    public void setArray(List<Integer> array) {
        // Replace the current array with a new one (copied for safety)
        this.array = new ArrayList<>(array);
    }

    @Override
    public List<Integer> getArray() {
        // Return a read-only view so no one can accidentally mess with it
        return Collections.unmodifiableList(array);
    }

    @Override
    public int findMaxSubarraySum() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Array is empty. Please initialize it first.");
        }

        // Initialize both max values with the first element
        int maxSoFar = array.get(0);
        int currentMax = array.get(0);

        // Classic Kadane’s loop — if current sum drops below 0, start fresh
        for (int i = 1; i < array.size(); i++) {
            // Either extend the current subarray or start a new one at this index
            currentMax = Math.max(array.get(i), currentMax + array.get(i));
            // Keep track of the best (highest) sum we’ve seen so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    @Override
    public List<Integer> getMaxSubarray() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Array is empty. Please initialize it first.");
        }

        // Same setup as above, but we also track start and end indexes
        int maxSoFar = array.get(0);
        int currentMax = array.get(0);
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < array.size(); i++) {
            // If adding the current element makes things worse, start a new subarray
            if (array.get(i) > currentMax + array.get(i)) {
                currentMax = array.get(i);
                tempStart = i; // potential new start
            } else {
                currentMax += array.get(i);
            }

            // Found a new max? Update the tracking indexes
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        // Return the actual subarray that gave us the max sum
        return new ArrayList<>(array.subList(start, end + 1));
    }

    @Override
    public void clear() {
        // Empty out the array (basically resets the object)
        array.clear();
    }
}
