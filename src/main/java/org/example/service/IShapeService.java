package org.example.service;

import java.util.Map;

public interface IShapeService {
    void addShape(String name, double length);
    String displayShape(String name);
    Map<String, Double> getAllShapes();
}
