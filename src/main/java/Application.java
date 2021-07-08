import by.demeshko.shape.comparator.BallVolumeComparator;
import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.BallParameter;
import by.demeshko.shape.entity.Point;
import by.demeshko.shape.entity.Warehouse;
import by.demeshko.shape.exception.BallException;
import by.demeshko.shape.factory.BallFactory;
import by.demeshko.shape.factory.PointFactory;
import by.demeshko.shape.observer.BallObserver;
import by.demeshko.shape.observer.impl.BallObserverImpl;
import by.demeshko.shape.parser.BallParser;
import by.demeshko.shape.parser.impl.BallParserImpl;
import by.demeshko.shape.reader.CustomFileReader;
import by.demeshko.shape.reader.impl.CustomFileReaderImpl;
import by.demeshko.shape.repository.BallRepository;
import by.demeshko.shape.repository.BallSpecification;
import by.demeshko.shape.repository.impl.BallIdSpecificationImpl;
import by.demeshko.shape.repository.impl.BallRepositoryImpl;
import by.demeshko.shape.service.BallService;
import by.demeshko.shape.service.impl.BallServiceImpl;
import by.demeshko.shape.util.ShapeIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws BallException {
        Logger logger = LogManager.getLogger();
        String filePath = "";
        CustomFileReader customFileReader = new CustomFileReaderImpl();
        BallParser ballParser = new BallParserImpl();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        BallObserver observer = new BallObserverImpl();
        BallService ballService = new BallServiceImpl();
        BallFactory ballFactory = new BallFactory();
        PointFactory pointFactory = new PointFactory();
        ShapeIdGenerator shapeIdGenerator = new ShapeIdGenerator();

        List<String> lines = customFileReader.readFile(filePath);
        List<double[]> ballPoints = ballParser.parseStringList(lines);
        List<Ball> balls = new ArrayList<>();
        for (double[] points : ballPoints) {
            int id = shapeIdGenerator.generateId();
            Point[] pointsList = pointFactory.createTwoPoints(points);
            balls.add(ballFactory.create(id, pointsList));
        }

        for (Ball value : balls) {
            double volume = ballService.calculateBallVolume(value);
            double radius = ballService.calculateRadius(value);
            double surfaceArea = ballService.calculateRadius(value);
            warehouse.set(value.getId(), new BallParameter(volume, surfaceArea, radius));
        }

        ballRepository.addAll(balls);
        logger.info("initial parameters");
        for (int i = 1; i <= ballRepository.size(); i++) {
            logger.info("Id: " + i + " " + warehouse.get(i).toString());
        }

        ballRepository.getAll().forEach(ball -> ball.attach(observer));

        for (int i = 0; i < ballRepository.size(); i++) {
            ballRepository.getBall(i).setAtCircle(new Point(i - 1.5, i, i + 2.5));
        }

        logger.info("recalculated parameters");
        for (int i = 1; i <= ballRepository.size(); i++) {
            logger.info("Id: " + i + " " + warehouse.get(i).toString());
        }

        BallSpecification ballSpecification = new BallIdSpecificationImpl(1);
        List<Ball> result = ballRepository.query(ballSpecification);
        result.forEach(logger::info);
        ballRepository.sort(new BallVolumeComparator());
        ballRepository.getAll().forEach(logger::info);

    }
}
