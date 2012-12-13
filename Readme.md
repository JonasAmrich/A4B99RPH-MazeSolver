# Maze Solver

School project - simple maze solver written in Java.

Accepts two parameters, path to the maze bitmap and output filename (optional).

Solving larger mazes requires increasing JVM maximal memory, running with 512M is sufficient for the `grand1.bmp` maze.

Performance could be increased when running with parallel garbage collector (-XX:+UseParallelGC option).

Run command:

```
java -cp build/classes -Xmx512M -XX:+UseParallelGC maze.Maze data/grand.bmp
```

Grand1.bmp maze was created by Walter D. Pullen ([www.astrolog.org](http://www.astrolog.org/labyrnth/maze.htm))

&copy; 2012 Jonáš Amrich
