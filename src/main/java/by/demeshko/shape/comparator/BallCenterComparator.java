package by.demeshko.shape.comparator;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Point;

import java.util.Comparator;

public class BallCenterComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball ball1, Ball ball2) {
        Point centerBall1 = ball1.getCenter();
        Point centerBall2 = ball2.getCenter();
        int compareX = Double.compare(centerBall1.getX(), centerBall2.getX());
        int compareY = Double.compare(centerBall1.getY(), centerBall2.getY());
        int compareZ = Double.compare(centerBall1.getZ(), centerBall2.getZ());
        return compareX == 0 && compareY == 0 && compareZ == 0 ? 0 : -1;
    }
}
