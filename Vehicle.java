/**
 * Abstraktná trieda predstavujúca vozidlo, ktoré je možné prenajať.
 * Obsahuje informácie o značke, modeli, roku a cenách prenájmu.
 */
public abstract class Vehicle {
    /** Značka vozidla. */
    private String brand;
    /** Model vozidla. */
    private String model;
    /** Rok výroby vozidla. */
    private int year;
    /** Cena prenájmu za hodinu. */
    private double hourlyRentalRate;
    /** Cena prenájmu za deň. */
    private double dailyRentalRate;
    /**
     * Konštruktor pre abstraktnú triedu Vehicle.
     *
     * @param brand Značka vozidla.
     * @param model Model vozidla.
     * @param year Rok výroby vozidla.
     * @param hourlyRentalRate Cena prenájmu za hodinu.
     * @param dailyRentalRate Cena prenájmu za deň.
     */
    public Vehicle(String brand, String model, int year, double hourlyRentalRate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.hourlyRentalRate = hourlyRentalRate;
        this.dailyRentalRate = hourlyRentalRate*24;
    }
     /**
     * Získaj značku vozidla.
     *
     * @return Značka vozidla.
     */
    public String getBrand() {
        return brand;
    }
    /**
     * Nastaví značku vozidla.
     *
     * @param brand Nová značka vozidla.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
     /**
     * Získaj model vozidla.
     *
     * @return model vozidla.
     */
    public String getModel() {
        return model;
    }
    /**
     * Nastaví model vozidla.
     *
     * @param model Novy model vozidla.
     */
    public void setModel(String model) {
        this.model = model;
    }
     /**
     * Získaj rok vozidla.
     *
     * @return rok vozidla.
     */
    public int getYear() {
        return year;
    }
     /**
     * Nastaví rok vozidla.
     *
     * @param model Novy rok vozidla.
     */
    public void setYear(int year) {
        this.year = year;
    }
     /**
     * Získaj cenu za hodinu prenájmu vozidla.
     *
     * @return cenu za hodinu prenájmu vozidla.
     */
    public double getHourlyRentalRate() {
        return hourlyRentalRate;
    }
     /**
     * Nastaví cenu za hodinu prenájmu vozidla.
     *
     * @param cena za hodinu prenájmu Nova cena za hodinu prenájmu.
     */
    public void setHourlyRentalRate(double hourlyRentalRate) {
        this.hourlyRentalRate = hourlyRentalRate;
    }
     /**
     * Získaj cenu za den vozidla.
     *
     * @return cenu za den vozidla.
     */
    public double getDailyRentalRate() {
        return dailyRentalRate;
    }
     /**
     * Nastaví cenu za den prenájmu  vozidla.
     *
     * @param cena za den prenájmu Nova cena za den prenájmu.
     */
    public void setDailyRentalRate(double dailyRentalRate) {
        this.dailyRentalRate = dailyRentalRate;
    }

    /**
     * Abstraktná metóda pre výpočet ceny prenájmu na krátku dobu (hodiny).
     *
     * @param hours Počet hodín prenájmu.
     * @return Cena prenájmu na krátku dobu.
     */
    public abstract double calculateShortRentalCost(int hours);
    /**
     * Abstraktná metóda pre výpočet ceny prenájmu na dlhú dobu (dni).
     *
     * @param days Počet dní prenájmu.
     * @return Cena prenájmu na dlhú dobu.
     */
    public abstract double calculateRentalCost(int days);
    /**
     * Abstraktná metóda pre výpočet ceny opravy vozidla.
     *
     * @return Cena opravy vozidla.
     */
    public  abstract double calculateRepairCost();
}
