# Java CSV library benchmark suite

This benchmark project was created for the development of
[FastCSV](https://github.com/osiegmar/FastCSV).

The benchmarks were written with [JMH](http://openjdk.java.net/projects/code-tools/jmh/).

## Compile and execute tests

    ./gradlew jmh --no-daemon --console plain

## Results

| Library     | Read (rec/sec) | Write (rec/sec) | Dependencies | Size (KiB) |
|-------------|---------------:|----------------:|:------------:|-----------:|
| Commons CSV |      4,108,356 |       5,334,464 |     yes      |        948 |
| FastCSV     |     13,151,565 |      19,810,960 |      no      |         90 |
| Jackson CSV |      8,216,675 |       9,474,974 |     yes      |      2,385 |
| Java CSV    |      4,951,425 |       1,045,290 |      no      |         13 |
| Opencsv     |      3,378,021 |       4,146,190 |     yes      |      2,767 |
| picocsv     |     17,118,382 |      17,901,064 |      no      |         23 |
| Sfm+ASM     |     13,748,057 |       3,328,511 |     yes      |      1,536 |
| Sfm-ASM     |     10,834,683 |       3,328,511 |     yes      |      1,536 |
| Super CSV   |      1,774,133 |       3,579,853 |      no      |         96 |
| Univocity   |      7,436,480 |      11,052,394 |      no      |        437 |

## Results for multi-character field separator

| Library     | Read (rec/sec) |
|-------------|---------------:|
| FastCSV     |     11,122,528 |
| Univocity   |      6,482,301 |

### Library details

- Commons CSV 1.13.0
- FastCSV 4.0.0
- Jackson CSV 2.18.3
- Java CSV 2.0
- Opencsv 5.10
- picocsv 2.5.1
- Sfm (SimpleFlatMapper) 9.0.2 (w/ and w/o ASM bytecode manipulation)
- Super CSV 2.4.0
- Univocity 2.9.1

### Environment

- Apple M4 Pro
- macOS 15.5
- OpenJDK 64-Bit Server VM Temurin-21.0.7+6 (build 21.0.7+6-LTS, mixed mode, sharing)
- JMH 1.37
