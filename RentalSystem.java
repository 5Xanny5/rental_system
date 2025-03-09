import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Trieda {@code RentalSystem} predstavuje systém prenájmu vozidiel.
 * Umožňuje správu dostupných vozidiel, prenájom, vrátenie a sledovanie finančnej histórie.
 */
public class RentalSystem  {
    
    private List<Vehicle>Rental_agency_cars;
    private String nazov_rental_agency;
    private double financie;
    private List<Vehicle>Rentaled_cars;
    private List<Vehicle>Returned_cars;
    private List<RentStory> rentStory;
        /**
     * Vytvorí nový objekt {@code RentalSystem} s daným názvom agentúry.
     *
     * @param nazov_agencie Názov agentúry
     */
    public RentalSystem(String nazov_agencie){
        this.nazov_rental_agency = nazov_agencie;
        this.financie = 0;
        this.Rental_agency_cars = new ArrayList<>(); 
        this.Rentaled_cars = new ArrayList<>();  
        this.Returned_cars = new ArrayList<>();  
        this.rentStory = new ArrayList<RentStory>();
        
        
}
    
     /**
     * Overí, či je možné prenajať dané vozidlo.
     *
     * @param v Vozidlo na prenájom
     * @return {@code true}, ak je vozidlo dostupné na prenájom, inak {@code false}
     */
       public boolean canRent(Vehicle v) {
    for (int i = 0; i < rentStory.size(); i++) {
        if (v.equals(rentStory.get(i).getVehicle())) {
            if (rentStory.get(i).getStatus() == RentStatus.RENTED) {
                return false; // Vehicle is already rented

            }
        }
    }
    return true; // Vehicle is available for rent
}
    
    /**
     * Pridá vozidlo do vozového parku agentúry.
     *
     * @param v Vozidlo na pridanie
     */
    public void add_vehicle_to_agency(Vehicle v){
        Rental_agency_cars.add(v);
}

    /**
     * Nájde dostupné vozidlo podľa značky a modelu.
     *
     * @param brand Značka vozidla
     * @param model Model vozidla
     * @return Dostupné vozidlo alebo {@code null}, ak nie je k dispozícii
     */
    private Vehicle findAvailableVehicleByBrandAndModel(String brand, String model) {
    for (Vehicle vehicle : Rental_agency_cars) {
        if (!Rentaled_cars.contains(vehicle) && vehicle.getBrand().equals(brand) && vehicle.getModel().equals(model)) {
            return vehicle;
        }
    }
    return null; 
}

