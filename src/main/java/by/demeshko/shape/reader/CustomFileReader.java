package by.demeshko.shape.reader;

import by.demeshko.shape.exception.BallException;

import java.util.List;

public interface CustomFileReader {

    List<String> readFile(String file) throws BallException;
}
