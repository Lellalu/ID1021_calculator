# ID1021_calculator ![Maven build status](https://github.com/Lellalu/ID1021_calculator/actions/workflows/maven.yml/badge.svg)

This is an assignemnt for the course ID1201, Algorithms and Data Structures, at KTH Royal Institute of Techonology. This assignment is about using stack to implement a calculator with reverse polish notation.

## How run

This is an example of how to compile and test this project.

```bash
mvn clean && mvn compile && mvn test
```

In main, we have implemented a benchmark between the static and dynamic stack, see [Main.java](https://github.com/Lellalu/ID1021_calculator/blob/main/src/main/java/se/kth/id1021/Main.java) for more details. To run this:

```bash
mvn compile exec:java -Dexec.args="10000 100000"
```

The first argument is the number of operations, and the second argument is the number of times we run the program. The benchmark will report the max, min and average runtime of both version of the stack.
