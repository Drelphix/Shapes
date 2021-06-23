package by.demeshko.shape.service.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Point;
import by.demeshko.shape.service.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    @Override
    public Double findBallSize(Ball ball) {
        return 4/3 * Math.PI * Math.pow(ball.getRadius(),3);
    }

    @Override
    public Double findBallSurfaceArea(Ball ball) {
        return 4 * Math.PI * Math.pow(ball.getRadius(),2);
    }

    @Override
    public boolean isBall(Object o) {
        Ball checkBall = new Ball();
        if (checkBall == o) {
            return true;
        }
        if ( (o == null) || (checkBall.getClass() != o.getClass()) ){
            return false;
        }
        checkBall = (Ball) o;
        return checkBall.getRadius() > 0 || findRadius(checkBall.getCenter(), checkBall.getAtCircle()) > 0;

    }

    @Override
    public boolean touchCoordinatePlane(Ball ball) {
        double radius = ball.getRadius();
        if(radius == 0){
            radius = findRadius(ball.getCenter(), ball.getAtCircle());
        }
        Point center = ball.getCenter();
        return Math.abs(center.getX()) - radius == 0 ||
                Math.abs(center.getY()) - radius == 0 ||
                Math.abs(center.getZ()) - radius == 0;
    }

    @Override
    public double findVolumeRatio() {
        return 0;
    }

    @Override
    public Point findFarthestPoint(List<Point> points) {
        Point center = points.get(0);
        Point maxAtCircle = points.get(1);
        for (int i = 2; i < points.size(); i++) {
            if(findRadius(center, maxAtCircle) < findRadius(center, points.get(i)) ){
                maxAtCircle = points.get(i);
            }
        }
        return maxAtCircle;
    }

    private double findRadius(Point center, Point atCircle){
        return Math.abs(Math.sqrt ( Math.pow(atCircle.getX() - center.getX(),2))
                +Math.pow(atCircle.getY() - center.getY(),2)
                +Math.pow(atCircle.getZ() - center.getZ(),2));
    }

}
