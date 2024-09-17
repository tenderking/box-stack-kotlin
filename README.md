# Box Stacking Optimization in Kotlin

## Project Overview

While playing with my kid and stacking boxes, I wanted to figure out if there was an optimal way of stacking three towers with 10 boxes to make them as equal in height as possible. I measured each box's height and decided to try solving this problem using a new programming language, Kotlin.

## Box Heights

Here are the heights of the boxes:

```kotlin
val boxValues: Map<String, Double> = mapOf(
    "box1" to 4.0,
    "box2" to 4.9,
    "box3" to 6.0,
    "box4" to 7.2,
    "box5" to 8.3,
    "box6" to 9.5,
    "box7" to 10.5,
    "box8" to 11.3,
    "box9" to 12.5,
    "box10" to 13.6
)
```

## Results

The algorithm found several valid combinations of box stacks that are as equal in height as possible. Here are some of the results:

- Valid combinations: ([28.0, 29.1, 30.7], [[9, 6, 3], [10, 5, 4], [8, 7, 2, 1]])
- Valid combinations: ([28.1, 28.7, 31.0], [[10, 7, 1], [9, 8, 2], [6, 5, 4, 3]])
- Valid combinations: ([28.1, 29.1, 30.6], [[10, 7, 1], [8, 6, 5], [9, 4, 3, 2]])
- Valid combinations: ([28.1, 29.2, 30.5], [[10, 7, 1], [9, 6, 4], [8, 5, 3, 2]])
- Valid combinations: ([28.1, 29.4, 30.3], [[10, 7, 1], [8, 4, 3, 2], [9, 6, 5]])
- Valid combinations: ([28.1, 29.8, 29.9], [[10, 7, 1], [9, 8, 3], [6, 5, 4, 2]])
- Valid combinations: ([28.3, 28.5, 31.0], [[7, 6, 5], [10, 3, 2, 1], [9, 8, 4]])
- Valid combinations: ([28.3, 28.6, 30.9], [[7, 6, 5], [9, 4, 2, 1], [10, 8, 3]])
- Valid combinations: ([28.3, 28.7, 30.8], [[7, 6, 5], [9, 8, 2], [10, 4, 3, 1]])
- Valid combinations: ([28.3, 28.9, 30.6], [[7, 6, 5], [10, 8, 1], [9, 4, 3, 2]])
- Valid combinations: ([28.3, 29.4, 30.1], [[7, 6, 5], [8, 4, 3, 2], [10, 9, 1]])
- Valid combinations: ([28.3, 29.7, 29.8], [[7, 6, 5], [10, 4, 2, 1], [9, 8, 3]])
- Valid combinations: ([28.5, 29.0, 30.3], [[10, 3, 2, 1], [8, 7, 4], [9, 6, 5]])
- Valid combinations: ([28.5, 29.1, 30.2], [[10, 3, 2, 1], [8, 6, 5], [9, 7, 4]])
- Valid combinations: ([28.5, 29.2, 30.1], [[10, 3, 2, 1], [9, 6, 4], [8, 7, 5]])
- Valid combinations: ([28.6, 29.1, 30.1], [[9, 4, 2, 1], [10, 6, 3], [8, 7, 5]])
- Valid combinations: ([28.6, 28.9, 30.3], [[7, 4, 3, 2], [10, 8, 1], [9, 6, 5]])
- Valid combinations: ([28.7, 28.8, 30.3], [[9, 8, 2], [7, 5, 3, 1], [10, 6, 4]])
- Valid combinations: ([28.7, 29.0, 30.1], [[9, 8, 2], [6, 5, 4, 1], [10, 7, 3]])
- Valid combinations: ([28.7, 29.1, 30.0], [[9, 8, 2], [10, 6, 3], [7, 5, 4, 1]])
- Valid combinations: ([28.7, 28.9, 30.2], [[6, 5, 3, 2], [10, 8, 1], [9, 7, 4]])
- Valid combinations: ([28.8, 29.2, 29.8], [[7, 5, 3, 1], [9, 6, 4], [10, 8, 2]])
- Valid combinations: ([28.9, 29.0, 29.9], [[10, 8, 1], [9, 7, 3], [6, 5, 4, 2]])
- Valid combinations: ([28.9, 29.2, 29.7], [[10, 8, 1], [9, 6, 4], [7, 5, 3, 2]])
- Valid combinations: ([28.9, 29.1, 29.8], [[7, 6, 2, 1], [10, 5, 4], [9, 8, 3]])
- Valid combinations: ([29.0, 29.0, 29.8], [[10, 7, 2], [6, 5, 4, 1], [9, 8, 3]])
- Valid combinations: ([29.0, 29.1, 29.7], [[10, 7, 2], [8, 6, 5], [9, 4, 3, 1]])
- Valid combinations: ([29.0, 29.2, 29.6], [[10, 7, 2], [9, 6, 4], [8, 5, 3, 1]])

## How to Run

1. **Clone the Repository**:
   ```sh
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Open the Project**:
   - Open the project in your preferred IDE (e.g., IntelliJ IDEA).
   - I assume you have JDK installed, and kotlinc

3. **Run the Code**:
   - Execute the main function to see the results.
   - `kotlinc Main.kt -include-runtime -d Main.jar`
   - `java -jar Main.jar`

## Conclusion

This project demonstrates how to use Kotlin to solve a practical problem of optimizing box stacking. The algorithm finds combinations of box stacks that are as equal in height as possible, providing a fun and educational way to explore Kotlin's capabilities.

