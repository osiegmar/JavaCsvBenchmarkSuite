# Java CSV library benchmark suite

This benchmark project was created for the development of 
[FastCSV](https://github.com/osiegmar/FastCSV).

The benchmarks were written with [JMH](http://openjdk.java.net/projects/code-tools/jmh/).


## Compile and execute tests

    ./gradlew jmh --no-daemon --console plain

## Results

| Library          | Read (rec/sec) | Write (rec/sec) | Dependencies | Size (KiB) |
| ---------------- | --------------:| ---------------:|:------------:| ----------:|
| Commons CSV      | 1,128,102      | 3,354,703       | no           | 50         |
| FastCSV          | 4,738,726      | 5,034,953       | no           | 31         |
| Jackson CSV      | 3,770,602      | 3,995,294       | yes          | 2,040      |
| Java CSV         | 1,922,189      | 2,732,843       | no           | 13         |
| Opencsv          | 1,085,935      | 1,808,982       | yes          | 2,625      |
| Sfm+ASM          | 5,164,967      | 1,901,154       | yes          | 1.498      |
| Sfm-ASM          | 4,652,517      | 1,901,154       | yes          | 1,498      |
| Super CSV        | 1,406,090      | 1,730,984       | no           | 96         |
| Univocity        | 3,594,900      | 4,050,255       | no           | 437        |

### Library details
- Commons CSV 1.9.0
- FastCSV 2.1.0
- Jackson CSV 2.13.0
- Java CSV 2.0
- Opencsv 5.5.2
- Sfm (SimpleFlatMapper) 8.2.3 (w/ and w/o ASM bytecode manipulation)
- Super CSV 2.4.0
- Univocity 2.9.1

### Environment
- Intel Core i7 @ 3.8 GHz clock speed with Turbo Boost disabled
- macOS 11.6
- Java 11, OpenJDK 64-Bit Server VM Temurin-11.0.12+7 (build 11.0.12+7, mixed mode)
- JMH 1.33
