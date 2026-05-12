SDT 202 Homework 12 - Topological Sorting

Correct package structure:
hw12/edu/auk/app/CourseScheduler.java          -> package edu.auk.app;
hw12/edu/auk/algorithms/*.java                 -> package edu.auk.algorithms;
hw12/edu/auk/graph/*.java                      -> package edu.auk.graph;
hw12/edu/auk/io/*.java                         -> package edu.auk.io;

IMPORTANT FOR INTELLIJ IDEA:
1. Copy the whole hw12 folder into your project.
2. Right-click the hw12 folder.
3. Select Mark Directory As -> Sources Root.
4. Run edu.app.CourseScheduler.

Do not create folders named src.edu.auk or out.edu.auk.
The correct folder chain is edu/auk/app, edu/auk/algorithms, edu/auk/graph, edu/auk/io.

Input file:
hw12/input/courses.txt

Output file after running:
hw12/output/course_order.txt

You can also run from terminal inside the hw12 folder:
javac edu/auk/app/CourseScheduler.java
java edu.app.CourseScheduler
