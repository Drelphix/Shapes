package by.demeshko.shape.observer;

import by.demeshko.shape.entity.Ball;

import java.util.EventObject;

public class BallEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public BallEvent(Ball source) {
        super(source);
    } //TODO 04.07.2021 23:58 :

    @Override
    public Ball getSource(){
        return (Ball) super.getSource();
    }
}