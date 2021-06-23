package by.demeshko.shape.entity;

public class Ball extends Shape {
    private Point center;
    private Point atCircle;
    private double radius;

    public Ball(){}

    public Ball(int id,Point center, double radius) {
        this.center = center;
        this.radius = radius;
        this.setId(id);
    }

    public Ball(int id, Point center, Point atCircle){
       this.setId(id);
        this.center = center;
        this.atCircle = atCircle;
        this.radius = Math.abs(Math.sqrt ( Math.pow(atCircle.getX() - center.getX(),2))
                +Math.pow(atCircle.getY() - center.getY(),2)
                +Math.pow(atCircle.getZ() - center.getZ(),2));
    }

    public Point getCenter() {
        return new Point(center.getX(),
                         center.getY(),
                         center.getZ());
    }

    public Point getAtCircle() {
        return atCircle;
    }

    public void setAtCircle(Point atCircle) {
        this.atCircle = atCircle;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = new Point(center.getX(),
                                center.getY(),
                                center.getZ());
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return (Double.compare(ball.radius, radius) == 0) &&
                (center.equals(ball.center)) &&
                (this.getId() == ball.getId());
    }

    @Override
    public int hashCode() {
        int result = this.center.hashCode();
        result = 20 * result * (int) radius;
        result = 20 * result * this.getId();
        return result;
    }

    @Override
    public String toString() {
        return  this.center.toString()+
                ", radius: " + radius;
    }
}
