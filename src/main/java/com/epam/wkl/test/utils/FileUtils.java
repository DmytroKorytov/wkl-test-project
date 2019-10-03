package com.epam.wkl.test.utils;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
FileUtils .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
public final class FileUtils {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getJsonDataFromFile(String pathToFile) {
        try {
            return new String(Files.readAllBytes(Paths.get(pathToFile)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOG.error("Error in file parsing {}", e.getMessage());
        }
        return Strings.EMPTY;
    }

}