        /**
     * Zrealizuje prenájom vozidla zákazníkovi na základe zadaných parametrov.
     *
     * @param c            Zákazník
     * @param v            Vozidlo na prenájom
     * @param days_or_hour Špecifikácia prenájmu (dni/hodiny)
     * @param how_long      Dĺžka prenájmu
     */
    public void rent_vehicle(Customer c, Vehicle v, String days_or_hour, int how_long) {
    if (canRent(v)) {
        Rentaled_cars.add(v);
        rentStory.add(new RentStory(v, c, RentStatus.RENTED));
        c.getRentedVehicles().add(v);
        System.out.println("You have rented a vehicle");

        if (days_or_hour.equals("days")) {
            financie += v.calculateRentalCost(how_long);
            if (v instanceof ElectricVehicle){
                ElectricVehicle my_v =(ElectricVehicle)v;
                my_v.charge(0);
            }
            else if (v instanceof ElectricVehicle){
                FuelVehicle my_v =(FuelVehicle)v;
                my_v.refuel(0);

                }
        }
        else {
            financie += v.calculateShortRentalCost(how_long);
            if (v instanceof ElectricVehicle){
                ElectricVehicle my_v =(ElectricVehicle)v;
                my_v.charge(0);
                }
            else if (v instanceof ElectricVehicle){
                FuelVehicle my_v =(FuelVehicle)v;
                my_v.refuel(0);

                }
        }}
     else {
        System.out.println("Vehicle cannot be rented. It is already rented or invalid.");
    }
}
 /**
     * Vráti vozidlo agenture na základe zadaných parametrov.
     *
     * @param c Zákazník
     * @param v Vozidlo na vrátenie
     */
public void return_vehicle(Customer c, Vehicle v) {
    if (c != null && v != null) {
        int index = -1;
        for (int i = 0; i < rentStory.size(); i++) {
            RentStory rentRecord = rentStory.get(i);
            if (v.equals(rentRecord.getVehicle()) && c.equals(rentRecord.getCustomer()) && rentRecord.getStatus() == RentStatus.RENTED) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            rentStory.get(index).setStatus(RentStatus.RETURNED);
            System.out.println("You have successfully returned the vehicle");
            Rentaled_cars.remove(v);
            c.getRentedVehicles().remove(v);
            Returned_cars.add(v);
        } else {
            System.out.println("Vehicle cannot be returned. It was not rented by the customer.");
        }
    } else {
        System.out.println("Invalid customer or vehicle.");
    }
}
/**
     * Zobrazí históriu prenájmov.
     */
 public void displayRentalHistory() {
        System.out.println("Rental History:");
        for (RentStory rentRecord : rentStory) {
            System.out.println("Customer: " + rentRecord.getCustomer().getName());
            System.out.println("Vehicle: " + rentRecord.getVehicle().getBrand());
            System.out.println("Status: " + rentRecord.getStatus());
            System.out.println("---------------");
        }
}
/**
     * Získaj finančné prostriedky agentúry.
     *
     * @return Finančné prostriedky
     */
public double getFinances() {
    return financie;
}
/**
     * Opraví vozidlo, ak je potrebné a agentúra má dostatok finančných prostriedkov.
     *
     * @param v Vozidlo na opravu
     */
public void repairVehicle(Vehicle v) {
        if (v != null && Rentaled_cars.contains(v)) {
            double repairCost = v.calculateRepairCost(); 
            if (financie>=repairCost){
                financie -= repairCost;
                System.out.println("Vehicle " + v.getBrand() + " " + v.getModel() + " repaired. Repair cost: $" + repairCost);
            }
            else{
                System.out.println("Not enough money to repair,you have only:"+financie + ",and you need:"+repairCost);

            }
        } else {
            System.out.println("Invalid vehicle or vehicle is not currently rented.");
        }
    }
/**
 * Metóda na dobíjanie vozidla na elektrický pohon.
 *
 * @param v Vozidlo, ktoré sa má dobíjať.
 * @param percents Percentuálny stav, na ktorý sa má vozidlo dobíjať.
 */
public void chargeVehicle(Vehicle v, int percents) {
    if (v != null) {
        try {
            ElectricVehicle my_el_vehicle = (ElectricVehicle) v;
            if (my_el_vehicle.getBatteryPercentage() <= 100) {
                my_el_vehicle.charge(percents);
                System.out.println("The vehicle was charged to: " + percents + "%");
            }
        } catch (ClassCastException e) {
            System.out.println("Cannot charge the vehicle. It is not an electric vehicle.");
        }
    }
}
/**
 * Metóda na tankovanie paliva pre vozidlo s spaľovacím motorom.
 *
 * @param v Vozidlo, ktoré sa má natankovať.
 * @param litrov Množstvo litrov, ktoré sa má vozidlu natankovať.
 */
public void fuelCar(Vehicle v, int litrov) {
    if (v != null) {
        try {
            FuelVehicle my_fuel_vehicle = (FuelVehicle) v;
            if (my_fuel_vehicle.getFuelLevel() < 55) {
                my_fuel_vehicle.refuel(litrov);
                System.out.println("The vehicle was fueled to: " + litrov);
            } else {
                System.out.println("The car was already fueled.");
            }
        } catch (ClassCastException e) {
            System.out.println("Cannot fuel the vehicle. It is not a fuel vehicle.");
        }
    }
}
/**
 * Zobrazte dostupné vozidlá.
 */
public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle v : Rental_agency_cars) {
            if (!Rentaled_cars.contains(v)) {
                System.out.println("---------------");
                System.out.println("Brand: " + v.getBrand());
                System.out.println("Model: " + v.getModel());
                System.out.println("Year: " + v.getYear());
                System.out.println("Hourly Rental Rate: $" + v.getHourlyRentalRate());
                System.out.println("Daily Rental Rate: $" + v.getDailyRentalRate());
                if(v instanceof ElCar){
                    ElCar my_el_car = (ElCar)v;
                    System.out.println("Number of seats: " + my_el_car.getNumberOfSeats());
                    System.out.println("Baterie level: " + my_el_car.getBatteryPercentage() + "%");
                    System.out.println("Charging time: " + my_el_car.getChargingTime());
                }
                else if (v instanceof Car){
                    Car my_car = (Car)v;
                    System.out.println("Number of seats: " + my_car.getNumberOfSeats());
                    System.out.println("Fuel type: " + my_car.getFuelType());
                    System.out.println("Fuel level: " + my_car.getFuelLevel());
                }
                 else if(v instanceof Ebike){
                    Ebike my_ebike = (Ebike)v;
                    System.out.println("Baterie level: " + my_ebike.getBatteryPercentage());
                    System.out.println("Does it have light? " + my_ebike.hasLights());
                    System.out.println("Is it foldable? " + my_ebike.isFoldable());

                }
                else if(v instanceof Bike){
                    Bike my_bike = (Bike)v;
                    System.out.println("Number of gears: " + my_bike.getPocetPrevodov());
                    System.out.println("Does bike have basket?: " + my_bike.maKosik());
                }

                else if(v instanceof Scooter){
                    Scooter my_scooter = (Scooter)v;
                    System.out.println("Baterie level: " + my_scooter.getBatteryPercentage());
                }
                
                System.out.println("---------------");
            }
        }
    }
