package org.example.service;

import java.util.Map;
import org.example.repository.IShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ShapeInfo implements IShapeService {
    private final IShapeRepository shapeRepository;

    @Autowired
    public ShapeInfo(IShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
        System.out.println("Eager Bean: Info");
    }

    @Override
    public void addShape(String name, double length) {
        shapeRepository.storeShape(name, length);
    }

    @Override
    public Map<String, Double> getAllShapes() {
        return shapeRepository.findAllShapes();
    }

    @Override
    public String displayShape(String name) {
        Double length = shapeRepository.findShape(name);
        if (length == null) {return "Shape not found";}
        return String.format("Shape name: %s\nLength: %f\n", name, length);
    }
}
