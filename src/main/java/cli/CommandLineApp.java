package cli;

import algorithms.kadane.KadaneAlgorithm;
import metrics.Metrics;

import java.io.IOException;
import java.util.*;

public class CommandLineApp {

    private static final Map<Integer, String> MENU = Map.of(
            0, "Run Kadane’s Algorithm",
            1, "Exit"
    );

    public static void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        KadaneAlgorithm kadane = new KadaneAlgorithm();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.print("Enter input size (e.g. 1000): ");
                    int size = scanner.nextInt();

                    System.out.print("Enter min value (e.g. -500): ");
                    int minValue = scanner.nextInt();

                    System.out.print("Enter max value (e.g. 500): ");
                    int maxValue = scanner.nextInt();

                    List<Integer> inputArray = generateRandomList(size, minValue, maxValue);
                    kadane.setArray(inputArray);

                    int maxSum = kadane.findMaxSubarraySum();
                    List<Integer> subarray = kadane.getMaxSubarray();

                    System.out.println("\nInput size: " + size);
                    System.out.println("Max Subarray Sum: " + maxSum);
                    System.out.println("Max Subarray: " + subarray);
                    System.out.println("\nPerformance Metrics:");
                    System.out.println(Metrics.getInstance());
                }
                case 1 -> running = false;
                default -> System.out.println("Invalid selection, try again.");
            }
        }
    }

    private static List<Integer> generateRandomList(int size, int min, int max) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max - min + 1) + min);
        }
        return list;
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        MENU.forEach((num, name) -> System.out.println("[" + num + "] " + name));
        System.out.print("Your choice: ");
    }
}
