package by.demeshko.shape.factory.impl;

import by.demeshko.shape.entity.Ball;
import by.demeshko.shape.entity.Point;
import by.demeshko.shape.factory.ShapeFactory;
import by.demeshko.shape.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BallFactory extends ShapeFactory {
     @Override
    public Ball create(int id, double ... params) {
         if(params.length == 4){
             Point point = new Point(params[0], params[1], params[2]);
             double radius = params[3];
             return new Ball(id, point, radius);
         }
         List<Point> points = new ArrayList<>();
         for (int i = 0; i < params.length; i = i + 3) {
             points.add(new Point(i, i+1, i+2));
         }
         Point center = points.get(0);
         Point atCircle = new ServiceImpl().findFarthestPoint(points);
         return new Ball(id, center, atCircle);
    }
}
