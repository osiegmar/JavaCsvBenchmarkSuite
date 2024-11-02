# Java CSV library benchmark suite

This benchmark project was created for the development of
[FastCSV](https://github.com/osiegmar/FastCSV).

The benchmarks were written with [JMH](http://openjdk.java.net/projects/code-tools/jmh/).

## Compile and execute tests

    ./gradlew jmh --no-daemon --console plain

## Results

| Library     | Read (rec/sec) | Write (rec/sec) | Dependencies | Size (KiB) |
|-------------|---------------:|----------------:|:------------:|-----------:|
| Commons CSV |      3,129,552 |       1,092,389 |     yes      |        923 |
| FastCSV     |      8,827,121 |      14,178,012 |      no      |         64 |
| Jackson CSV |      8,083,356 |      11,123,561 |     yes      |      2,389 |
| Java CSV    |      4,056,162 |       1,417,442 |      no      |         13 |
| Opencsv     |      2,467,768 |       3,315,426 |     yes      |      2,703 |
| picocsv     |      7,390,977 |      11,615,948 |      no      |         26 |
| Sfm+ASM     |      9,851,937 |       1,918,364 |     yes      |      1,536 |
| Sfm-ASM     |      6,601,141 |       1,918,364 |     yes      |      1,535 |
| Super CSV   |      1,731,093 |       2,666,085 |      no      |         96 |
| Univocity   |      6,255,817 |       7,542,102 |      no      |        437 |

### Library details

- Commons CSV 1.12.0
- FastCSV 3.3.1
- Jackson CSV 2.18.0
- Java CSV 2.0
- Opencsv 5.9
- picocsv 2.4.0
- Sfm (SimpleFlatMapper) 9.0.2 (w/ and w/o ASM bytecode manipulation)
- Super CSV 2.4.0
- Univocity 2.9.1

### Environment

- Apple M2
- macOS 15.1
- Java 21, OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode)
- JMH 1.37
