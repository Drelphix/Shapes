package by.demeshko.shape.service;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Point;
import by.demeshko.shape.exception.BallException;

public interface BallService {

    Double calculateBallVolume(Ball ball);

    Double calculateBallSurfaceArea(Ball ball);

    boolean touchCoordinatePlane(Ball ball);

    double calculateVolumeRatio(Ball ball, Point[] points) throws BallException;

    double calculateRadius(Ball ball);

    public double calculateDistance(Point center, Point second);
}
