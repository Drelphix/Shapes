package by.demeshko.shape.reader;

import by.demeshko.shape.exception.BallException;
import by.demeshko.shape.reader.impl.CustomFileReaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class CustomFileReaderTest {

    @Test
    void readFile() throws BallException, IOException {
        CustomFileReader customFileReader = new CustomFileReaderImpl();
        String pathFile = "./files/TestBalls.txt";
        Path path = Paths.get(pathFile);
        List<String> strings =  customFileReader.readFile(pathFile);
        List<String> expected = Files.lines(path).collect(Collectors.toList());
        Assertions.assertEquals(expected, strings);

    }

}
