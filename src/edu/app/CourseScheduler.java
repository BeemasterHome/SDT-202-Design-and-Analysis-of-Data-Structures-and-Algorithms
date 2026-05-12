package edu.app;

import edu.algorithms.Topological;
import edu.graph.CourseGraph;
import edu.io.CourseInputReader;
import edu.io.OutputWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class: reads course prerequisites, builds a digraph, runs topological sort,
 * and writes a valid course-taking sequence to an output file.
 */
public class CourseScheduler {
    public static void main(String[] args) throws Exception {
        Path inputPath = args.length > 0 ? Path.of(args[0]) : findInputPath();
        Path outputPath = args.length > 1 ? Path.of(args[1]) : findOutputPath();

        CourseInputReader reader = new CourseInputReader();
        CourseGraph courseGraph = reader.read(inputPath);

        Topological topological = new Topological(courseGraph.graph());
        List<String> outputLines = new ArrayList<>();

        outputLines.add("Topological order for AUK Software Engineering courses");
        outputLines.add("Each prerequisite appears before the course that depends on it.");
        outputLines.add("");

        if (!topological.isDAG()) {
            outputLines.add("The graph has a directed cycle, so topological sorting is impossible.");
        } else {
            int position = 1;
            for (int courseId : topological.order()) {
                outputLines.add(position + ". " + courseGraph.courseName(courseId));
                position++;
            }
        }

        new OutputWriter().write(outputPath, outputLines);
        System.out.println("Done. Result was written to " + outputPath.toAbsolutePath());
    }

    private static Path findInputPath() {
        Path[] possiblePaths = {
                Path.of("input/courses.txt"),
                Path.of("hw12/input/courses.txt"),
                Path.of("src/hw12/input/courses.txt")
        };
        for (Path path : possiblePaths) {
            if (Files.exists(path)) {
                return path;
            }
        }
        return possiblePaths[0];
    }

    private static Path findOutputPath() {
        if (Files.exists(Path.of("src/hw12"))) {
            return Path.of("src/hw12/output/course_order.txt");
        }
        if (Files.exists(Path.of("hw12"))) {
            return Path.of("hw12/output/course_order.txt");
        }
        return Path.of("output/course_order.txt");
    }
}
