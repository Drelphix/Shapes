package by.demeshko.shape.factory;

import by.demeshko.shape.entity.Shape;

public abstract class ShapeFactory {

    public abstract Shape create(int id, double... points);
}
