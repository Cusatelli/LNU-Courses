##### ![](https://mymoodle.lnu.se/pluginfile.php/1/theme_essential/logo/1573077602/lnu-logo.png)
# 19HT - 1DV512 - Operating Systems - 7,5 hp

Assignment 2 Grading notes:

- Your implementation passes all of my tests with the exact expected values for average thinking and eating turn durations.

- The logs produced by your implementation in debug mode are also sufficient, albeit too extensive.

- However, the threads do not terminate properly in your implementation. For instance, when launching your implementation with simulationTime=3000 and seed=100 while disabling the debug mode, there is no output after the table is printed, but the program is never terminated (I had to kill it manually). If the debug mode is on, the output goes on indefinitely.

- This is a critical issue that I outlined previously in the public forum announcement, however, a minor modification (invoking executorService.shutdownNow() before the "finally" block in DiningPhilosopher.start()) fixes this issue, thus, I will still consider your solution to be deserving a pass grade.



### Disclaimer:
```
assignment_2 is INCOMPLETE & INCORRECTLY implemented.
Please do not refer to this assignment in any shape of form 
as it will most likely result in an incorrect implementation on the readers end.
```
