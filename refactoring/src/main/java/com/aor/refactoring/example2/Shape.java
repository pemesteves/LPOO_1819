package com.aor.refactoring.example2;

public abstract class Shape {

    protected double x;
    protected double y;

    Shape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public abstract double getArea() throws Exception;
    public abstract double getPerimeter() throws Exception;

    public abstract void draw(GraphicFramework graphics);
}
