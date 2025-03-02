package org.example.repository;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ShapeRepository implements IShapeRepository {
    private final Map<String, Double> shapes = new HashMap<>();

    public ShapeRepository() {
        System.out.println("Eager Bean: Repository");
    }

    @Override
    public void storeShape(String name, double length) {
        shapes.put(name, length);
    }

    @Override
    public Map<String, Double> findAllShapes() {
        return new HashMap<>(shapes);
    }

    @Override
    public Double findShape(String name) {
        return shapes.get(name);
    }
}
