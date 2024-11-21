import java.io.Serializable;

abstract class Shape implements Serializable {
    public abstract double calculateArea();
    public abstract String getDescription();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getDescription() {
        return "Circle radius " + radius;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getDescription() {
        return "Rectangle length " + length + " width " + width;
    }
}

class Sphere extends Shape {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public String getDescription() {
        return "Sphere  radius " + radius;
    }
}

class Cuboid extends Shape {
    private final double length;
    private final double width;
    private final double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 2 * (length * width + width * height + height * length); }

    @Override
    public String getDescription() {
        return "Cuboid  length " + length + ", width " + width + ",  height " + height;
    }
}
