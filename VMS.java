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

class Driver{
    int driverId;
    String name;
    String licenseNumber;
    String phone;
    String role;
}