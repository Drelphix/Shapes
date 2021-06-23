package by.demeshko.shape.validator;


import by.demeshko.shape.entity.Point;

import java.util.Arrays;

public class BallValidator {

    public static boolean isCorrectLine(String line, String splitRegex, String doubleRegex){
        return Arrays.stream(line.split(splitRegex)).allMatch(i -> i.matches(doubleRegex));
    }

    public static boolean isBall(Point[] points){
        if(points.length < 2){
            return false;
        }
        for (int i = 0; i < points.length; i++) {
            if(!points[i].equals(points[i+1])){
                return true;
            }
        }
        return false;
    }

    public static boolean isBall(Double radius, Point[] points) {
        return (radius > 0) && points.length > 1;
    }

    public static boolean isBall(double[] points){
        if(points.length == 4) {
            return points[3] > 0;
        }
        return points.length % 3 == 0;
    }
}
