package org.example.repository;

import org.example.model.IShape;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ShapeRepository implements IShapeRepository {
    private final Map<String, IShape> shapes = new HashMap<>();

    @Override
    public void storeShapes(IShape shape) {
        shapes.put(shape.getName(), shape);
    }

    @Override
    public List<IShape> findAllShapes() {
        return new ArrayList<>(shapes.values());
    }

    @Override
    public IShape findShape(String name) {
        return shapes.get(name);
    }
}
