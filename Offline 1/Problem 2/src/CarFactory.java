public class CarFactory {
    public Car produceCar(String continent) {
        Car car = null;

        if (continent.equalsIgnoreCase("Asia")) {
            car = new Toyota();
        } else if (continent.equalsIgnoreCase("United States")) {
            car = new Tesla();
        } else if (continent.equalsIgnoreCase("Europe")) {
            car = new BMW();
        }

        if (car != null) {
            car.setCarProperties();
        }

        return car;
    }
}
