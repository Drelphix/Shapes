package by.demeshko.shape.parser.impl;

import by.demeshko.shape.parser.BallParser;
import by.demeshko.shape.validator.BallValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallParserImpl implements BallParser {
    private static final String INPUT_STRING_SPLIT_REGEX = ",\\s|;\\s|;|\\s-\\s|\\s";
    private static final String NUMBER_VALIDATE_REGEX = "-?\\d{1,5}\\.?\\d{0,4}";

    @Override
    public List<double[]> parseStringList(List<String> lines) {
        List<double[]> figure = new ArrayList<>();
        double[] array;
        for(String line : lines){
            if(BallValidator.isCorrectLine(line, INPUT_STRING_SPLIT_REGEX, NUMBER_VALIDATE_REGEX)){
                array = Arrays.stream(line.split(INPUT_STRING_SPLIT_REGEX)).mapToDouble(Double::parseDouble).toArray();
                if(BallValidator.isBall(array)){
                    figure.add(array);
                }
            }
        }
        return figure;
    }
}
