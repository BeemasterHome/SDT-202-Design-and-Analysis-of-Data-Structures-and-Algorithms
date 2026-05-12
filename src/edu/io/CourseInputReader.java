package edu.io;

import edu.graph.CourseGraph;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads course prerequisites from a text input file.
 */
public class CourseInputReader {
    public CourseGraph read(Path inputPath) throws IOException {
        List<String[]> edges = new ArrayList<>();
        List<String> standaloneCourses = new ArrayList<>();

        for (String rawLine : Files.readAllLines(inputPath)) {
            String line = rawLine.trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            if (line.contains("->")) {
                String[] parts = line.split("->", 2);
                String prerequisite = parts[0].trim();
                String course = parts[1].trim();
                edges.add(new String[]{prerequisite, course});
            } else {
                standaloneCourses.add(line);
            }
        }
        return new CourseGraph(edges, standaloneCourses);
    }
}
