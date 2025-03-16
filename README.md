# Java CSV library benchmark suite

This benchmark project was created for the development of
[FastCSV](https://github.com/osiegmar/FastCSV).

The benchmarks were written with [JMH](http://openjdk.java.net/projects/code-tools/jmh/).

## Compile and execute tests

    ./gradlew jmh --no-daemon --console plain

## Results

| Library     | Read (rec/sec) | Write (rec/sec) | Dependencies | Size (KiB) |
|-------------|---------------:|----------------:|:------------:|-----------:|
| Commons CSV |      4,097,424 |       5,693,450 |     yes      |        948 |
| FastCSV     |     12,877,797 |      21,731,217 |      no      |         79 |
| Jackson CSV |      7,534,704 |       9,513,726 |     yes      |      2,385 |
| Java CSV    |      5,003,265 |       1,002,049 |      no      |         13 |
| Opencsv     |      3,687,871 |       3,498,833 |     yes      |      2,767 |
| picocsv     |     16,209,628 |      18,032,443 |      no      |         23 |
| Sfm+ASM     |     13,968,934 |       3,350,064 |     yes      |      1,536 |
| Sfm-ASM     |     11,338,926 |       3,350,064 |     yes      |      1,536 |
| Super CSV   |      1,641,890 |       3,039,197 |      no      |         96 |
| Univocity   |      7,484,617 |      11,288,146 |      no      |        437 |

### Library details

- Commons CSV 1.13.0
- FastCSV 3.6.0
- Jackson CSV 2.18.3
- Java CSV 2.0
- Opencsv 5.10
- picocsv 2.5.1
- Sfm (SimpleFlatMapper) 9.0.2 (w/ and w/o ASM bytecode manipulation)
- Super CSV 2.4.0
- Univocity 2.9.1

### Environment

- Apple M4 Pro
- macOS 15.3.2
- OpenJDK 64-Bit Server VM Temurin-21.0.5+11 (build 21.0.5+11-LTS, mixed mode, sharing)
- JMH 1.37
