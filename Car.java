
// The class which represents a car
public class Car extends Vehicle implements FuelVehicle {
     /** Cislo sedadiel auto vozidla. */
    private int numberOfSeats;
    /** Typ paliva  vozidla. */
    private String fuelType;
    /** Kolko je fuel */
    private double fuelLevel;

    /**
     * Konštruktor pre triedu Car.
     *
     * @param brand Značka vozidla.
     * @param model Model vozidla.
     * @param year Rok výroby vozidla.
     * @param hourlyRentalRate Cena prenájmu za hodinu.
     * @param dailyRentalRate Cena prenájmu za deň.
     * @param numberOfSeats Počet sedadiel v aute.
     * @param fuelType Typ paliva, napr. benzín, nafta.
     */
    public Car(String brand, String model, int year, double hourlyRentalRate,
               int numberOfSeats, String fuelType) {
        super(brand, model, year, hourlyRentalRate);
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.fuelLevel = 100;
    }

    /**
     * Získaj počet sedadiel v aute.
     *
     * @return Počet sedadiel.
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Nastaví počet sedadiel v aute.
     *
     * @param numberOfSeats Nový počet sedadiel.
     */
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Získaj typ paliva.
     *
     * @return Typ paliva.
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Nastaví typ paliva.
     *
     * @param fuelType Nový typ paliva.
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Výpočet ceny prenájmu na krátku dobu pre auto.
     *
     * @param hours Počet hodín prenájmu.
     * @return Cena prenájmu na krátku dobu.
     */
    @Override
    public double calculateShortRentalCost(int hours) {
        
        return hours*getHourlyRentalRate();
    }

    /**
     * Výpočet ceny prenájmu na dlhú dobu pre auto.
     *
     * @param days Počet dní prenájmu.
     * @return Cena prenájmu na dlhú dobu.
     */
    @Override
    public double calculateRentalCost(int days) {
      
        return getDailyRentalRate()*days;
    }
          /**
     * Získa aktuálnu úroveň paliva vozidla.
     *
     * @return Aktuálna úroveň paliva v litroch.
     */
    public double getFuelLevel(){
        return fuelLevel;
        
    }

    /**
     * Zatankuje palivo vozidla na určenú úroveň.
     *
     * @param fuelLevel Cieľová úroveň paliva na natankovanie.
     */
    public void refuel(double fuelLevel){
         System.out.println("Fueling  vehicle to " + (getFuelLevel() * 1.0 / 100) + "%.");
    }
     @Override
    public double calculateRepairCost() {
        // Car repair cost logic
        double baseRepairCost = 200.0;
        double partsCost = 100.0;
        int hoursOfWork = 3;
        return baseRepairCost + partsCost + (hoursOfWork );
    }
    
}
