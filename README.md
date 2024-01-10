# Java CSV library benchmark suite

This benchmark project was created for the development of
[FastCSV](https://github.com/osiegmar/FastCSV).

The benchmarks were written with [JMH](http://openjdk.java.net/projects/code-tools/jmh/).

## Compile and execute tests

    ./gradlew jmh --no-daemon --console plain

## Results

| Library     | Read (rec/sec) | Write (rec/sec) | Dependencies | Size (KiB) |
|-------------|---------------:|----------------:|:------------:|-----------:|
| Commons CSV |      1,110,249 |       5,040,360 |      no      |         53 |
| FastCSV     |      8,231,931 |      14,269,018 |      no      |         64 |
| Jackson CSV |      8,083,378 |      11,079,851 |     yes      |      2,340 |
| Java CSV    |      4,040,709 |       1,227,322 |      no      |         13 |
| Opencsv     |      2,392,392 |       3,200,551 |     yes      |      2,703 |
| Sfm+ASM     |     10,061,419 |       1,914,414 |     yes      |      1,498 |
| Sfm-ASM     |      7,771,892 |       1,914,414 |     yes      |      1,498 |
| Super CSV   |      1,697,153 |       3,137,439 |      no      |         96 |
| Univocity   |      6,376,460 |       7,469,044 |      no      |        437 |

### Library details

- Commons CSV 1.10.0
- FastCSV 3.0.0
- Jackson CSV 2.16.1
- Java CSV 2.0
- Opencsv 5.9
- Sfm (SimpleFlatMapper) 8.2.3 (w/ and w/o ASM bytecode manipulation)
- Super CSV 2.4.0
- Univocity 2.9.1

### Environment

- Apple M2
- macOS 14.2.1
- Java 21, OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode)
- JMH 1.37
