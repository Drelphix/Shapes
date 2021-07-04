package by.demeshko.shape.repository.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.BallParameter;
import by.demeshko.shape.entity.Warehouse;
import by.demeshko.shape.exception.BallException;
import by.demeshko.shape.repository.BallSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallVolumeSpecificationImpl implements BallSpecification {
    private static final String NO_ID = "Can't get BallParameter with such id";
    private final double fromVolume;
    private final double toVolume;
    Logger logger = LogManager.getLogger();

    public BallVolumeSpecificationImpl(double fromVolume, double toVolume) {
        this.fromVolume = fromVolume;
        this.toVolume = toVolume;
    }

    @Override
    public boolean specify(Ball ball) {
        Warehouse warehouse = Warehouse.getInstance();
        try {
            BallParameter ballParameter = warehouse.get(ball.getId());
            double area = ballParameter.getVolume();
            return (area >= fromVolume) && (area <= toVolume);
        } catch (BallException e) {
            logger.error(NO_ID, e);
        }
        return false;
    }
}
