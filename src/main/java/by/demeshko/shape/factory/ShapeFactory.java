package by.demeshko.shape.factory;

import by.demeshko.shape.entity.Point;
import by.demeshko.shape.entity.Shape;
import by.demeshko.shape.exception.BallException;

public abstract class ShapeFactory {

    public abstract Shape create(int id, Point... points) throws BallException;
}
