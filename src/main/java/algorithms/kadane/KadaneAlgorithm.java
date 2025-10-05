package algorithms.kadane;

import algorithms.Kadane;
import metrics.PerformanceTracker;
import metrics.Metrics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of Kadane’s Algorithm — the classic “maximum subarray sum” problem.
 * Finds the contiguous part of an array that produces the highest total sum.
 *
 * Now integrated with Metrics and CSVUtils to track algorithm performance.
 */
public class KadaneAlgorithm implements Kadane {
    private List<Integer> array;
    private final Metrics metrics = Metrics.getInstance();

    // Default constructor — starts with an empty list
    public KadaneAlgorithm() {
        this.array = new ArrayList<>();
    }

    // Constructor that initializes with a provided array
    public KadaneAlgorithm(List<Integer> array) {
        this.array = new ArrayList<>(array);
    }

    @Override
    public void setArray(List<Integer> array) {
        // Replace the current array safely (avoid modifying the original reference)
        this.array = new ArrayList<>(array);
    }

    @Override
    public List<Integer> getArray() {

        return Collections.unmodifiableList(array);
    }

    @Override
    public int findMaxSubarraySum() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Array is empty. Please initialize it first.");
        }


        metrics.reset();
        metrics.setAlgorithm("Kadane’s Algorithm");
        metrics.setSize(array.size());

        // Initialize both max values with the first element
        int maxSoFar = array.get(0);
        int currentMax = array.get(0);
        metrics.incAssignments(); // two assignments


        for (int i = 1; i < array.size(); i++) {

            metrics.incComparisons();
            currentMax = Math.max(array.get(i), currentMax + array.get(i));
            metrics.incAssignments();


            metrics.incComparisons();
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                metrics.incAssignments();
            }
        }

        PerformanceTracker.getInstance().append(metrics);

        return maxSoFar;
    }

    @Override
    public List<Integer> getMaxSubarray() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Array is empty. Please initialize it first.");
        }

        // This version tracks not only max sum but also the start and end indexes
        metrics.reset();
        metrics.setAlgorithm("Kadane’s Algorithm (Subarray)");
        metrics.setSize(array.size());

        int maxSoFar = array.get(0);
        int currentMax = array.get(0);
        int start = 0, end = 0, tempStart = 0;

        metrics.incAssignments(); // initial assignments

        for (int i = 1; i < array.size(); i++) {
            metrics.incComparisons();
            // Decide whether to start new subarray or continue
            if (array.get(i) > currentMax + array.get(i)) {
                currentMax = array.get(i);
                tempStart = i;
                metrics.incAssignments(); // assignments inside branch
            } else {
                currentMax += array.get(i);
                metrics.incAssignments();
            }

            // Update maximum if new max found
            metrics.incComparisons();
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
                metrics.incAssignments();
            }
        }

        // Log the metrics for this run
        PerformanceTracker.getInstance().append(metrics);

        // Return the subarray that produced the best sum
        return new ArrayList<>(array.subList(start, end + 1));
    }

    @Override
    public void clear() {
        // Clear the list and reset metrics
        array.clear();
        metrics.reset();
    }
}
