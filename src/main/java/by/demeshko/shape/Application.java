package by.demeshko.shape;

import by.demeshko.shape.exception.BallException;
import by.demeshko.shape.parser.impl.BallParserImpl;
import by.demeshko.shape.reader.CustomFileReader;
import by.demeshko.shape.reader.impl.CustomFileReaderImpl;

public class Application {
    public static void main(String[] args) throws BallException {
        CustomFileReader fileReader = new CustomFileReaderImpl();
        System.out.println(new BallParserImpl().parseStringList(fileReader.readFile("")).size());
    }
}
