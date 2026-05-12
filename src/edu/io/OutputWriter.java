package edu.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Writes the computed course order to a text file.
 */
public class OutputWriter {
    public void write(Path outputPath, List<String> lines) throws IOException {
        if (outputPath.getParent() != null) {
            Files.createDirectories(outputPath.getParent());
        }
        Files.write(outputPath, lines);
    }
}
