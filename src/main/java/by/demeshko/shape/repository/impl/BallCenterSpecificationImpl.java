package by.demeshko.shape.repository.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.repository.BallSpecification;

public class BallCenterSpecificationImpl implements BallSpecification {
    private final double[] from;
    private final double[] to;

    public BallCenterSpecificationImpl(double[] from, double[] to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ball ball) {
        return false;
    } //TODO 04.07.2021 23:59 :
}
