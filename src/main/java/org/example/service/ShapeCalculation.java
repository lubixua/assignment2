package org.example.service;

import org.example.model.IShape;
import org.example.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ShapeCalculation implements IShapeService {
    private final ShapeRepository shapeRepository;

    @Autowired
    public ShapeCalculation(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    @Override
    public void addShape(IShape shape) {
        shapeRepository.storeShapes(shape);
    }

    @Override
    public List<IShape> getAllShapes() {
        return shapeRepository.findAllShapes();
    }

    @Override
    public String displayShape(String name) {
        IShape shape = shapeRepository.findShape(name);
        if(shape == null){ return "Shape not found"; }
        return String.format("Name: %s\nArea: %f\nPerimeter: %f", name, shape.calculateArea(), shape.calculatePerimeter());
    }
}
