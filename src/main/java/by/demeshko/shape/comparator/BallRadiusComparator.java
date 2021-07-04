package by.demeshko.shape.comparator;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.BallParameter;
import by.demeshko.shape.entity.Warehouse;
import by.demeshko.shape.exception.BallException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class BallRadiusComparator implements Comparator<Ball> {
    private static final String NO_ID = "Can't get BallParameter with such id";
    Logger logger = LogManager.getLogger();

    @Override
    public int compare(Ball ball1, Ball ball2) {
        Warehouse warehouse = Warehouse.getInstance();
        try {
            BallParameter ballParameter1 = warehouse.get(ball1.getId());
            BallParameter ballParameter2 = warehouse.get(ball2.getId());
            double radiusBall1 = ballParameter1.getRadius();
            double radiusBall2 = ballParameter2.getRadius();
            return Double.compare(radiusBall1, radiusBall2);
        } catch (BallException e) {
            logger.error(NO_ID, e);
        }
        return -1;
    }
}