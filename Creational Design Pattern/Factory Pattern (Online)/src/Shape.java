abstract class Shape {
    String name;
    abstract void printArea();
    abstract void printPerimeter();

    public void showShapeDetail() {
        System.out.println("Shape Name: " + name);
        printArea();
        printPerimeter();
    }
}

class Square extends Shape {
    long length;

    public Square(long length) {
        this.name = "Square";
        this.length = length;
    }

    @Override
    void printArea() {
        System.out.println("The area of the square is: " + this.length * this.length);
    }

    @Override
    void printPerimeter() {
        System.out.println("The perimeter of the square is: " + this.length * 4);
    }
}

class Circle extends Shape {
    long radius;

    public Circle(long radius) {
        this.name = "Circle";
        this.radius = radius;
    }

    @Override
    void printArea() {
        System.out.println("The area of the circle is: " + 3.1416 * this.radius * this.radius);
    }

    @Override
    void printPerimeter() {
        System.out.println("The perimeter of the square is: " + 2 * 3.1416 * this.radius);
    }
}


class Rectangle extends Shape {
    long length;
    long width;

    public Rectangle(long length, long width) {
        this.name = "Rectangle";
        this.length = length;
        this.width = width;
    }

    @Override
    void printArea() {
        System.out.println("The area of the rectangle is: " + this.length * this.width);
    }

    @Override
    void printPerimeter() {
        System.out.println("The perimeter of the rectangle is: " + 2 * (this.length + this.width));
    }
}
