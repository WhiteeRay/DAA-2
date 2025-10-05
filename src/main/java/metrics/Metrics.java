package metrics;

public class Metrics {

    private static Metrics singleton;

    private String algorithmName;
    private int dataSize;
    private int comparisonCount;
    private int assignmentCount;
    private int deepestLevel;

    private long startTimestamp;

    private Metrics() {
        reset();
    }

    public static synchronized Metrics getInstance() {
        if (singleton == null) {
            singleton = new Metrics();
        }
        return singleton;
    }

    public void reset() {
        comparisonCount = 0;
        assignmentCount = 0;
        deepestLevel = 0;
        startTimestamp = System.nanoTime();
    }

    public long getElapsedMillis() {
        return (System.nanoTime() - startTimestamp) / 1_000_000;
    }


    public void setAlgorithm(String name) {
        this.algorithmName = name;
    }

    public String getAlgorithm() {
        return algorithmName;
    }

    public void setSize(int size) {
        this.dataSize = size;
    }

    public int getSize() {
        return dataSize;
    }


    public void incComparisons() {
        comparisonCount++;
    }

    public int getComparisons() {
        return comparisonCount;
    }

    public void incAssignments() {
        assignmentCount++;
    }

    public int getAssignments() {
        return assignmentCount;
    }

    public void updateDepth(int depth) {
        if (depth > deepestLevel) {
            deepestLevel = depth;
        }
    }

    public void setMaxDepth(int depth) {
        if (depth > deepestLevel) deepestLevel = depth;
    }

    public int getMaxDepth() {
        return deepestLevel;
    }

    @Override
    public String toString() {
        return String.format(
                "\nAlgorithm: %s" +
                        "\nInput size (n): %d" +
                        "\nComparisons: %d" +
                        "\nAssignments: %d" +
                        "\nMax recursion depth: %d" +
                        "\nTime taken: %d ms\n",
                algorithmName, dataSize, comparisonCount, assignmentCount, deepestLevel, getElapsedMillis()
        );
    }
}