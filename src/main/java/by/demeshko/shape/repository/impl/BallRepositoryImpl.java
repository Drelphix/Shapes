package by.demeshko.shape.repository.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.repository.BallRepository;
import by.demeshko.shape.repository.BallSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BallRepositoryImpl implements BallRepository {
    private final List<Ball> balls = new ArrayList<>();

    @Override
    public boolean addBall(Ball ball) {
        return balls.add(ball);
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

    @Override
    public List<Ball> query(BallSpecification specification) {
        return balls.stream().filter(specification::specify).collect(Collectors.toList());
    }

    @Override
    public void sort(Comparator<? super Ball> comparator) {
        balls.sort(comparator);
    }


}
