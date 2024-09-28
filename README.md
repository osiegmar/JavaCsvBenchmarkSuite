# Java CSV library benchmark suite

This benchmark project was created for the development of
[FastCSV](https://github.com/osiegmar/FastCSV).

The benchmarks were written with [JMH](http://openjdk.java.net/projects/code-tools/jmh/).

## Compile and execute tests

    ./gradlew jmh --no-daemon --console plain

## Results

| Library     | Read (rec/sec) | Write (rec/sec) | Dependencies | Size (KiB) |
|-------------|---------------:|----------------:|:------------:|-----------:|
| Commons CSV |      3,125,409 |         978,583 |     yes      |        923 |
| FastCSV     |      8,825,369 |      14,231,754 |      no      |         64 |
| Jackson CSV |      8,059,229 |      11,167,174 |     yes      |      2,389 |
| Java CSV    |      4,054,302 |       1,291,444 |      no      |         13 |
| Opencsv     |      2,472,749 |       3,482,780 |     yes      |      2,703 |
| Sfm+ASM     |     10,186,117 |       1,919,197 |     yes      |      1,536 |
| Sfm-ASM     |      6,807,150 |       1,919,197 |     yes      |      1,535 |
| Super CSV   |      1,763,976 |       2,644,599 |      no      |         96 |
| Univocity   |      6,312,389 |       7,434,734 |      no      |        437 |

### Library details

- Commons CSV 1.12.0
- FastCSV 3.3.1
- Jackson CSV 2.18.0
- Java CSV 2.0
- Opencsv 5.9
- Sfm (SimpleFlatMapper) 9.0.2 (w/ and w/o ASM bytecode manipulation)
- Super CSV 2.4.0
- Univocity 2.9.1

### Environment

- Apple M2
- macOS 15.0
- Java 21, OpenJDK 64-Bit Server VM Temurin-21.0.4+7 (build 21.0.4+7-LTS, mixed mode)
- JMH 1.37
