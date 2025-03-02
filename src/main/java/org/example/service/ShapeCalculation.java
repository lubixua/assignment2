package org.example.service;

import org.example.repository.IShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("FullInfo")
@Qualifier("FullInfo")
public class ShapeCalculation implements IShapeService {
    private final IShapeRepository shapeRepository;

    @Autowired
    public ShapeCalculation(IShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
        System.out.println("Eager Bean: Calculation");
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
        double area;
        double perimeter;

        Double length = shapeRepository.findShape(name);
        if (length == null) {return "Shape not found";}

        switch (name.toLowerCase()) {
            case "square":
                area = Math.pow(length, 2);
                perimeter = 4 * length;
                break;
            case "circle":
                area = Math.PI * Math.pow(length, 2);
                perimeter = 2 * Math.PI * length;
                break;
            default:
                return "Shape not found";
        }

        return String.format("Name: %s\nLength: %.2f\nArea: %.2f\nPerimeter: %.2f\n",
                name, length, area, perimeter);
    }
}
