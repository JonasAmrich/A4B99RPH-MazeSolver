# Maze Solver

School project - simple maze solver written in Java.

Accepts one parameter - path to the maze bitmap.

Start and finish positions can be set via `--start=x:y` and `--finish=x:y` arguments.

Solved maze can be saved as a bitmap or text file, depending on the `--out=Bitmap|Text` argument. File will be saved as original_name**.solved.png|txt**

Solving larger mazes requires increasing JVM maximal memory, running with 512M is sufficient for the `grand1.bmp` maze.

Performance can be increased by running with parallel garbage collector (`-XX:+UseParallelGC` option).

Sample run commands:

```
java -cp build/classes maze.Maze data/normal1.bmp --start=0:2 --finish=10:10 --out=Text
```

```
java -cp build/classes -Xmx512M -XX:+UseParallelGC maze.Maze data/grand1.bmp --out=Bitmap
```

Grand1.bmp maze was created by Walter D. Pullen ([www.astrolog.org](http://www.astrolog.org/labyrnth/maze.htm))

&copy; 2012 Jonáš Amrich
