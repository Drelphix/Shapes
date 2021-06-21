package by.demeshko.shape.entity;

public class Ball {
    private double centerX;
    private double centerY;
    private double centerZ;
    private double radius;

    public Ball(double centerX, double centerY, double centerZ, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getCenterZ() {
        return centerZ;
    }

    public void setCenterZ(double centerZ) {
        this.centerZ = centerZ;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.centerX, centerX) == 0 && Double.compare(ball.centerY, centerY) == 0 && Double.compare(ball.centerZ, centerZ) == 0 && Double.compare(ball.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = 40;
        result = 20 * result * (int) centerX;
        result = 20 * result * (int) centerY;
        result = 20 * result * (int) centerZ;
        result = 20 * result * (int) radius;
        return result;
    }

    @Override
    public String toString() {
        return "centerX: " + centerX +
                ", centerY: " + centerY +
                ", centerZ: " + centerZ +
                ", radius: " + radius;
    }
}
