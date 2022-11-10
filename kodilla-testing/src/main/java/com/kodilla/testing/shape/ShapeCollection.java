package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollection {

    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public void showFigures() {
        for (Shape s : shapes) {
            System.out.println(s.getShapeName());
        }
    }

    public int getSize(){
        return shapes.size();
    }
}
