abstract class Vehicle{
    int id;
    String numberPlate;
    String brand;
    String model;
    String regYear;
    String mileage;
    Driver assignedDriver;
}

class Car extends Vehicle{
    int seats;
    boolean automatic;
}

class Bike extends Vehicle{
    int engineCC;
}

class Truck extends Vehicle{
    int loadCapacityTons;
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