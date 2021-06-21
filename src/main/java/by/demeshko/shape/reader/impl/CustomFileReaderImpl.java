package by.demeshko.shape.reader.impl;

import by.demeshko.shape.exception.BallException;
import by.demeshko.shape.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final String TEST_BALL_FILE_PATH="./files/TestBall.txt";
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFile(String filePath) throws BallException {
        if(filePath.isEmpty()){
            filePath = TEST_BALL_FILE_PATH;
            logger.info("Path is empty. Using default filepath: " + TEST_BALL_FILE_PATH);
        }
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            logger.error(new StringBuilder().append("File ").
                    append(filePath).append(" not found!"));
            throw new BallException();
        }
    }
}
