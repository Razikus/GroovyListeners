/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.groovylisteners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author edge
 */
public class FileUtils {
    public static boolean createDirectoryIfNotExists(File directory) {
        return directory.mkdirs();
    }
    public static List<String> getAllFilesFromDirectory(File directory) throws IOException {
        List<String> filePaths = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(directory.toPath())) {
            paths
            .filter(Files::isRegularFile)
            .forEach((path) -> {
                filePaths.add(path.toString());
            });
        }
        return filePaths;
    }
}
