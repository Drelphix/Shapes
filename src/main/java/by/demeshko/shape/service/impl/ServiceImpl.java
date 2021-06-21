package by.demeshko.shape.service.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.service.Service;

public class ServiceImpl implements Service {

    @Override
    public Double findBallVolume(Ball ball) {
        return 4/3 * Math.PI * Math.pow(ball.getRadius(),3);
    }

    @Override
    public Double findBallSurfaceArea(Ball ball) {
        return 4 * Math.PI * Math.pow(ball.getRadius(),2);
    }

    @Override
    public boolean isBall() {
        return false;
    }

    @Override
    public boolean touchCoordinatePlane() {
        return false;
    }

    @Override
    public double findVolumeRatio() {
        return 0;
    }

}
