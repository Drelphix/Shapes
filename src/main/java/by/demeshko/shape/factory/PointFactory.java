package by.demeshko.shape.factory;

import by.demeshko.shape.entity.Point;
import by.demeshko.shape.exception.BallException;

public class PointFactory {

    public Point create(double... params) throws BallException {
        if (params.length != 3) {
            throw new BallException();
        }
        return new Point(params[0], params[1], params[2]);
    }
}
