package by.demeshko.shape.observer;

public interface BallObservable {
    void attach(BallObserver observer);

    void detach();

    void notifyObservers();
}