/**
 * Hlavná metóda programu.
 *
 * @param args  Argumenty príkazového riadka
 */
public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem("my_agency");        
        Scanner scanner = new Scanner(System.in);
        Car car1 = new Car("Audi", "R8", 2000, 7.7, 4, "benzin");
        Car car2 = new Car("BMW", "M5", 2022, 10.4, 8, "benzin");
        Bike bike1 =  new Bike("Continental", "S", 2018, 4.3, 3, "yes");
        Bike bike2 =  new Bike("Canyone", "Su", 2016, 4.9, 6, "no");
        Ebike ebike1 =  new Ebike("TeslaBike", "X", 2023, 6, 6, "no",100,"yes","yes");
        ElCar ecar1 = new ElCar("Tesla car", "Truck",2022, 10.4, 8,10,5,7);
        rentalSystem.add_vehicle_to_agency(car1);
        rentalSystem.add_vehicle_to_agency(car2);
        rentalSystem.add_vehicle_to_agency(bike1);
        rentalSystem.add_vehicle_to_agency(bike2);
        rentalSystem.add_vehicle_to_agency(ebike1);
        rentalSystem.add_vehicle_to_agency(ecar1);


        
        while (true) {
            System.out.println("---------------");
            System.out.println("===== Rental System Menu =====");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. Display Rental History");
            System.out.println("4. Display Finances");
            System.out.println("5. Repair a Vehicle");
            System.out.println("6. Display Available Vehicles");
            System.out.println("7. Charge vehicle");
            System.out.println("8. Fuel vehicle");
            System.out.println("9. Get vehicle rented by certain customer");
            System.out.println("10. Download the rent history of certain customer");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    rentalSystem.rentVehicle(scanner);
                    break;
                case 2:
                    rentalSystem.returnVehicle(scanner);
                    break;
                case 3:
                    rentalSystem.displayRentalHistory();
                    break;
                case 4:
                    System.out.println("Finances: $" + rentalSystem.getFinances());
                    break;
                case 5:
                    rentalSystem.repairVehicle(scanner);
                    break;
                case 6:
                    rentalSystem.displayAvailableVehicles();
                    break;
                case 7:
                    rentalSystem.chargeVehicle(scanner);
                    break;
                case 8:
                    rentalSystem.fuelCar(scanner);
                    break;
                case 9:
                    rentalSystem.displayVehiclesRentedByCustomer(scanner);
                    break;
                case 10:
                    rentalSystem.saveAvailableVehiclesToFile();
                    break;
                case 0:
                    System.out.println("---------------");
                    System.out.println("Exiting Rental System. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
/**
 * Prepožičajte vozidlo.
 *
 * @param scanner  Skener pre vstup dát
 */
  private void rentVehicle(Scanner scanner) {
    System.out.println("===== Rent a Vehicle =====");
    
    System.out.print("Enter customer name: ");
    String customerName = scanner.nextLine();
    Customer customer = new Customer(customerName);
    
    displayAvailableVehicles();
    
    System.out.print("Enter the brand of the vehicle to rent: ");
    String vehicleBrand = scanner.nextLine();
    System.out.print("Enter the model of the vehicle to rent: ");
    String vehicleModel = scanner.nextLine();
    
    Vehicle selectedVehicle = findAvailableVehicleByBrandAndModel(vehicleBrand, vehicleModel);
    
    if (selectedVehicle != null) {
        System.out.print("Enter rental days or hours: ");
        String daysOrHour = scanner.nextLine();

        System.out.print("Enter how long to rent: ");
        int howLong = scanner.nextInt();
        
        rent_vehicle(customer, selectedVehicle, daysOrHour, howLong);
    } else {
        System.out.println("Rental canceled.");
    }
}
/**
 * Vráťte vozidlo po prepožičaní.
 *
 * @param scanner  Skener pre vstup dát
 */
private void returnVehicle(Scanner scanner) {
    System.out.println("===== Return a Vehicle =====");
    System.out.print("Enter customer name: ");
    String customerName = scanner.nextLine();
    System.out.print("Enter the brand of the vehicle to return: ");
    String vehicleBrand = scanner.nextLine();
    System.out.print("Enter the model of the vehicle to return: ");
    String vehicleModel = scanner.nextLine();

    boolean vehicleReturned = false;

    for (RentStory rentRecord : rentStory) {
        Customer rentCustomer = rentRecord.getCustomer();
        Vehicle rentVehicle = rentRecord.getVehicle();

        if (customerName.equalsIgnoreCase(rentCustomer.getName()) &&
                vehicleBrand.equalsIgnoreCase(rentVehicle.getBrand()) &&
                vehicleModel.equalsIgnoreCase(rentVehicle.getModel()) &&
                rentRecord.getStatus() == RentStatus.RENTED) {
            return_vehicle(rentCustomer, rentVehicle);
            System.out.println("Vehicle returned successfully.");
            vehicleReturned = true;
            break;
        }
    }

    if (!vehicleReturned) {
        System.out.println("Invalid input or vehicle not found in rented records.");
    }
}
/**
 * Opravte vozidlo po návrate.
 *
 * @param scanner  Skener pre vstup dát
 */
private void repairVehicle(Scanner scanner) {
    System.out.println("===== Repair Vehicle =====");
    System.out.print("Enter the brand of the vehicle to repair: ");
    String vehicleBrand = scanner.nextLine();
    System.out.print("Enter the model of the vehicle to repair: ");
    String vehicleModel = scanner.nextLine();
    for (RentStory rentRecord : rentStory) {
        Vehicle rentVehicle = rentRecord.getVehicle();
        if (vehicleBrand.equalsIgnoreCase(rentVehicle.getBrand()) &&
                vehicleModel.equalsIgnoreCase(rentVehicle.getModel()) &&
                rentRecord.getStatus() == RentStatus.RENTED) {
            repairVehicle(rentVehicle);
            System.out.println("Vehicle repaired successfully.");
            break;
        }
    }
    }
/**
 * Nabite vozidlo.
 *
 * @param scanner  Skener pre vstup dát
 */
private void chargeVehicle(Scanner scanner){
    System.out.println("===== Charge Vehicle =====");
    System.out.print("Enter the brand of the vehicle to charge: ");
    String vehicleBrand = scanner.nextLine();
    System.out.print("Enter the model of the vehicle to charge: ");
    String vehicleModel = scanner.nextLine();
    System.out.print("Enter the percentage  to charge: ");
    int percentage = scanner.nextInt();
    for (RentStory rentRecord : rentStory) {
        Vehicle rentVehicle = rentRecord.getVehicle();
        if ( vehicleBrand.equalsIgnoreCase(rentVehicle.getBrand()) &&
                vehicleModel.equalsIgnoreCase(rentVehicle.getModel()) &&
                rentRecord.getStatus() == RentStatus.RENTED) {
            chargeVehicle(rentVehicle,percentage);
            if(rentVehicle instanceof ElectricVehicle){
                ElectricVehicle my_v =(ElectricVehicle)rentVehicle;
                System.out.println("Vehicle charged successfully and now it is:"+percentage + "%");
            break;
            }
            else{
                System.out.println("You cant charge non electric vehicle!");

            }
        }
        else{
            System.out.println("You cant charge  vehicle you didnt rent!");

        }
    }
}
/**
 * Natankujte vozidlo s naftou.
 *
 * @param scanner  Skener pre vstup dát
 */
private void fuelCar(Scanner scanner){
    System.out.println("===== Fuel Vehicle =====");
    System.out.print("Enter the brand of the vehicle to fuel: ");
    String vehicleBrand = scanner.nextLine();
    System.out.print("Enter the model of the vehicle to fuel: ");
    String vehicleModel = scanner.nextLine();
    System.out.print("Enter the amount of litrov you want to fuel(max:55): ");
    int litr = scanner.nextInt();
    for (RentStory rentRecord : rentStory) {
        Vehicle rentVehicle = rentRecord.getVehicle();
        if ( vehicleBrand.equalsIgnoreCase(rentVehicle.getBrand()) &&
                vehicleModel.equalsIgnoreCase(rentVehicle.getModel()) &&
                rentRecord.getStatus() == RentStatus.RENTED) {
            fuelCar(rentVehicle,litr);
            if(rentVehicle instanceof FuelVehicle){
                FuelVehicle my_v =(FuelVehicle)rentVehicle;
                System.out.println("Vehicle fuled successfully and now it is fuled to :"+litr);
            break;
            }
            else{
                System.out.println("You cant fuel non benzin vehicle!");

            }
        }
        else{
            System.out.println("You cant fuel  vehicle you didnt rent!");

        }
    }
}
/**
 * Zobrazte vozidlá, ktoré prenajal zákazník.
 *
 * @param scanner  Skener pre vstup dát
 */
public void displayVehiclesRentedByCustomer(Scanner scanner) {
    System.out.println("===== Display Vehicles Rented by Customer =====");
    System.out.print("Enter customer name: ");
    String customerName = scanner.nextLine();

    boolean customerFound = false;
    
    for (RentStory rentRecord : rentStory) {
        if (customerName.equalsIgnoreCase(rentRecord.getCustomer().getName())) {
            System.out.println("---------------");
            System.out.println("Customer: " + rentRecord.getCustomer().getName());
            System.out.println("Vehicle: " + rentRecord.getVehicle().getModel());
            System.out.println("Status: " + rentRecord.getStatus());
            System.out.println("---------------");
            Vehicle v = rentRecord.getVehicle();
            System.out.println("Brand: " + v.getBrand());
            System.out.println("Model: " + v.getModel());
            System.out.println("Year: " + v.getYear());
            System.out.println("Hourly Rental Rate: $" + v.getHourlyRentalRate());
            System.out.println("Daily Rental Rate: $" + v.getDailyRentalRate());
            if(v instanceof ElCar){
                ElCar my_el_car = (ElCar)v;
                System.out.println("Number of seats: " + my_el_car.getNumberOfSeats());
                System.out.println("Baterie level: " + my_el_car.getBatteryPercentage() + "%");
                System.out.println("Charging time: " + my_el_car.getChargingTime());
            }
            else if (v instanceof Car){
                Car my_car = (Car)v;
                System.out.println("Number of seats: " + my_car.getNumberOfSeats());
                System.out.println("Fuel type: " + my_car.getFuelType());
                System.out.println("Fuel level: " + my_car.getFuelLevel());
            }
             else if(v instanceof Ebike){
                Ebike my_ebike = (Ebike)v;
                System.out.println("Baterie level: " + my_ebike.getBatteryPercentage());
                System.out.println("Does it have light? " + my_ebike.hasLights());
                System.out.println("Is it foldable? " + my_ebike.isFoldable());

            }
            else if(v instanceof Bike){
                Bike my_bike = (Bike)v;
                System.out.println("Number of gears: " + my_bike.getPocetPrevodov());
                System.out.println("Does bike have basket?: " + my_bike.maKosik());
            }

            else if(v instanceof Scooter){
                Scooter my_scooter = (Scooter)v;
                System.out.println("Baterie level: " + my_scooter.getBatteryPercentage());
            }
            
            System.out.println("---------------");
        customerFound = true;
    }
}

if (!customerFound) {
    System.out.println("No records found for the customer: " + customerName);
}
}
/**
 * Uložte informácie o dostupných vozidlách do súboru.
 */
public void saveAvailableVehiclesToFile() {
    System.out.println("===== Saving Available Vehicles to File =====");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("available_vehicles.txt"))) {
        displayAndWriteAvailableVehicles(writer);

        System.out.println("Data saved to 'available_vehicles.txt'");
    } catch (IOException e) {
        System.out.println("Error occurred while writing to the file: " + e.getMessage());
    }
}
/**
 * Zobrazuje dostupné vozidlá a ukladá ich informácie do súboru.
 *
 * @param writer {@code BufferedWriter} objekt pre zápis do súboru
 * @throws IOException Výnimka, ktorá môže nastať pri práci so súborom
 */
