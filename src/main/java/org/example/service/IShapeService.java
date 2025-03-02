package org.example.service;

import org.example.model.IShape;

import java.util.*;

public interface IShapeService {
    void addShape(IShape shape);
    String displayShape(String name);
    List<IShape> getAllShapes();
}
