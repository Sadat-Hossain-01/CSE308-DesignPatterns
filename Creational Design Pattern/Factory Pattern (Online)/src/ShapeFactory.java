public class ShapeFactory {
    public Shape produceShape(String type, long a, long b) {
        Shape shape = null;

        if (type.equalsIgnoreCase("Rectangle")) {
            shape = new Rectangle(a, b);
        }
        else if (type.equalsIgnoreCase("Square")) {
            shape = new Square(a);
        }
        else if (type.equalsIgnoreCase("Circle")) {
            shape = new Circle(a);
        }

        return shape;
    }
}
