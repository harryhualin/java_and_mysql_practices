package day3;

//abstract class Shape {
//    int x,y;
//    abstract void printArea(double x,double y);
//}
//class Rectangle extends Shape {
//
//    @Override
//    void printArea(double w,double h) {
//        System.out.println("Area of rectangle is :"+(w*h));
//    }
//}
//class Triangle extends Shape {
//
//    @Override
//    void printArea(double w, double h) {
//        System.out.println("Area of circle is :"+(3.14*x*x));
//    }
//}
//class Circle extends Shape {
//
//    @Override
//    void printArea(double w, double h) {
//        System.out.println("Area of triangle is :"+(0.5*x*y));
//    }
//}


public interface Shape {
    void printArea(double x,double y);
}
class Rectangle implements Shape {
    @Override
    public void printArea(double w, double h) {
        System.out.println("Area of rectangle is :"+(w*h));
    }
}
class Triangle implements Shape {
    @Override
    public void printArea(double r, double r2) {
        System.out.println("Area of circle is :"+(3.14*r*r));
    }
}
class Circle implements Shape {
    @Override
    public void printArea(double bottom, double height) {
        System.out.println("Area of triangle is :"+(0.5*bottom*height));
    }
}
class ShapeFactory {
    //use getShape method to get object of type shape
    public Shape getShape(String shapeType) {
        Shape shape = null;
        switch(shapeType.toUpperCase()){

            case "CIRCLE":
                shape = new Circle();
                break;

            case "RECTANGLE":
                shape = new Rectangle();
                break;

            case "TRIANGLE":
                shape = new Triangle();
                break;
        }
        return shape;
    }
}
