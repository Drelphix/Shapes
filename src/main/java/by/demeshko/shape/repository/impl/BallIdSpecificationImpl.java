package by.demeshko.shape.repository.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.repository.BallSpecification;

public class BallIdSpecificationImpl implements BallSpecification {
    private final int id;

    public BallIdSpecificationImpl(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Ball ball) {
        return ball.getId() == id;
    }
}
