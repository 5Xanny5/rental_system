/**
 * Trieda Bike reprezentuje bicykel, ktorý je podtypom vozidla.
 */
public class Bike extends Vehicle {
    /** Počet prevodov vozidla. */
    private int numberOfGears;  
    /**Prítomnosť košíka vozidla. */
     private String hasBasket;  

    /**
     * Konštruktor pre triedu Bike.
     *
     * @param brand Značka bicykla.
     * @param model Model bicykla.
     * @param year Rok výroby bicykla.
     * @param hourlyRentalRate Cena prenájmu za hodinu.
     * @param dailyRentalRate Cena prenájmu za deň.
     * @param numberOfGears Počet prevodov.
     * @param hasBasket Prítomnosť košíka.
     */
    public Bike(String brand, String model, int year, double hourlyRentalRate,
                int numberOfGears, String hasBasket) {
        super(brand, model, year, hourlyRentalRate);
        this.numberOfGears = numberOfGears;
        this.hasBasket = hasBasket;
    }

    /**
     * Vráti počet prevodov bicykla.
     *
     * @return Počet prevodov.
     */
    public int getPocetPrevodov() {
        return numberOfGears;
    }

    /**
     * Nastaví počet prevodov bicykla.
     *
     * @param numberOfGears Počet prevodov.
     */
    public void setPocetPrevodov(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    /**
     * Overí, či má bicykel košík.
     *
     * @return true, ak má košík, false inak.
     */
    public String maKosik() {
        if (hasBasket == "yes"){
            return "yes" ;
    }
    return "no";
    }

    /**
     * Nastaví prítomnosť košíka na bicykli.
     *
     * @param hasBasket true, ak má košík, false inak.
     */
    public void setMaKosik(String hasBasket) {
        this.hasBasket = hasBasket;
    }
        /**
     * Výpočet ceny prenájmu na krátku dobu pre bike.
     *
     * @param hours Počet hodín prenájmu.
     * @return Cena prenájmu na krátku dobu.
     */
    @Override
    public double calculateShortRentalCost(int hours) {
        return hours*getHourlyRentalRate();
    }

    /**
     * Výpočet ceny prenájmu na dlhú dobu pre bike.
     *
     * @param days Počet dní prenájmu.
     * @return Cena prenájmu na dlhú dobu.
     */
    @Override
    public double calculateRentalCost(int days) {
        return days*getDailyRentalRate();
    }
    @Override
    public double calculateRepairCost() {
        double baseRepairCost = 50.0;
        double partsCost = 20.0;
        int hoursOfWork = 1;
        return baseRepairCost + partsCost + (hoursOfWork);
    }
}
