package by.demeshko.shape.repository;

import by.demeshko.shape.entity.Ball;

import java.util.Comparator;
import java.util.List;

public interface BallRepository {

    boolean addBall(Ball ball);

    boolean removeBall(Ball ball);

    Ball getBall(int index);

    Ball setBall(int index, Ball ball);

    int size();

    public List<Ball> getAll();

    public List<Ball> query(BallSpecification specification);

    public void sort(Comparator<? super Ball> comparator);

    public boolean addAll(List<Ball> list);
}
