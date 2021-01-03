# Java CSV library benchmark suite

This benchmark project was created for the development of 
[FastCSV](https://github.com/osiegmar/FastCSV).

The benchmarks were written with [JMH](http://openjdk.java.net/projects/code-tools/jmh/).


## Compile and execute tests

    ./gradlew jmh --no-daemon --console plain

## Results

| Library     | Read (rec/sec) | Write (rec/sec) | Dependencies | Size (KiB) |
| ----------- | --------------:| ---------------:|:------------:| ----------:|
| Commons CSV | 362,066        | 1,426,715       | no           | 48         |
| FastCSV     | 3,473,108      | 4,039,801       | no           | 29         |
| Jackson CSV | 3,328,227      | 3,893,211       | yes          | 2,008      |
| Java CSV    | 1,356,228      | 1,154,646       | no           | 13         |
| Opencsv     | 510,106        | 1,409,792       | yes          | 2,599      |
| Sfm+ASM     | 4,783,786      | 376,320         | yes          | 1,498      |
| Sfm-ASM     | 3,653,393      | 376,320         | yes          | 1,498      |
| Super CSV   | 1,120,988      | 1,081,494       | no           | 96         |
| Univocity   | 2,299,671      | 2,420,152       | no           | 434        |

### Library details
- Commons CSV 1.8
- FastCSV 2.0.0
- Jackson CSV 2.12.0
- Java CSV 2.0
- Opencsv 5.3
- Sfm (SimpleFlatMapper) 8.2.3 (w/ and w/o ASM bytecode manipulation)
- Super CSV 2.4.0
- Univocity 2.9.0

### Environment
- Intel Core i7 @ 3.8 GHz clock speed with Turbo Boost disabled
- macOS 11.1
- JDK 1.8.0_275, OpenJDK 64-Bit Server VM (AdoptOpenJDK), 25.275-b01
