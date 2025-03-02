package org.example.model;

public interface IShape {
    String getName();
    double calculateArea();
    double calculatePerimeter();

    class Square implements IShape {
        private double side;

        public String getName(){
            return "Square";
        }

        @Override
        public double calculateArea() {
            return Math.pow(side, 2);
        }

        @Override
        public double calculatePerimeter() {
            return 4 * side;
        }
    }

    class Circle implements IShape {
        private double radius;

        @Override
        public String getName() {
            return "Circle";
        }

        @Override
        public double calculateArea() {
            return Math.PI * Math.pow(radius, 2);
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }
}
