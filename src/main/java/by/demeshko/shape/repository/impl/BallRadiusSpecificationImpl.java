package by.demeshko.shape.repository.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Warehouse;
import by.demeshko.shape.exception.BallException;
import by.demeshko.shape.repository.BallSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallRadiusSpecificationImpl implements BallSpecification {
    private final double from;
    private final double to;
    Logger logger = LogManager.getLogger();
    private static final String NO_ID = "Can't get BallParameter with such id";

    public BallRadiusSpecificationImpl(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ball ball) {
        Warehouse warehouse = Warehouse.getInstance();
        try {
            double radius = warehouse.get(ball.getId()).getRadius();
            return (radius >= from) && (radius <= to);
        } catch (BallException e) {
            logger.error(NO_ID, e);
        }
        return false;
    }
}
