package by.demeshko.shape.service;

import by.demeshko.shape.entity.Ball;

public interface Service {

    public Double findBallSize(Ball ball);

    public Double findBallSurfaceArea(Ball ball);



    public boolean touchCoordinatePlane();

    public double findVolumeRatio();
}
