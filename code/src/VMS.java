import java.util.*;

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
//        Car c1 = new Car();
//        Bike b1 = new Bike();
//        Truck t1 = new Truck();
        //Driver d1 = new Driver();
    }
}