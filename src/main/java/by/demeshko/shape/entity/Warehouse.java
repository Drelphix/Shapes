package by.demeshko.shape.entity;

import by.demeshko.shape.exception.BallException;

import java.util.*;

public class Warehouse {
    private final Map<Integer, BallParameter> parameters = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return Singleton.WAREHOUSE;
    }

    public BallParameter set(int id, BallParameter ballParameter) {
        return parameters.put(id, ballParameter);
    }

    public BallParameter get(int id) throws BallException {
        Optional<BallParameter> ballParameter = Optional.ofNullable(parameters.get(id));
        if (ballParameter.isEmpty()) {
            throw new BallException();
        }
        return ballParameter.get();
    }

    public boolean remove(int id) {
        Optional<BallParameter> ballParameter = Optional.ofNullable(parameters.remove(id));
        return ballParameter.isPresent();
    }

    private static class Singleton {
        private static final Warehouse WAREHOUSE = new Warehouse();
    }


}
