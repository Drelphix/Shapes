package by.demeshko.shape.service;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Point;

import java.util.List;

public interface Service {

    public Double findBallSize(Ball ball);

    public Double findBallSurfaceArea(Ball ball);

    public boolean isBall(Object o);

    public boolean touchCoordinatePlane(Ball ball);

    public double findVolumeRatio();

    public Point findFarthestPoint(List<Point> points);
}
