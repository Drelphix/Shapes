package by.demeshko.shape.repository;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.BallParameter;
import by.demeshko.shape.entity.Point;
import by.demeshko.shape.entity.Warehouse;
import by.demeshko.shape.repository.impl.*;
import by.demeshko.shape.service.BallService;
import by.demeshko.shape.service.impl.BallServiceImpl;
import by.demeshko.shape.util.ShapeIdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BallSpecificationTest {

    @BeforeAll
    static void init(){
        Warehouse warehouse = Warehouse.getInstance();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallService ballService = new BallServiceImpl();
        ShapeIdGenerator shapeIdGenerator = new ShapeIdGenerator();
        Ball ball1 = new Ball(shapeIdGenerator.generateId(), new Point(1.2, 14.4, 0), new Point(-15.2, 4, 5));
        Ball ball2 = new Ball(shapeIdGenerator.generateId(), new Point(3.1, -14.4, 8), new Point(-30.2, 1, 0));
        Ball ball3 = new Ball(shapeIdGenerator.generateId(), new Point(0, -1.4, 3), new Point(-1.2, 5, 4));

        ballRepository.addBall(ball1);
        ballRepository.addBall(ball2);
        ballRepository.addBall(ball3);

        double volume = ballService.calculateBallVolume(ball1);
        double surfaceArea = ballService.calculateBallSurfaceArea(ball1);
        double radius = ballService.calculateRadius(ball1);
        warehouse.set(ball1.getId(), new BallParameter(volume, surfaceArea, radius));

        volume = ballService.calculateBallVolume(ball2);
        surfaceArea = ballService.calculateBallSurfaceArea(ball2);
        radius = ballService.calculateRadius(ball2);
        warehouse.set(ball2.getId(), new BallParameter(volume, surfaceArea, radius));

        volume = ballService.calculateBallVolume(ball3);
        surfaceArea = ballService.calculateBallSurfaceArea(ball3);
        radius = ballService.calculateRadius(ball3);
        warehouse.set(ball3.getId(), new BallParameter(volume, surfaceArea, radius));
    }

    @Test
    void ballIdSpecificationSpecifyEqualTrue(){
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallSpecification ballIdSpecification = new  BallIdSpecificationImpl(2);
        boolean actual = ballIdSpecification.specify(ballRepository.getBall(1));
        Assertions.assertTrue(actual);
    }

    @Test
    void ballRadiusSpecificationSpecifyEqualFalse(){
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallSpecification ballSpecification = new BallRadiusSpecificationImpl(0,10);
        boolean actual = ballSpecification.specify(ballRepository.getBall(1));
        Assertions.assertFalse(actual);
    }

    @Test
    void ballRadiusSpecificationSpecifyEqualTrue(){
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallSpecification ballSpecification = new BallRadiusSpecificationImpl(5,8);
        boolean actual = ballSpecification.specify(ballRepository.getBall(2));
        Assertions.assertTrue(actual);
    }

    @Test
    void ballVolumeSpecificationEqualTrue(){
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallSpecification ballSpecification = new BallVolumeSpecificationImpl(850, 900);
        boolean actual = ballSpecification.specify(ballRepository.getBall(2));
        Assertions.assertTrue(actual);
    }

    @Test
    void ballVolumeSpecificationEqualFalse(){
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallSpecification ballSpecification = new BallVolumeSpecificationImpl(0,10000);
        boolean actual = ballSpecification.specify(ballRepository.getBall(1));
        Assertions.assertFalse(actual);
    }

    @Test
    void ballSurfaceAreaSpecificationEqualTrue(){
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallSpecification ballSpecification = new BallSurfaceAreaSpecificationImpl(1000000,1500000);
        boolean actual = ballSpecification.specify(ballRepository.getBall(0));
        Assertions.assertFalse(actual);
    }

    @Test
    void ballSurfaceAreaSpecificationEqualFalse(){
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallSpecification ballSpecification = new BallSurfaceAreaSpecificationImpl(10000,150000);
        boolean actual = ballSpecification.specify(ballRepository.getBall(2));
        Assertions.assertFalse(actual);
    }
}
