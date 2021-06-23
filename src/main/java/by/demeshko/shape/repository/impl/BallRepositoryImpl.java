package by.demeshko.shape.repository.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.repository.BallRepository;

import java.util.ArrayList;
import java.util.List;

public class BallRepositoryImpl implements BallRepository {
    private List<Ball> balls = new ArrayList<>();

    @Override
    public boolean addBall(Ball ball) {
        return  balls.add(ball);
    }

    @Override
    public boolean removeBall(Ball ball) {
        return balls.remove(ball);
    }


    @Override
    public Ball getBall(int index) {
        return null;
    }

    @Override
    public Ball setBall(int index, Ball ball) {
        return null;
    }

    @Override
    public int size() {
        return balls.size();
    }
}
