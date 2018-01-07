test-concurrence
================

test concurrence with java (thread etc)

# Basics
## Threads
How to create and launch a Thread

## Synchronized key word
on method
on a bloc (with a resource as parameter)
But it cannot do anything (alternative solution is the lock)

# ExecutorService
It allows to manage a set of Threads

It accepts Runnables and Callables

| Benchmark                                                             | Mode  Cnt     Score      Error  Units  |
| --------------------------------------------------------------------- | -------------------------------------- |
| AnnotationEventBenchmarks.sendClassAnnotationEvents                   | thrpt   15  2608,569 ± 1143,076  ops/s |
| AnnotationEventBenchmarks.sendMethodAnnotationEvents_Selection_All    | thrpt   15  3278,225 ±  232,428  ops/s |
| AnnotationEventBenchmarks.sendMethodAnnotationEvents_Selection_Marked | thrpt   15  2695,198 ±  294,375  ops/s |
| Audit4jConsoleBenchmarks.sendEvents                                   | thrpt   15  5864,947 ±  974,146  ops/s |
| Audit4jFileBenchmarks.sendEvents                                      | thrpt   15  3483,119 ±  324,000  ops/s |
| Slf4jBenchmarks.slf4j                                                 | thrpt   15  6178,890 ± 1169,859  ops/s |
| AnnotationEventBenchmarks.sendClassAnnotationEvents_Runningtime       | avgt   15   322,272 ±  114,318  us/op  |
| Audit4jConsoleBenchmarks.sendEventsAvgTime                            | avgt   15   179,970 ±   20,152  us/op  |
| Audit4jFileBenchmarks.sendEventsAvgTime                               | avgt   15   290,120 ±   17,309  us/op  |
| Slf4jBenchmarks.sslf4jAvgTime                                         | avgt   15   184,155 ±   35,477  us/op  |

| method                                                                | results                                |
| --------------------------------------------------------------------- | -------------------------------------- |
| AnnotationEventBenchmarks.sendClassAnnotationEvents                   | thrpt   15  2196,358 ±  754,511  ops/s |
| AnnotationEventBenchmarks.sendMethodAnnotationEvents_Selection_All    | thrpt   15  2724,653 ±  561,884  ops/s |
| AnnotationEventBenchmarks.sendMethodAnnotationEvents_Selection_Marked | thrpt   15  2172,990 ±  907,932  ops/s |
| Audit4jConsoleBenchmarks.sendEvents                                   | thrpt   15  3765,242 ± 1200,823  ops/s |
| GeneralBenchmarks.sendEvents                                          | thrpt   15  2412,775 ±  677,576  ops/s |
| Slf4jBenchmarks.slf4j                                                 | thrpt   15  4503,311 ±  484,730  ops/s |
| AnnotationEventBenchmarks.sendClassAnnotationEvents_Runningtime       |  avgt   15   352,456 ±   85,810  us/op |
| Audit4jConsoleBenchmarks.sendEventsAvgTime                            |  avgt   15   212,040 ±   29,622  us/op |
| GeneralBenchmarks.sendEventsAvgTime                                   |  avgt   15   350,052 ±   56,742  us/op |
| Slf4jBenchmarks.sslf4jAvgTime                                         |  avgt   15   176,995 ±   54,869  us/op | 
