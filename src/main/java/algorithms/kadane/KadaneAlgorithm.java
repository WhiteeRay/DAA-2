package algorithms.kadane;

import algorithms.Kadane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KadaneAlgorithm implements Kadane {
    private List<Integer> array;

    public KadaneAlgorithm() {
        this.array = new ArrayList<>();
    }

    public KadaneAlgorithm(List<Integer> array) {
        this.array = new ArrayList<>(array);
    }

    @Override
    public void setArray(List<Integer> array) {
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

        int maxSoFar = array.get(0);
        int currentMax = array.get(0);

        for (int i = 1; i < array.size(); i++) {
            currentMax = Math.max(array.get(i), currentMax + array.get(i));
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    @Override
    public List<Integer> getMaxSubarray() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Array is empty. Please initialize it first.");
        }

        int maxSoFar = array.get(0);
        int currentMax = array.get(0);
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > currentMax + array.get(i)) {
                currentMax = array.get(i);
                tempStart = i;
            } else {
                currentMax += array.get(i);
            }

            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        return new ArrayList<>(array.subList(start, end + 1));
    }

    @Override
    public void clear() {
        array.clear();
    }
}
