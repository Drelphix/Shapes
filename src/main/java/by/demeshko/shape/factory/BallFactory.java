package by.demeshko.shape.factory;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Point;
import by.demeshko.shape.exception.BallException;

public class BallFactory extends ShapeFactory {
    @Override
    public Ball create(int id, Point[] points) throws BallException {
        if (points.length != 2) {
            throw new BallException();
        }
        Point center = points[0];
        Point atCircle = points[1];
        return new Ball(id, center, atCircle);
    }
}