private void displayAndWriteAvailableVehicles(BufferedWriter writer) throws IOException {
    System.out.println("Available Vehicles:");
    for (Vehicle v : Rental_agency_cars) {
        if (!Rentaled_cars.contains(v)) {
            System.out.println("---------------");
            writer.write("---------------\n");
            writer.write("Brand: " + v.getBrand() + "\n");
            writer.write("Model: " + v.getModel() + "\n");
            writer.write("Year: " + v.getYear() + "\n");
            writer.write("Hourly Rental Rate: $" + v.getHourlyRentalRate() + "\n");
            writer.write("Daily Rental Rate: $" + v.getDailyRentalRate() + "\n");

            if (v instanceof ElCar) {
                ElCar my_el_car = (ElCar) v;
                writer.write("Number of seats: " + my_el_car.getNumberOfSeats() + "\n");
                writer.write("Battery level: " + my_el_car.getBatteryPercentage() + "%\n");
                writer.write("Charging time: " + my_el_car.getChargingTime() + "\n");
            } else if (v instanceof Car) {
                Car my_car = (Car) v;
                writer.write("Number of seats: " + my_car.getNumberOfSeats() + "\n");
                writer.write("Fuel type: " + my_car.getFuelType() + "\n");
                writer.write("Fuel level: " + my_car.getFuelLevel() + "\n");
            } else if (v instanceof Ebike) {
                Ebike my_ebike = (Ebike) v;
                writer.write("Battery level: " + my_ebike.getBatteryPercentage() + "\n");
                writer.write("Does it have light? " + my_ebike.hasLights() + "\n");
                writer.write("Is it foldable? " + my_ebike.isFoldable() + "\n");
            } else if (v instanceof Bike) {
                Bike my_bike = (Bike) v;
                writer.write("Number of gears: " + my_bike.getPocetPrevodov() + "\n");
                writer.write("Does bike have basket?: " + my_bike.maKosik() + "\n");
            } else if (v instanceof Scooter) {
                Scooter my_scooter = (Scooter) v;
                writer.write("Battery level: " + my_scooter.getBatteryPercentage() + "\n");
            }
            writer.write("---------------\n");
        }
    }
    writer.close();
}



}




    
    
