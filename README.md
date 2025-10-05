# Assignment 2: Kadane’s Algorithm

## Overview

Implementation of **Kadane’s Algorithm** for single-pass maximum subarray sum detection as part of **Pair 3: Linear Array Algorithms** assignment.

**Student B Implementation:** Kadane’s Algorithm  
**Partner Algorithm:** Boyer-Moore Majority Vote (Student A)

---

## Algorithm Description

Kadane’s Algorithm efficiently finds the **contiguous subarray with the largest sum** within a one-dimensional numeric array.  
It uses a dynamic programming approach with **O(n)** time complexity and **O(1)** space complexity, making it optimal for linear array problems.

### Approach:
1. **Dynamic Programming Core:**  
   Continuously compute running sums, resetting when a negative sum occurs.
2. **Single-Pass Traversal:**  
   Only one linear scan through the array is required.
3. **Optional Tracking:**  
   Start and end indices can be recorded to identify the subarray itself.

---

## Project Structure
<img width="622" height="665" alt="image" src="https://github.com/user-attachments/assets/35c626ff-897c-4ff3-89da-0ae02a94598f" />


---

## Complexity Analysis

### **Time Complexity**
| Case | Complexity | Explanation |
|------|-------------|-------------|
| Best | Θ(n) | Must check all elements at least once |
| Average | Θ(n) | Linear scan without nested loops |
| Worst | Θ(n) | Same as average — always one traversal |

### **Space Complexity**
| Resource | Complexity | Explanation |
|-----------|-------------|-------------|
| Auxiliary space | O(1) | Uses constant variables only |
| Input storage | O(n) | Dependent on array size, not algorithmic overhead |

---

## Optimizations Implemented

- **Early Reset Logic:** Immediately resets current sum when it goes below zero.
- **Index Tracking:** Records start/end indices for retrieving the actual subarray.
- **Efficient Memory Use:** Avoids auxiliary data structures.
- **Metrics Integration:** Counts comparisons and assignments for empirical analysis.
- **CSV Logging:** Automatically writes metrics to `metrics.csv` for visualization.

---

## Usage

### Quick Start
```
bash
# Compile the project
mvn compile

# Run all tests
mvn test

# Run benchmark with default sizes (1K, 10K, 100K)
java -cp target/classes cli.BenchmarkRunner

# Run benchmark for custom input size
java -cp target/classes cli.BenchmarkRunner 50000

# Run the interactive CLI demo
java -cp target/classes cli.CommandLineApp
```
Core Algorithm

Kadane’s Algorithm with both sum and subarray reconstruction.

Handles edge cases (empty arrays, all negatives, single element).

Dynamic metrics tracking integrated directly into algorithm logic.

Performance Analysis

Real-time metrics via Metrics and PerformanceTracker.

CSV logging for each execution.

Measurement of comparisons, assignments, and execution time.

Testing

20+ JUnit tests (unit + integration).

Edge case validation (all negatives, empty, uniform values).

Consistency check between iterative and subarray versions.

CLI & Benchmarking

Interactive CLI menu for easy execution.

Benchmark runner for fixed and custom array sizes.

Random input generation with configurable ranges.

Sample Benchmark Output
<img width="547" height="413" alt="image" src="https://github.com/user-attachments/assets/f4e29cdb-2aaa-4d9e-af3b-a19fbbefe7d1" />

Metrics example (metrics.csv):

<img width="591" height="208" alt="image" src="https://github.com/user-attachments/assets/9791f697-8b42-41be-b803-c9c82835cd65" />


Git Workflow
Feature branch strategy followed for clean project evolution.
<img width="401" height="345" alt="image" src="https://github.com/user-attachments/assets/4fccd7b4-53ce-4b2c-abd8-1493e126b21a" />
Author
Pair 3 – Student B
Course: Design and Analysis of Algorithms
Assignment 2: Algorithmic Analysis and Peer Code Review
```
