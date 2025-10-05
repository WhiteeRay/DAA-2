package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {

    private static final String OUTPUT_FILE = "metrics.csv";
    private static final PerformanceTracker INSTANCE = new PerformanceTracker();

    private PerformanceTracker() {

        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            writer.write("algorithm,n,comparisons,assignments,maxDepth,timeMs\n");
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to initialize CSV file", ex);
        }
    }

    public static PerformanceTracker getInstance() {
        return INSTANCE;
    }

    public void append(Metrics metrics) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE, true)) {
            String row = String.format(
                    "%s,%d,%d,%d,%d,%d%n",
                    metrics.getAlgorithm(),
                    metrics.getSize(),
                    metrics.getComparisons(),
                    metrics.getSize(),
                    metrics.getMaxDepth(),
                    metrics.getElapsedMillis()
            );
            writer.write(row);
        } catch (IOException e) {
            throw new RuntimeException("Error writing metrics to CSV", e);
        }
    }
}