package org.example.repository;

import java.util.Map;

public interface IShapeRepository {
    void storeShape(String name, double length);
    Map<String, Double> findAllShapes();
    Double findShape(String name);
}
