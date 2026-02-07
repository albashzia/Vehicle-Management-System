abstract class Vehicle{
    int id;
    String numberPlate;
    String brand;
    String model;
    String regYear;
    String mileage;
    Driver assignedDriver;              //HAS-A composition
    Engine engine;                      //HAS-A composition

    Vehicle(int id, String numberPlate, String brand, String model,
            String regYear, String mileage, Engine engine) {
        this.id = id;
        this.numberPlate = numberPlate;
        this.brand = brand;
        this.model = model;
        this.regYear = regYear;
        this.mileage = mileage;
        this.engine = engine;
    }

    abstract void vehicleType();
    abstract double calculateTax();
    }

class Car extends Vehicle{
    int seats;
    boolean automatic;

    @Override
    void vehicleType() {
        System.out.println("Car");
    }

    @Override
    double calculateTax() {
        return 1000;
    }
}

class Bike extends Vehicle{
    int engineCC;

    @Override
    void vehicleType() {
        System.out.println("Bike");
    }

    @Override
    double calculateTax() {
        return 500;
    }
}

class Truck extends Vehicle{
    int loadCapacityTons;

    @Override
    void vehicleType() {
        System.out.println("Truck");
    }

    @Override
    double calculateTax() {
        return 2000;
    }
}

class Engine{
    String engineNo;
    String fuelType;
    int horsepower;
}

class Driver{
    int driverId;
    String name;
    String licenseNumber;
    String phone;
    String role;
}

class VMS{
    public static void main(String[] args) {
        Car c1 = new Car();
        Bike b1 = new Bike();
        Truck t1 = new Truck();
        Driver d1 = new Driver();
    }
}