package by.demeshko.shape.validator;


import by.demeshko.shape.entity.Ball;

public class BallValidator {

    public static boolean isBall(Object o) {
        Ball ball = new Ball();
        if (ball == o) {
            return true;
        }
        if ((o == null) || (ball.getClass() != o.getClass())) {
            return false;
        }
        ball = (Ball) o;
        return !ball.getCenter().equals(ball.getAtCircle());
    }

    public static boolean isBall(double[] params) {
        if (params.length != 6) {
            return false;
        }
        return params[0] != params[3] ||
                params[1] != params[4] ||
                params[2] != params[5];
    }
}
