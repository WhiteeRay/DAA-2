package cli;

import algorithms.kadane.KadaneAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};

        if (args.length > 0) {
            sizes = parseSizes(args);
        }

        System.out.println();
        System.out.println("Kadane’s Algorithm Benchmark Runner");
        System.out.println("Benchmarking maximum subarray performance:\n");

        for (int size : sizes) {
            System.out.printf("Generating random array of size %,d...%n", size);
            List<Integer> array = generateRandomArray(size);

            KadaneAlgorithm kadane = new KadaneAlgorithm(array);

            long start = System.nanoTime();
            int result = kadane.findMaxSubarraySum();
            long end = System.nanoTime();

            double durationMs = (end - start) / 1_000_000.0;

            System.out.printf("Max sum: %,d | Time: %.3f ms%n%n", result, durationMs);
        }

        System.out.println("Benchmark finished.");
    }

    private static List<Integer> generateRandomArray(int size) {
        Random random = new Random();
        List<Integer> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(2001) - 1000); // range [-1000, 1000]
        }
        return array;
    }

    private static int[] parseSizes(String[] args) {
        int[] parsed = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            parsed[i] = Integer.parseInt(args[i]);
        }
        return parsed;
    }
}
