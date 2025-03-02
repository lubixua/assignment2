package org.example.repository;

import java.util.*;
import org.example.model.IShape;

public interface IShapeRepository {
    void storeShapes(IShape shape);
    List<IShape> findAllShapes();
    IShape findShape(String name);
}
