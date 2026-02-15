import java.util.*;

/**
 * Represents a generic Vehicle in the management system.
 * This is an abstract class that provides a blueprint for specific vehicle types.
 * * Relationships:
 * - HAS-A Engine (Composition)
 * - HAS-A Driver (Aggregation/Association)
 */

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

    void assignDriver(Driver driver){
        this.assignedDriver = driver;
    }

    void unassignDriver(){
        this.assignedDriver = null;
    }

    void displayInfo(){
        System.out.println("ID: " + id +
                " | Plate: " + numberPlate +
                " | Brand: " + brand +
                " | Model: " + model +
                " | Year: " + regYear +
                " | Mileage: " + mileage +
                " | Driver: " + (assignedDriver != null ? assignedDriver.name : "None"));
    }

    }

/**
 * Represents a Car as a specific type of Vehicle in the management system.
 * This class extends Vehicle and adds car-specific attributes like seating
 * capacity and transmission type.
 *
 * Responsibilities:
 * - Defines the vehicle type as Car.
 * - Provides a fixed tax calculation for cars.
 * - Stores additional details such as number of seats and whether the car is automatic.
 *
 * Relationships:
 * - IS-A Vehicle (Inheritance)
 * - HAS-A Engine (via Vehicle)
 */

class Car extends Vehicle{
    int seats;
    boolean automatic;

    Car(int id, String numberPlate, String brand, String model,
        String regYear, String mileage, Engine engine,
        int seats, boolean automatic) {
        super(id, numberPlate, brand, model, regYear, mileage, engine);
        this.seats = seats;
        this.automatic = automatic;
    }

    @Override
    void vehicleType() {
        System.out.println("Car");
    }

    @Override
    double calculateTax() {
        return 1000;
    }
}

/**
 * Represents a Bike as a specific type of Vehicle in the management system.
 * This class extends Vehicle and includes bike-specific information such as engine capacity.
 *
 * Responsibilities:
 * - Defines the vehicle type as Bike.
 * - Provides a fixed tax calculation for bikes.
 * - Stores engine capacity in CC for classification purposes.
 *
 * Relationships:
 * - IS-A Vehicle (Inheritance)
 * - HAS-A Engine (via Vehicle)
 */

class Bike extends Vehicle{
    int engineCC;

    Bike(int id, String numberPlate, String brand, String model,
         String regYear, String mileage, Engine engine,
         int engineCC) {
        super(id, numberPlate, brand, model, regYear, mileage, engine);
        this.engineCC = engineCC;
    }

    @Override
    void vehicleType() {
        System.out.println("Bike");
    }

    @Override
    double calculateTax() {
        return 500;
    }
}

/**
 * Represents a Truck as a specific type of Vehicle in the management system.
 * This class extends Vehicle and includes truck-specific details such as load capacity.
 *
 * Responsibilities:
 * - Defines the vehicle type as Truck.
 * - Provides a fixed tax calculation for trucks.
 * - Stores load capacity in tons for operational classification.
 *
 * Relationships:
 * - IS-A Vehicle (Inheritance)
 * - HAS-A Engine (via Vehicle)
 */

class Truck extends Vehicle{
    int loadCapacityTons;

    Truck(int id, String numberPlate, String brand, String model,
          String regYear, String mileage, Engine engine,
          int loadCapacityTons) {
        super(id, numberPlate, brand, model, regYear, mileage, engine);
        this.loadCapacityTons = loadCapacityTons;
    }

    @Override
    void vehicleType() {
        System.out.println("Truck");
    }

    @Override
    double calculateTax() {
        return 2000;
    }
}

/**
 * Represents an Engine component used by a Vehicle in the management system.
 * This class stores essential engine details required for vehicle identification
 * and performance description.
 *
 * Responsibilities:
 * - Stores engine number for unique identification.
 * - Stores fuel type used by the engine.
 * - Stores horsepower rating of the engine.
 *
 * Relationships:
 * - Part of Vehicle (Composition — Vehicle HAS-A Engine)
 */

class Engine{
    String engineNo;
    String fuelType;
    int horsepower;

    Engine(String engineNo, String fuelType, int horsepower){
        this.engineNo = engineNo;
        this.fuelType = fuelType;
        this.horsepower = horsepower;
    }
}

class Driver{
    int driverId;
    String name;
    String licenseNumber;
    String phone;
    String role;

    Driver(int driverId, String name, String licenseNumber, String phone, String role){
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.role = role;
    }

}

class VehicleService{
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    Vehicle findVehicle(int id){
        for(Vehicle v : vehicles){
            if(v.id == id){
                return v;
            }
        }
        return null;
    }

    void displayAllVehicles(){
        for(Vehicle v : vehicles){
            v.vehicleType();
            v.displayInfo();
            System.out.println("Tax: " + v.calculateTax());
            System.out.println("--------------------------------");
        }
    }

}

class VMSManager{
    VehicleService vehicleService = new VehicleService();
    Scanner sc = new Scanner(System.in);

    void start(){
        while(true){
            System.out.println("\n1. Add Car");
            System.out.println("2. Add Bike");
            System.out.println("3. Add Truck");
            System.out.println("4. View Vehicles");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) break;
            if(choice == 1) addCar();
            else if(choice == 2) addBike();
            else if(choice == 3) addTruck();
            else if(choice == 4) vehicleService.displayAllVehicles();
        }
    }

    void addCar(){
        Engine e = new Engine("E" + System.currentTimeMillis(), "Petrol", 120);
        Vehicle c = new Car(1, "ABC-123", "Toyota", "Corolla", "2022", "15000", e, 5, true);
        vehicleService.addVehicle(c);
    }

    void addBike(){
        Engine e = new Engine("E" + System.currentTimeMillis(), "Petrol", 150);
        Vehicle b = new Bike(2, "XYZ-789", "Honda", "CD70", "2021", "8000", e, 70);
        vehicleService.addVehicle(b);
    }

    void addTruck(){
        Engine e = new Engine("E" + System.currentTimeMillis(), "Diesel", 400);
        Vehicle t = new Truck(3, "TRK-456", "Hino", "500", "2020", "50000", e, 10);
        vehicleService.addVehicle(t);
    }

}

class VMS{
    public static void main(String[] args) {
        VMSManager manager = new VMSManager();
        manager.start();
    }
}