# Maze Solver

School project - simple maze solver written in Java.

Accepts two parameters, path to the maze bitmap and output filename (optional).

Start and finish positions could be set via `--start=x:y` and `--finish=x:y` arguments.

Solving larger mazes requires increasing JVM maximal memory, running with 512M is sufficient for the `grand1.bmp` maze.

Performance could be increased when running with parallel garbage collector (-XX:+UseParallelGC option).

Run commands:

```
java -cp build/classes maze.Maze data/normal1.bmp --start=0:2 --finish=10:10
```

```
java -cp build/classes -Xmx512M -XX:+UseParallelGC maze.Maze data/grand1.bmp output.txt
```

Grand1.bmp maze was created by Walter D. Pullen ([www.astrolog.org](http://www.astrolog.org/labyrnth/maze.htm))

&copy; 2012 Jonáš Amrich
