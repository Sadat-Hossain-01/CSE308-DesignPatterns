import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String compName = "A";
        String shapeName = "Square";
        long paramA = 5;
        long paramB = 7;

        ComputerFactory computerFactory = new ComputerFactory();
        Computer comp = computerFactory.produceComputer(compName);

        comp.showComputerDetail();

        if (shapeName.equalsIgnoreCase("Circle") || shapeName.equalsIgnoreCase("Square")) {
            paramB = paramA;
        }

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = null;

        if (paramA <= comp.resA && paramB <= comp.resB) {
            shape = shapeFactory.produceShape(shapeName, paramA, paramB);
        }

        if (shape != null) {
            shape.showShapeDetail();
        }
        else System.out.println("Not possible to display shape in this computer");
    }
}
