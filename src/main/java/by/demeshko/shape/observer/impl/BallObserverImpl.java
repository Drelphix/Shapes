package by.demeshko.shape.observer.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.BallParameter;
import by.demeshko.shape.entity.Warehouse;
import by.demeshko.shape.observer.BallEvent;
import by.demeshko.shape.observer.BallObserver;
import by.demeshko.shape.service.BallService;
import by.demeshko.shape.service.impl.BallServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallObserverImpl implements BallObserver {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void updateParameters(BallEvent ballEvent) {
        Warehouse warehouse = Warehouse.getInstance();
        BallService ballService = new BallServiceImpl();
        Ball ball = ballEvent.getSource();
        double volume = ballService.calculateBallVolume(ball);
        double surfaceArea = ballService.calculateBallSurfaceArea(ball);
        double radius = ballService.calculateRadius(ball);
        BallParameter ballParameter = new BallParameter(volume, surfaceArea, radius);
        warehouse.set(ball.getId(), ballParameter);
    }
}
