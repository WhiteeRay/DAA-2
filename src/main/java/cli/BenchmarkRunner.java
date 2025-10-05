package cli;

import algorithms.kadane.KadaneAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Simple CLI-based benchmark for testing Kadane’s Algorithm performance
 * on randomly generated integer arrays of different sizes.
 *
 * You can optionally pass custom sizes as command-line arguments.
 * Example:
 *   java cli.BenchmarkRunner 5000 20000 100000
 */
public class BenchmarkRunner {
    public static void main(String[] args) {
        // Default input sizes for benchmarking
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};

        // If user passes sizes as arguments, override defaults
        if (args.length > 0) {
            sizes = parseSizes(args);
        }

        System.out.println();
        System.out.println("Kadane’s Algorithm Benchmark Runner");
        System.out.println("Benchmarking maximum subarray performance:\n");

        // Run the benchmark for each input size
        for (int size : sizes) {
            System.out.printf("Generating random array of size %,d...%n", size);
            List<Integer> array = generateRandomArray(size);

            KadaneAlgorithm kadane = new KadaneAlgorithm(array);

            // Measure execution time in nanoseconds for precision
            long start = System.nanoTime();
            int result = kadane.findMaxSubarraySum();
            long end = System.nanoTime();

            // Convert duration to milliseconds (easier to read)
            double durationMs = (end - start) / 1_000_000.0;

            System.out.printf("Max sum: %,d | Time: %.3f ms%n%n", result, durationMs);
        }

        System.out.println("Benchmark finished.");
    }

    /**
     * Generates a random integer list of given size.
     * Values range between -1000 and +1000 to simulate both losses and gains.
     */
    private static List<Integer> generateRandomArray(int size) {
        Random random = new Random();
        List<Integer> array = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            // Random number between -1000 and +1000
            array.add(random.nextInt(2001) - 1000);
        }

        return array;
    }

    /**
     * Converts command-line arguments into an array of integers.
     * Example:
     *   args = ["5000", "20000"] → [5000, 20000]
     */
    private static int[] parseSizes(String[] args) {
        int[] parsed = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            parsed[i] = Integer.parseInt(args[i]);
        }
        return parsed;
    }
}
