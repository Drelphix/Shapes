package by.demeshko.shape.repository;

import by.demeshko.shape.entity.Ball;

public interface BallRepository {

    boolean addBall(Ball ball);

    boolean removeBall(Ball ball);

    Ball getBall(int index);

    Ball setBall(int index, Ball ball);

    int size();
}
