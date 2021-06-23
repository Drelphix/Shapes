package by.demeshko.shape.repository;

import by.demeshko.shape.entity.Ball;

public interface BallRepository {

    public boolean addBall(Ball ball);

    public boolean removeBall(Ball ball);

    public Ball getBall(int index);

    public Ball setBall(int index,Ball ball);

    public int size();
}
