/**
 * Trieda Ebike reprezentuje elektrický bicykel, ktorý je podtypom bicykla.
 * Rozširuje abstraktnú triedu Bike a implementuje rozhranie ElectricVehicle.
 *
 * @author (Your Name)
 * @version (Version number or date)
 */
public class Ebike extends Bike implements ElectricVehicle {
    /** Kapacita batérie elbike. */
    private int batteryPercentage; 
    /** Prítomnosť svetiel */
    private String hasLights;   
    /** Skladateľný bicykel */
    private String isFoldable;  

    /**
     * Konštruktor pre triedu Ebike.
     *
     * @param brand Značka bicykla.
     * @param model Model bicykla.
     * @param year Rok výroby bicykla.
     * @param hourlyRentalRate Cena prenájmu za hodinu.
     * @param numberOfGears Počet prevodov.
     * @param hasBasket Prítomnosť košíka.
     * @param batteryPercentage Kapacita batérie.
     * @param hasLights Prítomnosť svetiel.
     * @param isFoldable Skladateľný bicykel.
     */
    public Ebike(String brand, String model, int year, double hourlyRentalRate, 
                 int numberOfGears, String hasBasket, int batteryPercentage,
                 String hasLights, String isFoldable) {
        super(brand, model, year, hourlyRentalRate, numberOfGears, hasBasket);
        this.batteryPercentage = batteryPercentage;
        this.hasLights = hasLights;
        this.isFoldable = isFoldable;
    }
    
    /**
     * Nastaví kapacitu batérie elektrického bicykla.
     *
     * @param batteryPercentage Kapacita batérie.
     */
    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
    
    /**
     * Overí, či má elektrický bicykel svetlá.
     *
     * @return true, ak má svetlá, false inak.
     */
    public String hasLights() {
        return (hasLights.equals("yes")) ? "yes" : "no";
    }

    /**
     * Nastaví prítomnosť svetiel na elektrickom bicykli.
     *
     * @param hasLights true, ak má svetlá, false inak.
     */
    public void setHasLights(String hasLights) {
        this.hasLights = hasLights;
    }

    /**
     * Overí, či je bicykel skladateľný.
     *
     * @return true, ak je bicykel skladateľný, false inak.
     */
    public String isFoldable() {
        return (isFoldable.equals("yes")) ? "yes" : "no";
    }

    /**
     * Nastaví, či je bicykel skladateľný.
     *
     * @param foldable true, ak je bicykel skladateľný, false inak.
     */
    public void setFoldable(String foldable) {
        isFoldable = foldable;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void charge(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculateRepairCost() {
        double baseRepairCost = 80.0;
        double partsCost = 40.0;
        int hoursOfWork = 2;
        return baseRepairCost + partsCost + hoursOfWork;
    }
}
