package com.example.Test.TestingPatterns.Reflection;

public class ReflectionExercise4 {
    public static void main(String[] args) {
        Shape shape = new SimpleShape(5);

        shape = new BorderDecorator(shape, 2);
        shape = new ColorDecorator(shape, "Red");
        //shape = colordecorator(borderdecorator(shape)));


        shape = removeDecoratorOfType(shape, BorderDecorator.class);
        //here we have unwrapped the color decorator
        System.out.println(BorderDecorator.class.isInstance(shape));
        System.out.println(ColorDecorator.class.isInstance(shape));

        System.out.println();

        shape = removeDecoratorOfType(shape, ColorDecorator.class);
        //here we have unwrapped the color decorator
        System.out.println(BorderDecorator.class.isInstance(shape));
        System.out.println(ColorDecorator.class.isInstance(shape));

    }

    private static Shape removeDecoratorOfType
            (Shape shape, Class<? extends ShapeDecorator> decoratorType) {
        //here it maybe better to have a getter to this.
        if(decoratorType.isInstance(shape)){
            return ((ShapeDecorator) shape).shape;
        }

        if(shape instanceof ShapeDecorator){
            ShapeDecorator decorator = (ShapeDecorator) shape;
            //recursion - finds the decorator type that needs
            //to be removed, and wraps everything again;
            decorator.shape = removeDecoratorOfType(decorator.shape, decoratorType);
            return decorator;
        } else{
            System.out.println("We have reached the actuall shape");
        }

        return shape;
    }
}

// Base interface
interface Shape {
    double getArea();
}

// Base class implementing the interface
class SimpleShape implements Shape {
    private double area;

    public SimpleShape(double area) {
        this.area = area;
    }

    @Override
    public double getArea() {
        return area;
    }
}

// Decorator base class
abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public double getArea() {
        return shape.getArea();
    }
}

// Concrete decorators
class BorderDecorator extends ShapeDecorator {
    private double borderWidth;

    public BorderDecorator(Shape shape, double borderWidth) {
        super(shape);
        this.borderWidth = borderWidth;
    }

    @Override
    public double getArea() {
        return shape.getArea() + 2 * borderWidth;
    }
}

class ColorDecorator extends ShapeDecorator {
    private String color;

    public ColorDecorator(Shape shape, String color) {
        super(shape);
        this.color = color;
    }

    // Area doesn't change with color
    @Override
    public double getArea() {
        return shape.getArea();
    }

    public String getColor() {
        return color;
    }
}

