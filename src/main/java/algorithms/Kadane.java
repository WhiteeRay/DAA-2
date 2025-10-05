package algorithms;

import java.util.List;

public interface Kadane {
    void setArray(List<Integer> array);
    List<Integer> getArray();
    int findMaxSubarraySum();
    List<Integer> getMaxSubarray();
    void clear();
}
