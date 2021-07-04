package by.demeshko.shape.util;

public class ShapeIdGenerator {
    private long id;

    public long generateId() {
        return ++id;
    }
}
