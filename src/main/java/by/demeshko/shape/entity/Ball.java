package by.demeshko.shape.entity;

public class Ball extends Shape {
    private Point center;
    private Point atCircle;


    public Ball(int id, Point center, Point atCircle) {
        this.setId(id);
        this.center = new Point(center.getX(), center.getY(), center.getZ());
        this.atCircle = new Point(atCircle.getX(), atCircle.getY(), atCircle.getZ());
    }

    public Point getCenter() {
        return new Point(center.getX(),
                center.getY(),
                center.getZ());
    }

    public void setCenter(Point center) {
        this.center = new Point(center.getX(),
                center.getY(),
                center.getZ());
    }

    public Point getAtCircle() {
        return new Point(this.atCircle.getX(),
                this.atCircle.getY(),
                this.atCircle.getZ());
    }

    public void setAtCircle(Point atCircle) {
        this.atCircle = new Point(atCircle.getX(),
                atCircle.getY(),
                atCircle.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return (center.equals(ball.center)) &&
                (this.getId() == ball.getId());
    }

    @Override
    public int hashCode() {
        int result = this.center.hashCode();
        result = 20 * result * this.getId();
        return result;
    }

    @Override
    public String toString() {
        return this.center.toString() +
                this.atCircle.toString();

    }
}
