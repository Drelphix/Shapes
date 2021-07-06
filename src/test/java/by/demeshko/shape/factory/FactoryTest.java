package by.demeshko.shape.factory;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Point;
import by.demeshko.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactoryTest {

    @Test
    void PointFactoryCreateEqualsPoint() throws BallException {
        PointFactory pointFactory = new PointFactory();
        double[] array = new double[]{5, 2, 3};
        Point point = pointFactory.create(array);
        Point expected = new Point(5, 2, 3);
        Assertions.assertEquals(expected, point);
    }

    @Test
    void PointFactoryCreateNotEqualsPoint() throws BallException {
        PointFactory pointFactory = new PointFactory();
        double[] array = new double[]{5, 5, 3};
        Point point = pointFactory.create(array);
        Point expected = new Point(5, 2, 3);
        Assertions.assertNotEquals(expected, point);
    }

    @Test
    void PointFactoryCreateTwoPointsEqualsArray() throws BallException {
        PointFactory pointFactory = new PointFactory();
        Point[] points = pointFactory.createTwoPoints(new double[]{5, 5, 3, 4, 7, 2});
        Point[] expected = new Point[]{new Point(5, 5, 3), new Point(4, 7, 2)};
        Assertions.assertArrayEquals(expected, points);
    }

    @Test
    void BallFactoryCreateEqualsBall() throws BallException {
        BallFactory ballFactory = new BallFactory();
        PointFactory pointFactory = new PointFactory();
        Point[] points = pointFactory.createTwoPoints(new double[]{4, 12, 15, 0, 1, 4});
        Ball ball = ballFactory.create(0, points);
        Ball expected = new Ball(0, new Point(4, 12, 15), new Point(0, 1, 4));
        Assertions.assertEquals(expected, ball);
    }

}
