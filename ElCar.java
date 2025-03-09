/**
 * Trieda ElCar reprezentuje elektrické auto.
 * Rozširuje abstraktnú triedu Car a implementuje rozhranie ElectricVehicle.
 *
 * @author (Your Name)
 * @version (Version number or date)
 */
public class ElCar extends Car implements ElectricVehicle {
    /** Kapacita batérie vozidla. */
    private int batteryCapacity;
    /** Čas nabíjania (v hodinách).*/
    private int chargingTime;

    /**
     * Konštruktor pre triedu ElCar.
     *
     * @param brand            Značka elektrického auta.
     * @param model            Model elektrického auta.
     * @param year             Rok výroby elektrického auta.
     * @param hourlyRentalRate Cena prenájmu za hodinu.
     * @param batteryCapacity  Kapacita batérie.
     * @param chargingTime     Čas nabíjania (v hodinách).
     * @param electricRange    Elektrický dojazd (v kilometroch).
     * @param numberOfSeats    Počet sedadiel v aute.
     */
    public ElCar(String brand, String model, int year, double hourlyRentalRate,
                 int batteryCapacity, int chargingTime, int electricRange, int numberOfSeats) {
        super(brand, model, year, hourlyRentalRate, numberOfSeats, "It is electric");
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    /**
     * Vráti kapacitu batérie elektrického auta.
     *
     * @return Kapacita batérie.
     */
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    /**
     * Nastaví kapacitu batérie elektrického auta.
     *
     * @param batteryCapacity Kapacita batérie.
     */
    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    /**
     * Vráti čas nabíjania elektrického auta (v hodinách).
     *
     * @return Čas nabíjania (v hodinách).
     */
    public int getChargingTime() {
        return chargingTime;
    }

    /**
     * Nastaví čas nabíjania elektrického auta (v hodinách).
     *
     * @param chargingTime Čas nabíjania (v hodinách).
     */
    public void setChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBatteryPercentage() {
        return batteryCapacity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void charge(int batteryPercentage) {
        batteryCapacity = batteryPercentage;
    }
}
